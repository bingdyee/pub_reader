package main

import (
	"errors"
	"fmt"
	"github.com/gin-gonic/gin"
	"github.com/spf13/viper"
	swaggerFiles "github.com/swaggo/files"
	ginSwagger "github.com/swaggo/gin-swagger"
	"net/http"
	"pub-reader/config"
	"pub-reader/docs"
	"pub-reader/pkg/logging"
	"pub-reader/pkg/middleware"
	"pub-reader/pkg/response"
	"pub-reader/pkg/utils"
	"runtime"
)

// @title [CNSF] Pub Reader API Docs
// @version 1.0.0
// @description 中国科幻网 | CNSF(China Science Fiction)
// @contact.name Bing D. Yee
// @contact.url https://github.com/bingdyee
// @contact.email bingdyee@gmail.com
// @BasePath /
func main() {
	runtime.SetMutexProfileFraction(1)
	runtime.SetBlockProfileRate(1)
	config.InitConfig()
	container, err := BuildContainer()
	if err != nil {
		logging.Log.Panic(err)
	}
	engine := gin.Default()
	engine.NoMethod(response.HandleNotFound)
	engine.NoRoute(response.HandleNotFound)
	engine.MaxMultipartMemory = 8 << 20
	engine.Use(middleware.Cors("*"))
	docs.SwaggerInfo.BasePath = "/api/v1"
	engine.GET("/swagger/*any", ginSwagger.WrapHandler(swaggerFiles.Handler))

	container.RegisterRoutes(engine)
	server := &http.Server{
		Addr:    fmt.Sprintf(":%d", viper.GetInt(config.ServerPortKey)),
		Handler: engine,
	}
	go func() {
		if err := server.ListenAndServe(); err != nil && !errors.Is(err, http.ErrServerClosed) {
			logging.Log.Fatal("listen: ", err)
		}
	}()
	utils.GracefullyShutdown(server)
}
