package middleware

import (
	"net/http"
	"pub-reader/config"
	"pub-reader/pkg/errno"
	"pub-reader/pkg/utils"
	"regexp"
	"strings"

	"github.com/gin-gonic/gin"
	"github.com/spf13/viper"
)

func AuthMiddleware(c *gin.Context) {
	tokenHeader := c.Request.Header.Get("Authorization")
	bearerToken := strings.SplitN(tokenHeader, " ", 2)
	if len(bearerToken) != 2 && bearerToken[0] != "Bearer" {
		c.AbortWithStatusJSON(http.StatusOK, errno.UnAuth)
		return
	}

	claims, err := utils.VerifyToken(bearerToken[1], viper.GetString(config.JwtSecretKey))
	if err != nil {
		c.AbortWithStatusJSON(http.StatusOK, errno.AuthExpired)
		return
	}
	res := c.Request.Method + ":" + c.Request.RequestURI
	var matched bool
	for _, permCode := range claims.PermCodes {
		if matched, _ = regexp.MatchString(permCode, res); matched {
			break
		}
	}
	if !matched {
		c.AbortWithStatusJSON(http.StatusOK, errno.Forbidden)
		return
	}
	c.Set("UserInfo", claims)
	c.Next()
}

func Cors(origin string) gin.HandlerFunc {
	return func(c *gin.Context) {
		method := c.Request.Method
		if origin == "" {
			origin = "*"
		}
		c.Header("Access-Control-Allow-Origin", origin)
		c.Header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, UPDATE")
		c.Header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization")
		c.Header("Access-Control-Expose-Headers", "Content-Length, Access-Control-Allow-Origin, Access-Control-Allow-Headers, Cache-Control, Content-Language, Content-Type")
		c.Header("Access-Control-Allow-Credentials", "true")

		if method == "OPTIONS" {
			c.AbortWithStatus(http.StatusNoContent)
		}

		c.Next()
	}
}
