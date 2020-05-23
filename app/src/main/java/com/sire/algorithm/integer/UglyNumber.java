package com.sire.algorithm.integer;

import android.os.SystemClock;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/05
 * Author:Sire
 * Description:我们把因子只包含2，3，5的数称为丑数，求按照从小到大排列的
 * 第1500个丑数，6，8是丑数，14不是，因为包含因子7。1作为第一个丑数
 * ==================================================
 */
public class UglyNumber implements IAlgorithm {

    @Override
    public void go() {
        //1 2  3 5    4
        long begin = System.currentTimeMillis();
        int resutl = printUglyNumber(1500);
        long middle = System.currentTimeMillis();
        System.out.println("one:"+(middle-begin));
        int resutl1 = printNumber2(1500);
        System.out.println("two:"+(System.currentTimeMillis() - middle));

        System.out.println(resutl1+"=====>" + resutl);
    }

    /**
     * 累加遍历数字，判断每个数字是不是丑数
     */
    public int printUglyNumber(int order) {
        int uglyNumber = 0;
        int index = 0;
        while (index < order) {
            uglyNumber++;
            if (isUgly(uglyNumber)) {
                index++;
            }
        }
        return uglyNumber;
    }

    /**
     * 去除一个数中所有的特定因子
     *
     * @return
     */
    public boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    /**
     * 在丑数的基础上进行递增的思想
     * 将丑数按照顺序排列在一个数组中
     * 增长的方式：从前面的数开始，乘以2，3，5，获得一个最小的放在递增的位置，比较的数是目前数组最大数
     * 乘数的开始，从略小当前最大数开始
     * 刚方式在比方式1块非常多，特点是利用已经计算的成果来计算下一步
     * @param order
     * @return
     */
    public int printNumber2(int order) {
        if (order <= 0) {
            throw new RuntimeException("invalid input");
        }
        int[] data = new int[order];
        int currentIndex = 0;
        data[currentIndex] = 1;
        int start2 = 0;
        int value2 = 0;

        int start3 = 0;
        int value3 = 0;

        int start5 = 0;
        int value5 = 0;


        while (currentIndex < order-1) {
            while (value2 <= data[currentIndex]) {
                value2 = data[start2++] * 2;
            }
            while (value3 <= data[currentIndex]) {
                value3 = data[start3++] * 3;
            }
            while (value5 <= data[currentIndex]) {
                value5 = data[start5++] * 5;
            }
            data[++currentIndex] = Math.min(value2,Math.min(value3,value5));
        }

        return data[order-1];
    }

}
