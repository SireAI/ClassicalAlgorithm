package com.sire.algorithm.heap;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/05/12
 * Author:Sire
 * Description:堆的特点：
 * 1.完全二叉树
 * 2.每个节点的值都大于等于左右子树中所有节点的值，大顶堆；或者每个节点的值都小于等于左右子树中所有节值，小顶堆
 * <p>
 * 因为堆是完全二叉树，索引使用数组来存储数据，节省空间
 * 数据总索引1开始存储，设节点索引变量i，左节点为2*i,右节点为2*i+1
 * 将数组中数据的结构按照堆定义的方式进行组织成为堆化
 * 堆化：沿着节点所在的结构路径比较节点与父节点的大小，互换节点
 * ==================================================
 */
public class Heap {
    /**
     * 数组数据存储
     */
    private int[] array;
    /**
     * 已经存储的数据个数
     */
    private int count;
    /**
     * 最大存储
     */
    private int n;

    public Heap(int capacity) {
        array = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 添加与从下往上堆化，下往上的堆化比较简单，因为路径是确定的
     *
     * @param number
     */
    public void insert(int number) {
        if (count < n) {
            //添加到末尾
            count++;
            int current = count;
            array[current] = number;
            //堆化,沿着节点路径从下往上比较
            while (current / 2 > 0 && array[current / 2] < array[current]) {
                swap(current);
                current = current / 2;
            }
        } else {
            throw new RuntimeException("reject");
        }
    }

    /**
     * 删除与堆化，从上往下堆化，需要选择路径
     */
    public void deleteTop() {
        if (count == 0) {
            return;
        }
        if (count == 1) {
            array[count] = 0;
            count--;
        }

        if (count > 1) {
            array[1] = array[count];
            array[count] = 0;
            count--;
            int i = 1;
            while (true) {
                //左右路径,取最大值的索引
                int maxPos = i;
                if ((2 * i <= n) && (array[i] < array[2 * i])) {
                    maxPos = 2 * i;
                }
                if ((2 * i + 1 <= n) && (array[maxPos] < array[2 * i + 1])) {
                    maxPos = 2 * i + 1;
                }
                if (maxPos == i) {
                    break;
                }
                //与最大值进行交换
                int temp = array[i];
                array[i] = array[maxPos];
                array[maxPos] = temp;
                i = maxPos;
            }
        }
    }

    private void swap(int current) {
        int temp = array[current / 2];
        array[current / 2] = array[current];
        array[current] = temp;
    }
}
