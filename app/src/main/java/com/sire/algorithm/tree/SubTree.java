package com.sire.algorithm.tree;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/13
 * Author:Sire
 * Description:18.输入两颗二叉树，判断B是不是A的子结构
 * ==================================================
 */
public class SubTree implements IAlgorithm{
    @Override
    public void go() {

    }

    /**
     * 判断一个二叉树是否是另一个二叉树的子树，子树的节点值父树中是否都存在
     * 考察每个二叉树子结构，使用递归来简化问题
     * @param parent
     * @param child
     * @return
     */
    private boolean isSubTree(TreeNode parent,TreeNode child){
        if(child == null){
            //已经没有子节点
            return true;
        }else if(parent == null){
            //子节点存在，但是父节点到尽头
            return false;
        }

        if(parent.key == child.key){
            //当前节点相同比较左右子节点
            return isSubTree(parent.left,child.left) && isSubTree(parent.right,child.right);
        }else {
            return isSubTree(parent.left,child) || isSubTree(parent.right,child);
        }
    }
}
