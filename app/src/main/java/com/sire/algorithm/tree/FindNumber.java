package com.sire.algorithm.tree;

import com.sire.algorithm.IAlgorithm;

import java.util.Stack;


/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/06
 * Author:Sire
 * Description:路径等于某个数
 * ==================================================
 */
public class FindNumber implements IAlgorithm {
    @Override
    public void go() {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(12);
        treeNode1.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(5);
        treeNode1.left = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.left = treeNode4;
        TreeNode treeNode5 = new TreeNode(7);
        treeNode3.right = treeNode5;
        findN(treeNode1,22);

    }

    /**
     * 前序遍历
     * 当遍历到叶子节点的时候检测路劲值，若相等则打印
     * @param root
     */
    public void findNumberInTree(TreeNode root,int number){
        Stack<TreeNode> nodes = new Stack<>();
        Stack<TreeNode> path = new Stack<>();

        TreeNode p = root;
        while (p!=null || !nodes.isEmpty()){
            while (p!=null){
                path.push(p);
                if(p.right!=null){
                    nodes.push(p.right);
                }
                p = p.left;
            }
            checkPath(path,number);
            if(!nodes.isEmpty()){
                p = nodes.pop();
                path.pop();
            }
        }
    }

    private void checkPath(Stack<TreeNode> path, int number) {
        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum+=path.get(i).key;
        }
        if(sum == number){
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i).key+",");
            }
            System.out.println("");
        }
    }
    int sum = 0;
    /**
     * 递归式遍历
     *
     * 凡是路径问题都用栈递归遍历
     * @param node
     * @param number
     */
    public void findN(TreeNode node,int number){
        if(node == null){
            return;
        }
        Stack<Integer> integers = new Stack<>();
        find(integers,node,number);
    }

    private void find(Stack<Integer> integers, TreeNode node, int number) {
        integers.push(node.key);
        sum+=node.key;
        if(node.left == null && node.right == null && sum == number){
            for (int i = 0; i < integers.size(); i++) {
                System.out.print(integers.get(i)+",");
            }
        }
        if(node.left!=null){
            find(integers,node.left,number);
        }
        if(node.right!=null){
            find(integers,node.right,number);
        }
        sum-=node.key;
        integers.pop();
    }

}
