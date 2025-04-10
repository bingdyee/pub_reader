package utils

import (
	"testing"
)

const secret = "abcdefghijk"

var claims = UserClaims{
	UserId:    1,
	Username:  "bingdyee",
	PermCodes: []string{"root", "admin"},
}

const defaultToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEsInVzZXJuYW1lIjoiYmluZ2R5ZWUiLCJwZXJtQ29kZXMiOlsicm9vdCIsImFkbWluIl0sImlzcyI6IkVwaXN0ZW1ldGEiLCJleHAiOjE2NTk0MTUwNDR9.evbl-WQgUMMSZxYY4ce4x6tVRnyiHsMSQRplSWQXwsg"

func TestGenerateToken(t *testing.T) {
	token, err := GenerateToken(claims, secret, 7200)
	if err != nil {
		t.Fatal(err)
	}
	t.Log(token)
}

func TestVerifyToken(t *testing.T) {
	userClaims, _ := VerifyToken(defaultToken, secret)
	t.Log(userClaims)
	if claims.Username != userClaims.Username {
		t.Fatal()
	}
}

func TestNextID(t *testing.T) {
	t.Log(NextID())
}
