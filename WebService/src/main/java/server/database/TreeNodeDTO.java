package server.database;

import server.model.TreeNode;

public class TreeNodeDTO {
    private int id;
    private int parentId;
    private String data;
    private TreeNode treeNode;

    public TreeNodeDTO(String data) {
        this.data = data;
    }

    public TreeNodeDTO(int id, int parentId, String data, TreeNode treeNode) {
        this.id = id;
        this.parentId = parentId;
        this.data = data;
        this.treeNode = treeNode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }

}
