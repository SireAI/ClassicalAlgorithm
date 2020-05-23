package com.sire.algorithm.sort;

public class Binary {
    public static void main(String[] args){
        int[] data = new int[]{3,4,5,1,2};
        final int i = find(data);
        System.out.println("====>"+i);
    }

    /**
     * 旋转数组问题
     * 二分查找
     * 划分条件：
     * m>h,右侧
     * m<h,左侧
     * @param data
     */
    private static int find(int[] data){
            int l = 0,h = data.length-1;
            while (l<h){
               int mid = l+(h-l)/2;
               if(data[mid]>data[h]){
                   l=mid+1;
               }else{
                   if(data[mid]<data[l]){
                       h=mid-1;
                   }else{
                       return data[l];
                   }
               }
            }
            return 0;
    }

    private static int fibonaqi(int total){
        int sum = 0;
        int first = 0;
        int second = 1;
        while (second<=total){
            sum = first+second;
            first = second;
            second = sum;
        }
        return sum;
    }

}
