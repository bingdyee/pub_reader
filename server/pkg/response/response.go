package response

import (
	"net/http"
	"pub-reader/pkg/errno"

	"github.com/gin-gonic/gin"
)

type ApiResponse struct {
	Code    int    `json:"code"`
	Message string `json:"message"`
	Success bool   `json:"success"`
	Data    any    `json:"data,omitempty"`
}

func Ok(ctx *gin.Context) {
	ctx.JSON(http.StatusOK, errno.OK)
}

func Success(ctx *gin.Context, data any) {
	ctx.JSON(http.StatusOK, ApiResponse{
		Code:    errno.OK.Code,
		Message: errno.OK.Message,
		Success: true,
		Data:    data,
	})
}

func Failure(ctx *gin.Context, err error) {
	ctx.JSON(http.StatusOK, err)
}
