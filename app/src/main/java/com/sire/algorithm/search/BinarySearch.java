package com.sire.algorithm.search;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/18
 * Author:Sire
 * Description:二分查找及其变体
 * ==================================================
 */
public class BinarySearch implements IAlgorithm {
    @Override
    public void go() {

    }

    /**
     * 普通二分查找，从有序数组中查找数值
     * @param array
     * @param value
     */
    public int  bsearchCommon(int[] array,int value){
        int low = 0;
        int heigh = array.length -1;
        while (low <= heigh){
            int mid = low + ((heigh-low)>>1);
            if(array[mid] > value){
                heigh = mid -1;
            }else if(array[mid] < value){
                low = mid +1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 变体二分查找，从有序数组中查找第一个等于给定数值的数
     * @param array
     * @param value
     */
    public int  fsearchCommon(int[] array,int value){
        int low = 0;
        int heigh = array.length -1;
        while (low <= heigh){
            int mid = low + ((heigh-low)>>1);
            if(array[mid] > value){
                heigh = mid -1;
            }else if(array[mid] < value){
                low = mid +1;
            }else {
                if(mid == 0 || array[mid-1] != value){
                    return mid;
                }else {
                    heigh = mid -1;
                }
            }
        }
        return -1;
    }

    /**
     * 变体二分查找，从有序数组中查找最后一个等于给定数值的数
     * @param array
     * @param value
     */
    public int  lsearchCommon(int[] array,int value){
        int low = 0;
        int heigh = array.length -1;
        while (low <= heigh){
            int mid = low + ((heigh-low)>>1);
            if(array[mid] > value){
                heigh = mid -1;
            }else if(array[mid] < value){
                low = mid +1;
            }else {
                if(mid == array.length -1 || array[mid+1] != value){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


    /**
     * 变体二分查找，从有序数组中查找第一个大于或等于给定数
     * @param array
     * @param value
     */
    public int  searchFloor(int[] array,int value){
        int low = 0;
        int heigh = array.length -1;
        while (low <= heigh){
            int mid = low + ((heigh-low)>>1);
            if(array[mid] >= value){
                if(mid == 0 || array[mid-1] < value){
                    return mid;
                }else {
                    heigh = mid -1;
                }
            }else {
                low = mid +1;
            }
        }
        return -1;
    }



    /**
     * 变体二分查找，从有序数组中查找最后一个小于等于给定值元素
     * 如，数组中存储了这样一组数据：3，5，6，8，9，10。最后一个小于等于 7 的元素就是 6
     * @param array
     * @param value
     */
    public int  searchCeiling(int[] array,int value){
        int low = 0;
        int heigh = array.length -1;
        while (low <= heigh){
            int mid = low + ((heigh-low)>>1);
            if(array[mid] > value){
                heigh = mid -1;
            }else{
                if(mid == array.length - 1 || array[mid+1]>value){
                    return mid;
                }else {
                    low = mid +1;
                }
            }
        }
        return -1;
    }
}
