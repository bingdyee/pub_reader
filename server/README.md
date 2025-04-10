# Pub Reader Server

## Build Docker
```shell
docker build . -t cnsf/server:latest
```

## Project Dependencies

```shell
# web
go get -u github.com/gin-gonic/gin
# wire
go get -u github.com/google/wire
go install github.com/google/wire/cmd/wire@latest
# jwt
go get -u github.com/golang-jwt/jwt/v4
# load config
go get -u github.com/spf13/viper
# log
go get -u github.com/sirupsen/logrus
# snowflake id
go get -u github.com/sony/sonyflake
# object copy
go get -u github.com/jinzhu/copier
# db using sqlite
go get -u gorm.io/gorm
 go get -u gorm.io/driver/mysql
# go get -u gorm.io/driver/sqlite
# langchain
go get -u github.com/tmc/langchaingo
# excel
go get github.com/xuri/excelize/v2
# web crawler
go get -u github.com/gocolly/colly/v2
# swagger
go install github.com/swaggo/swag/cmd/swag@latest
swag init -g cmd/main.go -o docs
go get -u github.com/swaggo/gin-swagger
go get -u github.com/swaggo/files
#  http://localhost:8080/swagger/index.html
#go mod download 下载 go.mod 文件中指明的所有依赖
#go mod tidy 整理现有的依赖，删除未使用的依赖。
#go mod graph 查看现有的依赖结构
#go mod init 生成 go.mod 文件 (Go 1.13 中唯一一个可以生成 go.mod 文件的子命令)
#go mod edit 编辑 go.mod 文件
#go mod vendor 导出现有的所有依赖 (事实上 Go modules 正在淡化 Vendor 的概念)
#go mod verify 校验一个模块是否被篡改过
#go clean -modcache 清理所有已缓存的模块版本数据。
#go mod 查看所有 go mod的使用命令。

# hot load
go install github.com/air-verse/air@latest
# go crawler
go get -u github.com/gocolly/colly/v2@latest

# github
git clone https://github.moeyy.xyz/{}
```

