PROJECT_NAME = pub-reader
PROJECT_VERSION = latest

.PHONY:docs web server

docs:
	@docsify serve docs

web:
	@cd web && npm run dev

server:
	@cd server && ./gradlew bootRun


