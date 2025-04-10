# Build image
FROM golang:1.23-alpine AS builder
WORKDIR /app
COPY . .
# For CGO_ENABLED=1
RUN apk add --no-cache --update git build-base
RUN go env -w GO111MODULE=on \
    && go env -w GOPROXY=https://goproxy.cn,direct  \
    && go env -w CGO_ENABLED=1  \
    && go env \
    && go mod tidy  \
    && go build -o server ./cmd
#    && go build -o server cmd/main.go cmd/wire_gen.go

# Production image
FROM alpine:latest AS runner

WORKDIR /app

# For CGO_ENABLED=1
RUN apk --no-cache add ca-certificates tzdata libc6-compat libgcc libstdc++

COPY --from=builder /app/server ./
COPY --from=builder /app/resources ./resources

EXPOSE 8080

ENTRYPOINT ["/app/server", "-c", "/app/resources/config.yml"]
