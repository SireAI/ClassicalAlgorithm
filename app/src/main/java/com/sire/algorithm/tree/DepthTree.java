package com.sire.algorithm.tree;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/01
 * Author:Sire
 * Description:输出一棵树的深度，从根到叶子节点形成一条路径，最长路径为深度
 * ==================================================
 */
public class DepthTree implements IAlgorithm {
    @Override
    public void go() {

    }

    /**
     * 前序遍历 根 左  右边 ，路径需要累加
     *
     * 分治思想：
     * 一个节点，深度为1
     * 根节点和左右子节点
     * 等于左右树中较大路径加1
     * @param root
     * @return
     */
    public int treeDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(treeDepth(root.left),treeDepth(root.left))+1;
    }
}
