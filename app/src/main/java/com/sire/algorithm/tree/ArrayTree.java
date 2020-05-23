package com.sire.algorithm.tree;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/03/31
 * Author:Sire
 * Description:输入一个整数数组，判断该数组是不是某二叉搜索树的后续遍历结果
 * 如果是则返回true，否则返回false.假设输入的数组的任意两个数字都不相同
 * 特点：根据数组自身的性质
 * ==================================================
 */
public class ArrayTree implements IAlgorithm {

    @Override
    public void go() {
        boolean tree = isTree(new int[]{5, 7, 6, 9, 11, 10, 8}, 0, 6);
        System.out.println("====>"+tree);
    }
    public boolean isTree(int[] array,int start ,int end){
        if(array == null || start > end){
            throw new RuntimeException("invalid input");
        }
        //最后一个是根节点
        int root = array[end];
        //左子树都比根小,搜索左子树区域 5, 7, 6
        int i = start;
        for (;i<=end;i++){
            if(root < array[i]){
                break;
            }
        }
        //子树区域
        boolean left = true;
        //=是前后相邻的情况，去掉
        if(start < i-1){
             left = isTree(array,start,i-1);
        }

        //右子树都比根大,若小则表示无效
        int j = i;
        for (; j <= end; j++) {
            if(root > array[j]){
                return false;
            }
        }
        boolean right = true;
        if(j<end){
             right = isTree(array,i,end);

        }

        return left && right;
    }

}
