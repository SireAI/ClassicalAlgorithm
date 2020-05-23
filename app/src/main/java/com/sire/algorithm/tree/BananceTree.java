package com.sire.algorithm.tree;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/01
 * Author:Sire
 * Description:输入一个二叉树，判断是不是平衡二叉树。一颗二叉树任意节点的左右子树
 * 的深度相差不超过1，那么他是一颗平衡二叉树。
 * ==================================================
 */
public class BananceTree implements IAlgorithm {

    @Override
    public void go() {

    }

    /**
     * 每个子树都是平衡二叉树，总体才是平衡二叉树
     * 一个节点时平衡二叉树
     * 左子树和右子树的深度小于或等于1
     * @param root
     * @return
     */
    public boolean bananceTree(TreeNode root){
        if(root == null){
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        if(Math.abs(left-right)<=1){
            return true;
        }
        return bananceTree(root.left) &&bananceTree(root.right);
    }
    public int treeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(treeDepth(root.left),treeDepth(root.left))+1;
    }
}
