package com.sire.algorithm.tree;

import com.sire.algorithm.IAlgorithm;

import java.util.Stack;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/06
 * Author:Sire
 * Description:50.给定一棵树和和两个节点，输出这两个节点的最低公共祖先
 * 分析：
 * 1.若树是一棵二叉搜索树，可以这样设计，从根节点开始遍历，判断当前节点若大于两个节点
 * 则公共祖先在左子树，否则在右子树，直到出现第一次当前节点的大小在两个节点之间
 * 2.若不是二叉搜索树，但是每个子节点有指向父节点的指针，则该问题可以转化为求两个链表
 * 的公共节点。
 * 3.普通二叉树，无父节点指针：仍让是将问题转化为链表求公共节点的问题，首先进行两次路劲搜索
 * 将路劲转化为链表，然后处理链表公共节点问题
 * ==================================================
 */
public class PublicTreeNode implements IAlgorithm {
    @Override
    public void go() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        treeNode2.left = treeNode4;
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(6);
        treeNode4.left = treeNode6;
        TreeNode treeNode7 = new TreeNode(7);
        treeNode5.right = treeNode7;
        TreeNode publicNode = findPublicNode(treeNode1, treeNode6, treeNode7);
        System.out.println("======>" + publicNode.key);
    }

    /**
     * @param root
     */
    public TreeNode findPublicNode(TreeNode root, TreeNode node1, TreeNode node2) {
        Stack<TreeNode> first = new Stack<>();
        Stack<TreeNode> second = new Stack<>();
        findPath(first, root, node1);
        findPath(second, root, node2);
        if (first.size() > second.size()) {
            int k = first.size() - second.size();
            while (k > 0) {
                k--;
                first.pop();
            }
        } else {
            int k = second.size() - first.size();
            while (k > 0) {
                k--;
                second.pop();
            }
        }
        while (first.peek().key != second.peek().key) {
            first.pop();
            second.pop();
        }

        return first.peek();
    }

    private boolean findPath(Stack<TreeNode> path, TreeNode root, TreeNode node1) {
        path.push(root);
        if (root.key == node1.key) {
            return true;
        }
        if (root.left != null) {
            boolean re = findPath(path, root.left, node1);
            if (re) {
                return true;
            }
        }
        if (root.right != null) {
            boolean re = findPath(path, root.right, node1);
            if (re) {
                return true;
            }
        }
        path.pop();
        return false;
    }


}
