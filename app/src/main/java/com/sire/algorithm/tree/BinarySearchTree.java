package com.sire.algorithm.tree;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/05/03
 * Author:Sire
 * Description:
 * ==================================================
 */
public class BinarySearchTree implements IAlgorithm {
    @Override
    public void go() {

    }

    /**
     * 二叉查找树搜索
     * 左子树小于节点，节点小于右子树
     *
     * @param tree
     * @param number
     * @return
     */
    public TreeNode binarySearch(TreeNode tree, int number) {
        if (tree == null) {
            return null;
        }
        TreeNode p = tree;
        while (p != null) {
            if (p.key > number) {
                p = p.left;
            } else if (p.key < number) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }


    /**
     * 二叉树插入算法
     * 最终插入的地方是叶子节点
     * 与节点比较，大于则看右子节点存在，不存在则将值直接放在右子节点位置，否则递归比较，左子节点亦一样
     *
     * @param tree
     * @param number
     */
    public void insert(TreeNode tree, int number) {
        if (tree == null) {
            return;
        }
        TreeNode p = tree;
        while (p != null) {
            if (p.key < number) {
                if (p.right != null) {
                    p = p.right;
                } else {
                    p.right = new TreeNode(number);
                }
            } else {
                if (p.left != null) {
                    p = p.left;
                } else {
                    p.left = new TreeNode(number);
                }
            }
        }
    }

    /**
     * 1.查找这个节点
     * 2.删除这个节节点
     * 3.补充这个位置的节点
     * a.如果删除的这个节点没有其他节点，则直接删除即可
     * b.如果删除的这个节点有一个节点，则将这个节点挂上即可
     * c.如果删除的这个节点有两个节点，则在其右子树中寻找最小子节点
     * ps:为什么不能再左子节点中查找，因为左子节点可能有左右子节点
     *
     * @param tree
     * @param number
     */
    public void delete(TreeNode tree, int number) {
        if (tree == null) {
            return;
        }
        TreeNode p = tree;
        TreeNode parent = null;
        while (p != null) {
            if (number < p.key) {
                parent = p;
                p = p.left;
            } else if (number > p.key) {
                parent = p;
                p = p.right;
            } else {
                //find  number and delete
                //没有子节点
                if (p.left == null && p.right == null) {
                    if(parent.left == p){
                        parent.left = null;
                    }else {
                        parent.right = null;
                    }
                    return;
                }
                //有左子节点或者右子节点
                if(p.left == null && p.right != null){
                    if(parent.left == p){
                        parent.left = p.right;
                    }else {
                        parent.right = p.right;
                    }
                    return;
                }
                if(p.left != null && p.right == null){
                    if(parent.left == p){
                        parent.left = p.left;
                    }else {
                        parent.right = p.left;
                    }
                    return;
                }
                //有两个子节点
                if (p.left != null && p.right != null) {
                    TreeNode deleteNode = p;
                    TreeNode pp = p;
                    p = p.right;
                    //右子树中找到最小子树
                    while (p.left!=null){
                        pp = p;
                        p = p.left;
                    }
                    //替换节点
//                    if(parent.left == deleteNode){
//                        parent.left = p;
//                    }else {
//                        parent.right = p;
//                    }
//                    pp.left = p.right;
//                    p.right = deleteNode.right;
//                    p.left = deleteNode.left;
                    deleteNode.key = p.key;
                    pp.left = p.right;
                }
            }
        }
    }
}
