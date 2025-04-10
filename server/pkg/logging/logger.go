package logging

import (
	"bytes"
	"fmt"
	"io"
	"log"
	"pub-reader/pkg/utils"
	"os"
	"os/user"
	"path"
	"path/filepath"
	"runtime"
	"strconv"
	"strings"

	"github.com/sirupsen/logrus"
)

var Log *logrus.Logger

func init() {
	logger := logrus.New()
	src, _ := setOutputFile()
	//config log output
	writers := []io.Writer{src, os.Stdout}
	output := io.MultiWriter(writers...)
	logger.SetOutput(output)
	//config log level
	logger.SetLevel(logrus.InfoLevel)
	//config log format
	logger.SetFormatter(new(LogFormatter))
	logger.SetReportCaller(true)
	Log = logger
}

func setOutputFile() (*os.File, error) {
	now := utils.FormatNow("2006-01-02")
	logFilePath := ""
	// using user home dir
	if dir, err := user.Current(); err == nil {
		logFilePath = dir.HomeDir + "/logs/"
	}
	//if dir, err := os.Getwd(); err == nil {
	//	logFilePath = dir + "/logs/"
	//}
	_, err := os.Stat(logFilePath)
	if os.IsNotExist(err) {
		if err := os.MkdirAll(logFilePath, 0777); err != nil {
			log.Println(err.Error())
			return nil, err
		}
	}
	logFileName := fmt.Sprintf("novelogic.%s.log", now)
	//log file
	fileName := path.Join(logFilePath, logFileName)
	if _, err := os.Stat(fileName); err != nil {
		if _, err := os.Create(fileName); err != nil {
			log.Println(err.Error())
			return nil, err
		}
	}
	//write to file
	src, err := os.OpenFile(fileName, os.O_APPEND|os.O_WRONLY, os.ModeAppend)
	if err != nil {
		log.Println(err)
		return nil, err
	}
	return src, nil
}

type LogFormatter struct {
}

func GetGID() uint64 {
	b := make([]byte, 64)
	b = b[:runtime.Stack(b, false)]
	b = bytes.TrimPrefix(b, []byte("goroutine "))
	b = b[:bytes.IndexByte(b, ' ')]
	n, _ := strconv.ParseUint(string(b), 10, 64)
	return n
}

func (s *LogFormatter) Format(entry *logrus.Entry) ([]byte, error) {
	timestamp := utils.FormatCurDatetime()
	var file string
	var length int
	if entry.Caller != nil {
		file = filepath.Base(entry.Caller.File)
		length = entry.Caller.Line
	}
	level := strings.ToUpper(entry.Level.String())
	msg := fmt.Sprintf("%s %s %d [%s:%d] : %s\n", timestamp, level, GetGID(), file, length, entry.Message)
	return []byte(msg), nil
}
