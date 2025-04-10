package dbhelper

type TreeNode struct {
	Id       uint64
	ParentId uint64
	Children []*TreeNode
}

func ListToTree(list []*TreeNode) []*TreeNode {
	var tree []*TreeNode
	treeMap := make(map[uint64]*TreeNode)
	for _, e := range list {
		if e.ParentId == 0 {
			tree = append(tree, e)
		} else {
			treeMap[e.ParentId].Children = append(treeMap[e.ParentId].Children, e)
		}
		treeMap[e.Id] = e
	}
	return tree
}
