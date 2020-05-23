package com.sire.algorithm.tree;

import com.sire.algorithm.IAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PerFormTree implements IAlgorithm {


    @Override
    public void go() {

    }

    /**
     * 前序遍历  ：根，左子树，右子树
     * 深度遍历，使用栈来存储待展开遍历的元素
     * 1.从节点向最左边遍历，并存储右节点
     * 2.提供最右边的节点重复
     *
     * @param root
     */
    private static void preOrder(TreeNode root) {
        final Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode p = root;
        while (p != null || !treeNodes.isEmpty()) {
            while (p != null) {
                //遍历
                System.out.println(p);
                p = p.left;
                //存储
                if (p.right != null) {
                    treeNodes.push(p.right);
                }
            }
            if (!treeNodes.isEmpty()) {
                p = treeNodes.pop();
            }
        }
    }
    private static void preOrder1(TreeNode root) {
        final Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {

            TreeNode node = treeNodes.pop();
            System.out.println(node);
            if(node.right!=null){
                treeNodes.push(node.right);
            }
            if(node.left!=null){
                treeNodes.push(node.left);
            }
        }
    }


    /**
     * 中序遍历：左 根  右
     * 使用栈来存储待展开节点
     * 1.从根节点沿着最左边方向一直存储
     * 2.从最底部开始遍历，并存储右节点
     * 3.重复1
     *
     * @param root
     */
    private static void inOrder(TreeNode root) {
        final Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode p = root;
        while (p != null || !treeNodes.isEmpty()) {
            //存储
            while (p != null) {
                treeNodes.push(p);
                p = p.left;
            }
            //遍历
            if (!treeNodes.isEmpty()) {
                final TreeNode pop = treeNodes.pop();
                System.out.println(pop);
                p = pop.right;
            }
        }
    }


    /**
     * 后序遍历:左子树，右子树，根节点
     *
     * @param root
     */
    private static void postOrder(TreeNode root) {
        final Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode p = root;
        while (p!=null || !treeNodes.isEmpty()){
            //左侧线性化存储
            while (p!=null){
                treeNodes.push(p);
                if(p.right!=null){
                    treeNodes.push(p.right);
                }
                if(p.left!=null){
                    treeNodes.push(p.left);
                    p = p.left;
                }else {
                    p = treeNodes.peek();
                }
            }
            //遍历
            if (!treeNodes.isEmpty()){
                final TreeNode pop = treeNodes.pop();
                System.out.println(pop.number);
            }
        }
    }

    /**
     *广度优先遍历：按照层级进行遍历
     * @param root
     */
    private static void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            final TreeNode poll = queue.poll();
            System.out.println(poll);
            if(poll.left!=null){
                queue.offer(poll.left);
            }
            if(poll.right!=null){
                queue.offer(poll.right);
            }
        }
    }


    static class TreeNode {
        int number;
        TreeNode left;
        TreeNode right;

        public TreeNode(int number) {
            this.number = number;
        }
    }

    /**
     * 深度优先遍历
     * @param treeNode
     */
    public void dfsWithStack(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            //调换顺序实现前中后遍历
            process(node);

            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }

        }
    }

    private void process(TreeNode node) {
        System.out.println(node.number);
    }
}
