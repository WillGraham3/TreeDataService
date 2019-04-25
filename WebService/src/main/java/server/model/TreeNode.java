package server.model;

import java.util.ArrayList;
import java.util.List;


public class TreeNode {
    private int id;
    private int parentId;
    private String data;
    private TreeNode parent = null;
    private List<TreeNode> children = new ArrayList<>();


    public TreeNode(String data) {
        this.data = data;
    }

    public TreeNode(int id,int parentId,String data){
        this.id = id;
        this.parentId = parentId;
        this.data = data;
    }
    public void addChild(TreeNode child) {
        child.setParent(this);
        child.parentId = child.getParent().getId();
        this.children.add(child);
    }
    public void addChild(String data) {
        TreeNode newChild = new TreeNode(data);
        newChild.setParent(this);
        newChild.parentId = newChild.getParent().getId();
        children.add(newChild);
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

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }



}
