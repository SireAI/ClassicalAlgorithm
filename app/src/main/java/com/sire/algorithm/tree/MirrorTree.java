package com.sire.algorithm.tree;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/13
 * Author:Sire
 * Description:输入一个二叉树，输出它的镜像
 * ==================================================
 */
public class MirrorTree implements IAlgorithm{
    @Override
    public void go() {

    }

    /**
     * 分治的思想，一个子结构作为考察对象
     * @param treeNode
     * @return
     */
    private TreeNode mirror(TreeNode treeNode){
        if(treeNode == null){
            return null;
        }
        TreeNode temp = treeNode.left;
        treeNode.left = mirror(treeNode.right);
        treeNode.right = mirror(temp);
        return treeNode;
    }
}
