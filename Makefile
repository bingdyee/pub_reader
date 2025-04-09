PROJECT_NAME = novelogic
PROJECT_VERSION = latest

.PHONY:docs

docs:
	@docsify serve docs

web:
	@cd web && npm run dev

