//go:build wireinject
// +build wireinject

package main

import (
	"github.com/google/wire"
	"pub-reader/internal"
)

// nolint:all
func BuildContainer() (*internal.Container, error) {
	wire.Build(
		//config.InitDB,
		internal.ContainerSet,
	)
	return new(internal.Container), nil
}
