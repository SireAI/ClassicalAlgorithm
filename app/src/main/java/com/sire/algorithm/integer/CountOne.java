package com.sire.algorithm.integer;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/01
 * Author:Sire
 * Description:计算从1到n的十进制数中，1出现的总次数，比如21
 * 则  1  10 11 12 13 14 15 16 17 18 19 21
 * ==================================================
 */
public class CountOne implements IAlgorithm {
    @Override
    public void go() {
        int result = numberOfOnes(21);
        System.out.println("===>"+result);
    }

    /**
     * 遍历数字，然后统计1的个数
     * 在一个数中如何检测 11  ：取余来获得个位数，除来降位
     */
    public int numberOfOnes(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int number = i;
            while (number > 0) {
                int last = number % 10;
                if(last == 1){
                    sum++;
                }
                number =  number/10;
            }

        }
        return sum;
    }
}
