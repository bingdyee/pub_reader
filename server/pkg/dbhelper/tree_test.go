package dbhelper

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestListToTree(t *testing.T) {
	tree := ListToTree([]*TreeNode{
		{Id: 1, ParentId: 0},
		{Id: 2, ParentId: 1},
		{Id: 3, ParentId: 1},
		{Id: 4, ParentId: 2},
		{Id: 5, ParentId: 3},
		{Id: 6, ParentId: 0},
		{Id: 7, ParentId: 6},
		{Id: 8, ParentId: 7},
	})
	assert.Len(t, tree, 2)
}
