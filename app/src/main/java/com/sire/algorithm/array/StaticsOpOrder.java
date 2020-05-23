package com.sire.algorithm.array;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/05
 * Author:Sire
 * Description:数组中两个数字，如果前面一个大于后面一个，则这两个数字
 * 组成一个逆序对，输入一个数组，求这个数组中逆序对的总数.例如
 * {7,5,6,4}  (7,6)  (7,5) (7,4) (6,4) (5,4)  总共五个
 * ==================================================
 */
public class StaticsOpOrder implements IAlgorithm {

    @Override
    public void go() {
        int[] statics = statics(new int[]{7,5,6,4}, 0, 3);
        for (int i = 0; i < statics.length; i++) {
            System.out.println(statics[i]+"===>"+sum);
        }

    }

    /**
     * 1.双层遍历，累计 时间效率O(N2)
     * 2.归并排序来进行计算
     *
     * @param array
     * @return
     */
    public int[] statics(int[] array, int low, int heigh) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("");
        }
        if (low < heigh) {
            int mid = low+(heigh-low)/2;
            statics(array,low,mid);
            statics(array,mid+1,heigh);
            merge1(array,low,mid,heigh);
        }
        return array;
    }
    int sum = 0;
    /**
     * 合并两个排序好的数组
     * @param array
     * @param low
     * @param mid
     * @param heigh
     */
    private void merge(int[] array, int low, int mid, int heigh) {
        int[] temp = new int[heigh - low + 1];
        int temIndex = 0;
        int startF = low;
        int startS = mid+1;

        while (startF<=mid && startS <= heigh){
            if(array[startF]<array[startS]){
                temp[temIndex++] = array[startF++];
            }else {
                //如果发生了交换则存在逆序对
                temp[temIndex++] = array[startS++];
                sum++;
            }
        }
        // 13569  4798
        sum+=(mid-startF)*(heigh-mid);
        while (startF<=mid){
            temp[temIndex++] = array[startF++];
        }
        while (startS<=heigh){
            temp[temIndex++] = array[startS++];
        }

        for (int i = 0; i < temp.length; i++) {
            array[low++]=temp[i];
        }
    }

    private void merge1(int[] array, int low, int mid, int heigh) {
        int[] temp = new int[heigh - low + 1];
        int temIndex = temp.length-1;
        int endF = mid;
        int endS = heigh;

        while (endF>=low && endS>=mid+1){
            if(array[endF]>array[endS]){
                //如果发生了交换则存在逆序对
                sum+=endS-mid;
                temp[temIndex--] = array[endF--];
            }else {
                temp[temIndex--] = array[endS--];
            }
        }
        // 13569  4798
        while (endF>=low){
            temp[temIndex--] = array[endF--];
        }
        while (endS>=mid+1){
            temp[temIndex--] = array[endS--];
        }

        for (int i = 0; i < temp.length; i++) {
            array[low++]=temp[i];
        }
    }
}
