package response

import (
	"pub-reader/pkg/errno"
	"pub-reader/pkg/logging"

	"github.com/gin-gonic/gin"
)

func HandleNotFound(ctx *gin.Context) {
	Failure(ctx, errno.NotFound)
}

func Recovery(ctx *gin.Context) {
	defer func() {
		if err := recover(); err != nil {
			logging.Log.Println("Exec error: %v", err)
			Failure(ctx, err.(error))
		}
		ctx.Abort()
	}()
	ctx.Next()
}
