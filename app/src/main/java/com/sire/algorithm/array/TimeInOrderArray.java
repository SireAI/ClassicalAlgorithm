package com.sire.algorithm.array;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/01
 * Author:Sire
 * Description:{1,2,3,3,3,3,4,5} 排序数组中数字出现的次数
 * ==================================================
 */
public class TimeInOrderArray implements IAlgorithm {
    @Override
    public void go() {
        int i = searchTimes(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 4);
        System.out.println("========>"+i);
    }

    /**
     * 1.直接遍历，搜索到该数字后开始比较计数
     * 2.二分法先找到这个数字，向前向后搜索
     * 3.二分法查找第一个与最后一个数字，第一个的判断看前面，最后一个数字看后面
     * @param array
     * @param number
     * @return
     */
    public int searchTimes(int[] array,int number){
        int low = 0;
        int heigh = array.length-1;
        while (low<heigh){
            int mid = low+(heigh-low)/2;
            if(array[mid] > number){
                heigh = mid -1;
            }else if(array[mid] < number){
                low = mid+1;
            }else {
                //查找到后前后线性搜索
                int left =  mid;
                int right =  mid;
                while (array[left] == number){
                    left--;
                }
                left++;
                while (array[right] == number){
                    right++;
                }
                right--;
                //第一个索引与最后一个索引，若相等，则只有一个；若不相等end - start +1
                return right-left+1;
            }
        }
        return 0;
    }
}
