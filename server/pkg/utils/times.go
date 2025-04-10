package utils

import (
	"fmt"
	"strings"
	"time"
)

type LocalTime time.Time

func (lt *LocalTime) UnmarshalJSON(data []byte) error {
	str := string(data)
	if str == "null" {
		return nil
	}
	timeStr := strings.Trim(str, "\"")
	t1, err := time.Parse("2006-01-02 15:04:05", timeStr)
	*lt = LocalTime(t1)
	return err
}

func (lt LocalTime) MarshalJSON() ([]byte, error) {
	formatted := fmt.Sprintf("\"%s\"", time.Time(lt).Format("2006-01-02 15:04:05"))
	return []byte(formatted), nil
}
