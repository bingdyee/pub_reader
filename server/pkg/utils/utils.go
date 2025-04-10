package utils

import (
	"context"
	"log"
	"net/http"
	"os"
	"os/signal"
	"syscall"
	"time"
)

const (
	DATETIME_FMT string = "2006-01-02 15:04:05"
	DATE_FMT     string = "2006-01-02"
)

func UnixToTime(timestamp int) string {
	t := time.Unix(int64(timestamp), 0)
	return t.Format(DATETIME_FMT)
}

func TimeToUnix(str string) int64 {
	t, err := time.ParseInLocation(DATETIME_FMT, str, time.Local)
	if err != nil {
		return 0
	}
	return t.Unix()
}

func CurrentTimestamp() int64 {
	return time.Now().Unix()
}

func FormatNow(str string) string {
	t := time.Now()
	return t.Format(str)
}

func FormatCurDatetime() string {
	t := time.Now()
	return t.Format(DATETIME_FMT)
}

func GracefullyShutdown(srv *http.Server) {
	// Wait for interrupt signal to gracefully shutdown the server with
	// a timeout of 5 seconds.
	quit := make(chan os.Signal, 1)
	// kill (no param) default send syscall.SIGTERM
	// kill -2 is syscall.SIGINT
	// kill -9 is syscall.SIGKILL but can't be catch, so don't need add it
	signal.Notify(quit, syscall.SIGINT, syscall.SIGTERM)
	<-quit
	log.Println("Shutting down server gracefully...")
	// The context is used to inform the server it has 5 seconds to finish
	// the request it is currently handling
	ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
	defer cancel()
	if err := srv.Shutdown(ctx); err != nil {
		log.Fatal("Server forced to shutdown: ", err)
	}
	log.Println("Server exiting!")
}

func If(cond bool, tVal, fVal any) any {
	if cond {
		return tVal
	}
	return fVal
}
