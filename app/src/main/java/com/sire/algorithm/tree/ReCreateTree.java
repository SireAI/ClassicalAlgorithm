package com.sire.algorithm.tree;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/08
 * Author:Sire
 * Description:5.输入某二叉树的前序遍历和中序遍历结果，请重建出该二叉树,假设输入的不含重复
 * 数字
 * ==================================================
 */
public class ReCreateTree implements IAlgorithm {
    @Override
    public void go() {
        TreeNode treeNode = recreateTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        System.out.println("===>"+treeNode);
    }

    /**
     * 在前序遍历中可以找到树的根节点，在中序遍历中可以找到左右子树，然后在递归处理左右子树
     * @param preOder
     * @param inOrder
     * @return
     */
    public TreeNode recreateTree(int[] preOder,int[] inOrder){
       if(preOder == null || inOrder == null || preOder.length == 0 || inOrder.length == 0){
           throw new RuntimeException("invalid input");
       }
      return recreate(preOder,0,preOder.length-1,inOrder,0,inOrder.length-1);
    }

    /**
     * 递归调用需要将数组的起止和终止索引传入进来
     * 同一个数组的递归需要不同的数组起终点
     *
     * @param preOder
     * @param preStart
     * @param preEnd
     * @param inOrder
     * @param inStart
     * @param inEnd
     */
    private TreeNode recreate(int[] preOder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        //不断递增的临界值
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }

        //获取树跟节点
        TreeNode rootNode = new TreeNode(preOder[preStart]);
        if(preStart == preEnd  || inStart == inEnd){
            return rootNode;
        }
        //获取左右子树索引
        int leftChildPreStart = preStart+1;
        int leftChildPreEnd = 0;
        int rightChildPreStart = 0;
        int rightChildPreEnd = preEnd;

        int leftChildInStart = inStart;
        int leftChildInEnd = 0;
        int rightChildInStart = 0;
        int rightChildInEnd = inEnd;

        for (int i = inStart; i <= inEnd; i++) {
          if(inOrder[i]==rootNode.key){
              //确定左右子树连接处的起终点
              leftChildPreEnd = preStart+i-inStart;
              rightChildPreStart = leftChildPreEnd+1;

              leftChildInEnd = i-1;
              rightChildInStart = i+1;
              break;
          }
        }
        //左右子树做同样的处理
        rootNode.left = recreate(preOder,leftChildPreStart,leftChildPreEnd,inOrder,leftChildInStart,leftChildInEnd);
        rootNode.right = recreate(preOder,rightChildPreStart,rightChildPreEnd,inOrder,rightChildInStart,rightChildInEnd);
        return rootNode;
    }
}
