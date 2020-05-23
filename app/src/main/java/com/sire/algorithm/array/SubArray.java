package com.sire.algorithm.array;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/01
 * Author:Sire
 * Description:31 输入一个整型数组，数组里有正数也有负数，数组中一个或者连续的多个整数
 * 组成一个子数组，求所有子数组中和的最大值，例如1，-2，3，10，-4，7，2，-5，最大和子数组为3，10，-4
 * 7，2，因此该数组的和为18
 * ==================================================
 */
public class SubArray implements IAlgorithm {
    @Override
    public void go() {
        int i = bigSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println("====>"+i);
    }

    public int bigSubArray(int[] array){
        //从0位置搜索，求和，负数舍弃，起始和终止索引决定了
        //从0开始统计，每遇到负数就比较保存一次，因为负数会使总数减小
        //逐一比较
        if(array == null || array.length == 0){
            throw new RuntimeException("invalid input");
        }
        int temp = array[0];
        int sum = array[0];
        for (int i = 0; i < array.length; i++) {
            if(temp<0){
                temp = array[i];
            }else {
                temp+=array[i];
            }
            //比较每次求职
            if(sum<temp){
                sum = temp;
            }
        }
        return sum;
    }
}
