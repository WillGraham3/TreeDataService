package server.service;

import java.util.List;
import server.model.TreeNode;

public interface TreeNodeService {
    void create(TreeNode treeNode);
    List<String> getRoot();
    List<String> getChild(TreeNode treeNode);
}
