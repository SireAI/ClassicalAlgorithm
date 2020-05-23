package com.sire.algorithm.array;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/09
 * Author:Sire
 * Description:输入一个递增数组的旋转数组，输出该数组的最小值
 * 例如{1,2,3,4,5}的旋转数组{3,4,5,1,2}
 * ==================================================
 */
public class RotateArray implements IAlgorithm {
    @Override
    public void go() {
        int minInRotateArray = findMinInRotateArray(new int[]{3, 4, 5,6, 1, 2});
        System.out.println("=====>"+minInRotateArray);
    }

    /**
     * 部分有序的二分法，时间复杂度log2n
     * 如果是一个递增数组，找到最小值很容易，第一个元素就是
     * 旋转数组可以看做是两个有序数组放在一个数组里，部分有序
     * 旋转数组的特点：
     * 较小数组的任意元素比两端的元素都小
     * 较大数组的任意元素比两端元素都打
     * 根据这个特点可取划分区间
     * 最小元素的特点是比左边的相邻元素大
     * 使用二分法
     * @param array
     * @return
     */
    public int findMinInRotateArray(int[] array){
        if(array == null || array.length == 0){
            throw new RuntimeException("invalid input");
        }
      int low = 0;
      int high = array.length - 1;
      int start = array[low];
      while (low<high){
          int mid = low+(high-low)/2;
          //正确的元素，比相邻左边元素小
          if(array[mid]<=array[mid-1]){
              return array[mid];
          }else {
              //缩小区域
              if(array[mid]>start){
                  low  = mid+1;
              }else {
                  high=mid-1;
              }
          }
      }
      return -1;
    }
}
