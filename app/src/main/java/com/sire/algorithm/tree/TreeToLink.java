package com.sire.algorithm.tree;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/06
 * Author:Sire
 * Description:
 * ==================================================
 */
public class TreeToLink implements IAlgorithm {
    @Override
    public void go() {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(14);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(8);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(12);
        TreeNode treeNode7 = new TreeNode(16);
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode convert = convert(treeNode1);
        while (convert.left!=null){
            convert = convert.left;
        }
        System.out.println("====>"+convert);
    }

    /**
     * 中序遍历，先处理左子树，在处理节点，在处理右子树
     * @param root
     * @return
     */
    public TreeNode convert(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left!=null){
            TreeNode left = convert(root.left);
            left.right = root;
            root.left = left;
        }
        if(root.right!=null){
            TreeNode right = convert(root.right);
            root.right = right;
            right.left = root;
        }
        return root;
    }
}
