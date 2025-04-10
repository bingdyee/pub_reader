package utils

import (
	"github.com/golang-jwt/jwt/v4"
	"time"
)

type UserClaims struct {
	UserId    uint64   `json:"userId"`
	Username  string   `json:"username"`
	PermCodes []string `json:"permCodes"`
	jwt.RegisteredClaims
}

func GenerateToken(claims UserClaims, secret string, expireAt int) (string, error) {
	signKey := []byte(secret)
	now := time.Now()
	expireTime := now.Add(time.Duration(expireAt) * time.Second)
	claims.ExpiresAt = jwt.NewNumericDate(expireTime)
	claims.Issuer = "septars"
	token := jwt.NewWithClaims(jwt.SigningMethodHS256, claims)
	return token.SignedString(signKey)
}

func VerifyToken(tokenStr string, secret string) (*UserClaims, error) {
	token, err := jwt.ParseWithClaims(tokenStr, &UserClaims{}, func(token *jwt.Token) (any, error) {
		return []byte(secret), nil
	})
	if token != nil {
		if claims, ok := token.Claims.(*UserClaims); ok && token.Valid {
			return claims, nil
		}
	}
	return nil, err
}
