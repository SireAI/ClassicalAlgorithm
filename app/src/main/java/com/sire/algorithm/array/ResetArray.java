package com.sire.algorithm.array;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/12
 * Author:Sire
 * Description:14.输入一个数组，实现一个函数使得数组中所有的奇数
 * 位于前半部分，偶数位于后半部分
 * ==================================================
 */
public class ResetArray implements IAlgorithm {

    @Override
    public void go() {
        resetArray(new int[]{2, 1, 4, 6, 7, 9, 7, 3,});
    }

    /**
     * 数组划分算法
     * 使用双指针从头部和尾部遍历，类似pation函数的划分思想
     *
     * @param array
     */
    private void resetArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("invalid input");
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            //查找不满足条件索引
            while (low < high && (array[low] & 1) == 1) {
                low++;
            }
            //查找不满足条件索引
            while (low < high && (array[high] & 1) == 0) {
                high--;
            }
            //交换
            if (low < high) {
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
