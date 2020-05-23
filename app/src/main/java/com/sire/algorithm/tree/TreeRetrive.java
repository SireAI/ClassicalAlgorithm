package com.sire.algorithm.tree;

public class TreeRetrive {
   static class TreeNode{
        public TreeNode(int number) {
            this.number = number;
        }

        int number;
        TreeNode left;
        TreeNode right;
    }

    /**
     * 1.确定根节点左右子序列
     * 2.构建左右子序列
     * @param args
     */
    public static void main(String[] args){
        int[] preOrder = new int[]{1,2,4,7,3,5,6,8};
        int[] inOder = new int[]{4,7,2,1,5,3,8,6};
        final TreeNode constructor = constructor(preOrder, inOder);
        System.out.println("=====>"+constructor);
    }
    private static TreeNode constructor(int[] preOrder,int[] inOder){
        if(preOrder == null || inOder == null || preOrder.length != inOder.length || preOrder.length==0){
            throw new RuntimeException("无效输入");
        }
        int rootNumber = preOrder[0];
        TreeNode root = new TreeNode(rootNumber);
        final int length = inOder.length;
        if(length == 1){
            return root;
        }
        int i = 0;
        for (; i < inOder.length; i++) {
           if(rootNumber == inOder[i]){
               break;
           }
        }
        root.left = constructorCore(preOrder,1,i+1);
        root.right = constructorCore(preOrder,i+1,preOrder.length);
        return root;
    }

    private static TreeNode constructorCore(int[] preOrder, int start, int end) {
        if(start<end){
            final TreeNode treeNode = new TreeNode(preOrder[start++]);
            if(start<end){
                final int next = preOrder[start];
                if(next <treeNode.number){
                    treeNode.left = constructorCore(preOrder,start,end);
                }else {
                  treeNode.right = constructorCore(preOrder,start,end);
                }
            }
            return treeNode;
        }
        return null;
    }
}
