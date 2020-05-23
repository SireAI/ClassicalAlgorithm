package com.sire.algorithm.array;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/13
 * Author:Sire
 * Description:20.输入一个二维矩阵，从外向内顺时针打印指针
 * ==================================================
 */
public class PrintArray implements IAlgorithm{
    @Override
    public void go() {
        int[][] array = new int[][]{new int[]{1,12,11,10},new int[]{2,13,16,9},new int[]{3,14,15,8},new int[]{4,5,6,7}};
        printArray(array,0);
    }

    /**
     * 步骤
     * 打印左边
     * 打印上边
     * 打印右边
     * 打印下边
     * 一圈完毕后进入下一圈
     * 以坐标系的坐标输入，然后数组遍历时进行左边转换
     * 分解子问题：
     * 1.每条边的数组
     * 2.每条数组的起终点
     * @param array 矩阵
     * @param level 圈层
     */
    private void printArray(int[][] array,int level){
        //圈层的两倍大于总长度表示数据已经遍历完毕
        if(level*2 >= array.length){
            return;
        }

        //上边数组，跨数组遍历
        for (int i = level; i <= array.length-level-1; i++) {
            System.out.println(array[i][level]);
        }
        //右边数组，顺序遍历start = 2 , end = 2
        for (int i = level+1; i <= array[array.length-level-1].length- 1 - level; i++) {
            System.out.println(array[array.length-level-1][i]);
        }
        //下边数组，跨数组遍历
        for (int i = array.length-1-(level+1); i >=level; i--) {
            System.out.println(array[i][array.length-level-1]);
        }
        //左边数组，倒叙遍历
        for (int i = array[level].length-1-(level+1); i >=level+1; i--) {
            System.out.println(array[level][i]);
        }
        printArray(array,++level);
    }
}
