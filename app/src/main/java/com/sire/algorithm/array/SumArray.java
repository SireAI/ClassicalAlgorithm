package com.sire.algorithm.array;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/01
 * Author:Sire
 * Description:输入一个递增排序数组和一个S，在数组中查找两个数，使得他们的和刚好是S
 * 如果有多对，则任意输出一对即可
 * ==================================================
 */
public class SumArray implements IAlgorithm {
    @Override
    public void go() {
        int[] sum = findSum1(new int[]{1, 3, 5, 6, 7, 9, 10}, 12);
        System.out.println("====>"+sum[0]+":"+sum[1]);
    }

    /**
     * 二分法查找一个数
     * 二分法查找两个数据
     * 1 3 5 6 8 9 10
     *
     *
     * 这两个数分别在两个数组里
     * @param array
     * @param sum
     * @return
     */
    public int[] findSum(int[] array,int sum){
        int[] data = new int[2];
        for (int i = 0; i < array.length; i++) {
            int half = sum - array[i];
            if(half < array[i]){
                break;
            }
            int low = i+1;
            int heigh = array.length-1;
            while (low<heigh){
                int mid = low+(heigh - low)/2;
                if(half < array[mid]){
                    heigh  = mid -1;
                }else if(half > array[mid]){
                    low = mid+1;
                }else {
                    data[0] = array[i];
                    data[1] = half;
                    return data;
                }
            }
        }
        return data;
    }

    /**
     * 排序数组，一种较大的可能是，从较大的一端去一个大数
     * 从较小的一端取一个较小的数据，二者尝试相加
     * 双指针遍历查找
     * @param array
     * @param sum
     * @return
     */
    public int[] findSum1(int[] array,int sum){
        int[] data = new int[2];

        int low = 0;
        int heigh = array.length - 1;

        while (low<heigh){
            int result = array[low] + array[heigh];
            if(result > sum){
                heigh--;
            }else if(result < sum){
                low++;
            }else {
                data[0] = array[low];
                data[1] = array[heigh];
                break;
            }
        }

        return data;
    }
}
