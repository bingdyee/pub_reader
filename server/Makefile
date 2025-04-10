tidy:
	@go mod tidy

wire: cmd/wire.go
	@wire gen ./cmd

swag-init:
	@swag init -g cmd/main.go -o docs

build:
	@go build -o server cmd/main.go cmd/wire_gen.go

dev: wire swag-init
	@air --build.cmd "go build -o tmp/main cmd/main.go cmd/wire_gen.go" server --port 8080

