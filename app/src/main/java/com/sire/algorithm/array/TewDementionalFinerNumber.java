package com.sire.algorithm.array;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/06
 * Author:Sire
 * Description:3.在一个二维数组中，每一行从左到右顺序递增，每一列
 * 从上到下递增，完成这样一个函数，输入这样一个二维数组和一个整数
 * 判断是否含有这个整数
 * ==================================================
 */
public class TewDementionalFinerNumber implements IAlgorithm {
    @Override
    public void go() {
        int[][] array = new int[][]{new int[]{1,2,4,6},new int[]{2,4,7,8},new int[]{8,9,10,11},new int[]{9,12,13,15}};
        boolean number = findNumber(array, 10);
       System.out.println("====>"+number);
    }

    /**
     * 选取右上角的数字，如果该数字等于要查找的数字则结束
     * 若要查找的数字小于右上角数字则去掉列，若大于右上角数字则去掉行
     * @param array
     * @param number
     * @return
     */
    private boolean findNumber(int[][] array,int number){
        //确定两个索引
        int right = array.length-1;
        int top = 0;
        //确定索引的终止条件
        while (right>=0 && top<=array[0].length-1){
            int rtNumber = array[right][top];
            if(rtNumber<number){
                top++;
            }else if(rtNumber > number){
                right--;
            }else {
                return true;
            }
        }
        return false;
    }
}
