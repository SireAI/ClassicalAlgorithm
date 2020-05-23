package com.sire.algorithm.sort;

import java.util.TreeSet;

public class FindK {
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        int[] data = new int[]{1,2,3,2,6,2,5,2,2};
        final int mostNumber = findMostNumberB(data);
        System.out.println("====>"+mostNumber);
    }

    /**
     * 发现数组中超过一半的大多数元素
     * 1.快速排序中partion函数，从数组中任意选择一个数，将不大于这个数的其他元素放在左边，将不小于这个数的其他元素放在右边，返回
     * 被选中的数的位置。
     * 2.如果这个选中数的位置恰好是中间，那么这个中间数必然大多数元素，若在n/2的右边，则在左半边数组中继续查找，否则在右半边继续查找
     * @return
     */
    private static int findMostNumber(int[] data){
        if(checkInvalid(data)){
            throw new RuntimeException("invalid input");
        }
        int mid  = data.length/2;
        int start  = 0;
        int end = data.length-1;
        int index  = partion(data,start,end);
        while (index!=mid){
            if(index>mid){
                end = index-1;
            }else {
                start = index+1;
            }
            index = partion(data,start,end);
        }
        if(checkMoreThanHalf(data,data[index])){
            throw new RuntimeException("not half enough");
        }
        return data[index];
    }

    /**
     * 总元素个数的角度去思考
     * 重复元素的个数大于其他元素个数的总和
     *
     * @param data
     * @return
     */
    private static int findMostNumberB(int[] data){
        if(data == null || data.length == 0){
            throw new RuntimeException("invalid input");
        }
        int time = 0;
        int target = data[0];
        for (int i = 0; i < data.length; i++) {
            if(target == data[i]){
                time++;
            }else {
                time--;
                if(time == 0){
                    target = data[i];
                    time++;
                }
            }
        }
        return target;
    }


        /**
         * 发现第K小元素
         * @param data
         * @param k
         * @return
         */
    private static int findTheKOrder(int[] data,int k){
        if(checkInvalid(data)){
            throw new RuntimeException("invalid input");
        }
        k--;
        int start  = 0;
        int end = data.length-1;
        int index  = partion(data,start,end);
        while (index != k){
            if(index>k){
                end = index-1;
            }else {
                start= index+1;
            }
            index  = partion(data,start,end);
        }
        return data[index];
    }

    /**
     * 函数一次的执行并不能确定所有的顺序，但是可以确定划分数在排序后的数组中的位置，或者是说排序
     * @param data
     * @param start
     * @param end
     * @return
     */
    private static int partion(int[] data, int start, int end) {
        int pivot = data[start];
        while (start<end){
            while (start<end && data[end]>=pivot){
                end--;
            }
            data[start] = data[end];
            while (start<end && data[start]<=pivot){
                start++;
            }
            data[end] = data[start];
        }
        data[start] = pivot;
        return start;
    }

    private static boolean checkInvalid(int[] data) {
        return data==null || data.length <= 0;
    }


    private static boolean checkMoreThanHalf(int[] data,int number) {
        int time = 0;
        for (int i = 0; i < data.length; i++) {
            if(data[i] == number){
                time++;
            }
        }
        return time>=data.length/2;
    }
}
