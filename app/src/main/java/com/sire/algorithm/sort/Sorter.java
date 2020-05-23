package com.sire.algorithm.sort;
/**
 * ==================================================
 * All Right Reserved
 * Date:2020-04-18
 * Author:sire
 * Description:排序的稳定性：数值相等的两个元素在排序前后相对顺序保持不变称为稳定，反之不稳定
 * 排序稳定可用用于数据序列的多维度排序
 * ==================================================
 */
public class Sorter {
    public static void main(String[] args){
        int[] data = new int[]{4,3,6,8,1,7,3,5,3};
        data = mergeSort(data,0,data.length-1);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    /**
     * 插入类排序的基本思想：将集合中的数据分为两部分，已经排序部分和未排序部分
     * 通过逐个访问未排序部元素，将其放到已排序部分序列的合适位置
     */

    /**
     * 直接插入排序：从第二个元素起与已经排序的的集合中的元素向前比较，不满足条件的元素后移.时间复杂度O(N^2)
     * 步骤：
     * 1.正向遍历访问
     * 2.比较相邻的元素大小，若发现较小，则进入反向遍历;
     * 3.反向遍历中，较小就易位，直到遇到更小的，结束。
     * @param data
     * @return
     */
    private static int[] directInsertSort(int[] data){
        final int length = data.length;
        for (int i = 1; i < length; i++) {
            if(data[i]<data[i-1]){
                int j = i;
                do {
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                    j--;
                }while (j>0 && data[j]<data[j-1]);
            }
        }
        return data;
    }

    /**
     *折半插入排序：直接插入排序在寻找插入位置到了时候采用的是反向遍历逐个比较的方式，可以使用二分查找插入位置来优化时间,复杂度O(N^2)
     * 步骤：
     * 1.正向遍历访问
     * 2.比较相邻的元素大小，若发现较小的元素，则使用二分查找在有序序列中找出其插入的位置
     * 3.移动较大序列部分的位置
     * @param data
     * @return
     */
    private static int[] binaryInsertSort(int[] data){
        int length = data.length;
        for (int i = 1; i < length; i++) {
            int current = data[i];
            if(current<data[i-1]){
                int start = 0 ;
                int end = i-1;
                while (start<=end){
                    int mid = start+(end-start)/2;
                    int midData= data[mid];
                    if(current>midData){
                        start = mid+1;
                    }else if(current<midData){
                        end = mid-1;
                    }else {
                        end = mid;
                        break;
                    }
                }
                end++;
                for (int j = i; j-1>=end; j--) {
                    data[j] = data[j-1];
                }
                data[end] = current;
            }
        }
        return data;
    }
     //****************************************************

    /**
     * 交换类排序主要是通过元素两两比较，相逆则易位
     */

    /**
     * 冒泡排序：每趟易位将当前存量中的最大元素送到右侧
     * 1.遍历元素,相邻元素进行进行比较，相逆则易位
     * 2.比较n-1次，每次都会将一个较大的元素移到右侧
     * @param data
     * @return
     */
    private static int[] bubbleSort(int[] data){
        int length = data.length;
        for (int j = 0; j <data.length-1 ; j++) {
            for (int i = 0; i < length-1-j; i++) {
                if(data[i]>data[i+1]){
                    int temp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = temp;
                }
            }
        }
        return data;
    }

    /**
     * 快速排序：确定一个序列中的中间值X，使得X左边的序列都不大于X，X右边的序列都不小于X，然后对左右子序列递归做同样的处理
     * 当全部完成后，整个排序完成。体现了分治的思想，将大的问题划分成模式一样的子问题，然后分别求解子问题，在将结果组合
     * 时间复杂度o(n*logn)，非稳定排序
     *步骤：
     * 1.取中间值算法：
     *     a.任意确定序列中的一个元素为中间值，理论上这个值使得两边的序列越均衡越好
     *     b.比较与易位，原则是让大于X的元素往高处走，小于X的值往地处走
     *     c.当高低指正指向同一个位置时，结束。
     * 2.输出的数组即为结果
     * @param data
     * @return
     */
    private static int[] quickSort(int[] data,int low,int high){
       if(low<high){
           int mid = partion(data,low,high);
           quickSort(data,low,mid-1);
           quickSort(data,mid+1,high);
       }
        return data;
    }

    /**
     * 调整数组，是的数组以X值分为两部分，大于X值往右边放，小于X往左边放，重复第一个复制的元素
     * 这个重复的元素将在最后被X值代替
     * @param data
     * @return
     */
    private static int partion(int[] data,int low,int high){
        int pivot = data[low];
        while (low<high){
            while (low<high && data[high]>=pivot){
                high--;
            }
            data[low] = data[high];
            while (low<high && data[low]<=pivot){
                low++;
            }
            data[high] = data[low];
        }
        data[low] = pivot;
        return low;
    }
    //**************************************************************

    /**
     * 选择类排序的基本思想是每趟从存量的元素中选择最小的元素放在合适的位置
     *
     */

    /**
     * 每趟从存量序列中选取最小值放在有序数列的尾部
     * @param data
     * @return
     */
    private static int[] selectSort(int[] data){
        int length = data.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if(data[i]>data[j]){
                    int temp = data[i];
                    data[i]=data[j];
                    data[j] = temp;
                }
            }
        }
        return data;
    }


    /**
     * 归并排序：归并排序的思想与快速排序有些类似，都是使用了分支的思想，唯一的不一样的
     * 稳定排序
     * @param data
     * @param low
     * @param high
     * @return
     */
    private static int[] mergeSort(int[] data,int low,int high){
        if(low<high){
            int mid = low+(high-low)/2;
            mergeSort(data,low,mid);
            mergeSort(data,mid+1,high);
            merge(data,low,mid,high);
        }
        return data;
    }

    private static void merge(int[] data, int low, int mid, int high) {
        int[] copy = new int[high-low+1];
        int startF = low;
        int startS = mid+1;
        int s = 0;
        while (startF<=mid && startS<=high){
            if(data[startF] < data[startS]){
                copy[s++]= data[startF++];
            }else {
                copy[s++]= data[startS++];
            }
        }
        while (startF<=mid){
            copy[s++]= data[startF++];
        }
        while (startS<=high){
            copy[s++]= data[startS++];
        }
        for (int i = 0; i < copy.length; i++) {
            data[low++] = copy[i];
        }
    }

    /**
     * 计数排序
     * 桶排序的一种特殊情况，桶排序对数据有要求，要求数据能够比较均匀的
     * 分为若干个桶，这些桶也按照顺序进行排列，桶内的数据按照快速排序这样
     * 复杂度为O(nlog(n/m)),m接近n,复杂度接近O(n)。计数排序在此基础上，桶里装的
     * 是数据的个数而非数据，通过计数位次来进行排序，适合数值范围不大的数据序列进行排序
     * 且只适合非负整数，如果有非负整数或者小数，可以通过加法偏移和放大倍数来转化
     *
     * 基数排序：借助基数排序和桶排序，典型应用如电话号码排序，高位相同
     * 则递进排序地位否则直接给出结果，
     * @param array
     */
    public void countingSort(int[] array){
        if(array == null || array.length<1){
            return;
        }
        //构建计数数组,搜索数组中最大数max，长度为max+1,多余一位为0的位置
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]>max){
                max = array[i];
            }
        }
        int[] c = new int[max+1];
        //填充计数数组，下标表示数据的值，各个位置的值表示元素的个数
        for (int i = 0; i < array.length; i++) {
            c[array[i]]++;
        }
        //计数数组顺序求和，各个位置表示小于或等于该下标数字的个数
        for (int i = 1; i < c.length; i++) {
            c[i]=c[i]+c[i-1];
        }
        //构建排序数组
        int[] r = new int[array.length];
        //遍历原数组，根据计数数组的映射关系将数据放到排序数组中,这里必须从尾部开始遍历才能保证计数排序是稳定排序
        for (int i = array.length -1 ; i>=0; i--) {
            int index = c[array[i]] - 1;
            r[index] = array[i];
            c[array[i]]--;
        }
        //复制数组的原数组
        for (int i = 0; i < array.length; i++) {
            array[i] = r[i];
        }

    }

    private int hash(String element){
        return 1;
    }


    /**
     * 1.遍历字符串数组，以字符串为Key,散列到数组中,value是个数，记录最大value   max
     * 2.若max较小，使用计数排序，否则使用快排
     * 3.以max+1构造计数数组，下标为hash(key),value为key个数，[(2),(12),(6),(7),(9)]
     * 4.变更计数数组，value表示当前顺序计数，可以用另外一个数组和实体元素来操作顺序计数问题。
     *
     * @param array
     */

}
