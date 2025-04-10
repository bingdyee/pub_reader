package response

type Pages struct {
	PageNum       int   `json:"pageNum"`
	PageSize      int   `json:"pageSize"`
	TotalPage     int   `json:"totalPage"`
	TotalElements int64 `json:"totalElements"`
	Content       any   `json:"content"`
}

func NewPages(pageNum, pageSize int, totalElements int64, data any) *Pages {
	totalPage := totalElements / int64(pageSize)
	if totalElements%int64(pageSize) != 0 {
		totalPage++
	}
	return &Pages{
		PageNum:       pageNum,
		PageSize:      pageSize,
		TotalElements: totalElements,
		TotalPage:     int(totalPage),
		Content:       data,
	}
}
