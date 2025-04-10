package config

import (
	"flag"
	"fmt"
	"gorm.io/driver/mysql"
	"gorm.io/gorm"
	"gorm.io/gorm/logger"
	"os"
	"pub-reader/pkg/logging"
	"time"

	"github.com/spf13/viper"
)

const (
	ServerPortKey string = "Server.port"
	AppNameKey    string = "Application.name"
	DBHostKey     string = "Datasource.host"
	DBPortKey     string = "Datasource.port"
	DBSchemaKey   string = "Datasource.schema"
	DBUsernameKey string = "Datasource.user"
	DBPasswordKey string = "Datasource.password"
	JwtSecretKey  string = "Security.secret"
)

func InitConfig() {
	var conf string
	flag.StringVar(&conf, "c", "", "app config file(.yml)")
	flag.Parse()
	if conf != "" {
		logging.Log.Info("Using target config file: " + conf)
		viper.SetConfigFile(conf)
	} else {
		logging.Log.Info("Using default config.")
		workDir, _ := os.Getwd()
		viper.SetConfigName("config")
		viper.SetConfigType("yml")
		viper.AddConfigPath(workDir + "/")
	}
	if err := viper.ReadInConfig(); err != nil {
		panic(err)
	}
}

func InitDB() (*gorm.DB, error) {
	host := viper.GetString(DBHostKey)
	port := viper.GetInt(DBPortKey)
	user := viper.GetString(DBUsernameKey)
	password := viper.GetString(DBPasswordKey)
	schema := viper.GetString(DBSchemaKey)
	dsn := fmt.Sprintf("%s:%s@tcp(%s:%d)/%s?charset=utf8mb4&parseTime=True&loc=Local", user, password, host, port, schema)
	db, err := gorm.Open(mysql.Open(dsn), &gorm.Config{
		Logger: logger.Default.LogMode(logger.Info),
	})
	if db == nil || err != nil {
		logging.Log.Panic(err)
		return nil, err
	}
	db.Callback().Create().Before("gorm:create").Register("create_time", timeCreateCallback)
	db.Callback().Update().Before("gorm:update").Register("update_time", timeUpdateCallback)
	return db, nil
}

func timeCreateCallback(db *gorm.DB) {
	now := time.Now()
	db.Statement.SetColumn("create_time", now)
	db.Statement.SetColumn("update_time", now)
}

func timeUpdateCallback(db *gorm.DB) {
	db.Statement.SetColumn("update_time", time.Now())
}
