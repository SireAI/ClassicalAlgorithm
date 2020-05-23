package com.sire.algorithm.heap;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/05/12
 * Author:Sire
 * Description:堆排序
 * O(nlogn)原地排序
 * 思路1：从下往上堆化，使用堆的插入方法逻辑来构建对
 * 思路2：从上往下堆化
 * 步骤
 * 1.建堆,比较一个节点与左右子节点的关系，进行交换
 * 2.排序
 *
 * 比较和移动次数较多，没有快速排序好
 * ==================================================
 */
public class HeapSort {

    /**
     * 建堆，每个节点左右比较，满足堆的节点定义
     *
     * @param data
     */
    public void heapSort(int[] data, int n) {
        if (n == 0) {
            return;
        }
        //遍历节点,建堆 O(n)
        for (int i = n / 2; i >= 1; i--) {
            heapify(data, i, n);
        }
        //排序O(logn)
        sortHeap(data, n);
    }

    /**
     * 将堆顶元素放在数组尾部，尾部数据放在堆顶，然后对除了第n个数外其他的n-1个
     * 数进行堆化
     *
     * @param data
     * @param n
     */
    private void sortHeap(int[] data, int n) {
//        int k = 0;
//        while (true){
//            //交换
//            int temp = data[1];
//            data[1] = data[n-k];
//            data[n-k] = temp;
//            //堆化
//            heapify(data,1,n-k-1);
//            if(++k==n-1){
//                break;
//            }
//        }
        int k = n;
        while (k > 1) {
            int temp = data[1];
            data[1] = data[k];
            data[k] = temp;
            k--;
            heapify(data, 1, k);
        }
    }

    private void heapify(int[] data, int i, int n) {
        while (true) {
            //找出最大位置，进行交换，要保证交换后下面的路劲是满足定义的
            int maxPos = i;
            if (2 * i <= n && data[i] < data[2 * i]) {
                maxPos = 2 * i;
            }
            if ((2 * i + 1 <= n && data[maxPos] < data[2 * i + 1])) {
                maxPos = 2 * i + 1;
            }
            if (maxPos == i) {
                break;
            }
            int temp = data[maxPos];
            data[maxPos] = data[i];
            data[i] = temp;
            i = maxPos;
        }

    }
}
