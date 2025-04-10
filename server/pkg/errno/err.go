package errno

type Error struct {
	Code    int    `json:"code"`
	Message string `json:"message"`
}

var (
	OK          = NewError(10200, "OK")
	BadRequest  = NewError(10400, "参数错误")
	UnAuth      = NewError(10401, "未登录")
	Forbidden   = NewError(10403, "权限不足")
	NotFound    = NewError(10404, "请求资源不存在")
	ServerError = NewError(10505, "服务执行出错")
	AuthExpired = NewError(10401, "登录过期，请重新登录")

	BusinessError = NewError(20500, "业务执行出错") // 业务异常

	IllegalParamError = NewError(20400, "请求参数错误")
	SaveFailedError   = NewError(20401, "新增失败")
	RemoveFailedError = NewError(20402, "删除失败")
	UpdateFailedError = NewError(20403, "修改失败")
	QueryFailedError  = NewError(20404, "查询失败")
)

func NewError(code int, msg string) *Error {
	return &Error{
		Code:    code,
		Message: msg,
	}
}

func (err Error) WithMessage(msg string) Error {
	return Error{
		Code:    err.Code,
		Message: msg,
	}
}

func (err Error) Error() string {
	return err.Message
}
