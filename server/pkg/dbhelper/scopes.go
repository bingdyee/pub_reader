package dbhelper

import (
	"gorm.io/gorm"
)

func Paginate(page, size int) func(db *gorm.DB) *gorm.DB {
	return func(db *gorm.DB) *gorm.DB {
		if page <= 0 {
			page = 1
		}
		switch {
		case size > 100:
			size = 100
		case size <= 0:
			size = 10
		}
		offset := (page - 1) * size
		return db.Offset(offset).Limit(size)
	}
}

func Range(field string, rangeQry RangeQuery) func(db *gorm.DB) *gorm.DB {
	return func(db *gorm.DB) *gorm.DB {
		if rangeQry.From != nil {
			db = db.Where(field+" >= ?", rangeQry.From)
		}
		if rangeQry.To != nil {
			db = db.Where(field+" < ?", rangeQry.To)
		}
		return db
	}
}
