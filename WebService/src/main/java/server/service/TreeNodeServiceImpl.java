package server.service;


import server.database.TreeNodeDAO;
import server.database.TreeNodeDTO;
import server.model.TreeNode;

import java.util.List;

public class TreeNodeServiceImpl implements TreeNodeService {
    private TreeNodeDAO dao;

    public TreeNodeServiceImpl(TreeNodeDAO dao){
        this.dao = dao;
    }

    @Override
    public void create(TreeNode treeNode) {
        dao.create(mapToDTO(treeNode));
    }

    @Override
    public List<String> getRoot() {
        return dao.getRoot();
    }

    @Override
    public List<String> getChild(TreeNode treeNode) {
        return dao.getChildren(mapToDTO(treeNode));
    }

    //Метод пока не используется,т.к в класса TreeNodeDAO методы возвращают String.Понадобится после того,как переделаю методы.

    private TreeNode mapToTreeNode(TreeNodeDTO dto){
       return new TreeNode(dto.getId(),dto.getParentId(),dto.getData());
    }

    private TreeNodeDTO mapToDTO(TreeNode treeNode){
        return  new TreeNodeDTO(treeNode.getId(),treeNode.getParentId(),treeNode.getData(),treeNode);
    }

}

