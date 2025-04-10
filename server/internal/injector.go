package internal

import (
	"github.com/gin-gonic/gin"
	"github.com/google/wire"
)

var ContainerSet = wire.NewSet(

	wire.Struct(new(Container), "*"),
)

type Container struct {
}

func (container Container) RegisterRoutes(r *gin.Engine) {

}
