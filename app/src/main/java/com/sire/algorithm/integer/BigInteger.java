package com.sire.algorithm.integer;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/12
 * Author:Sire
 * Description:12.输入1到最大的n位数，比如n = 3,则打印1,2,3...999
 * n可能会超出语言所能表达的最大可值，因此是个大数问题
 * ==================================================
 */
public class BigInteger implements IAlgorithm{
    @Override
    public void go() {
     printBigInteger(3);
    }

    /**
     * 由于n位数字可能超过整数范围，因此是个大数的问题
     * 表示方式使用字符串，模拟加一使用数组
     * 分为两个阶段，累加，打印
     * 累加阶段在数组上完成进位，以任意两位为考察
     * 如果加一后相应位数的值小于10则保持不变
     * 如果大于10，该位置需要进位，对进位的位置在做该类检查
     * 边界条件是进位到0位置且累加后值为10
     * @param n
     */
    private void printBigInteger(int n){
        if(n<=0){
            throw new RuntimeException("invalid input");
        }
        int[] chars = new int[n];
        while (increment(chars)){
            printNumber(chars);
        }
    }

    /**
     * 遍历数组组装数字
     * @param chars
     */
    private void printNumber(int[] chars) {
        //{0,9,9}
        String str = "";
        boolean start = false;
        for (int i = 0; i < chars.length; ++i) {
          if(chars[i]!=0 &&!start){
            start = true;
          }
          if(start){
              str+=chars[i];
          }
        }
       System.out.println(str);
    }

    /**
     * 数组操作模拟加法
     * @param chars
     * @return
     */
    private boolean increment(int[] chars) {
        //进位起始位置,小数从高位开始 //{0,9,9}
        int start = chars.length-1;
        //进位+1
        for (int i = start; i >= 0 ; --i) {
            //该位置累加1
            int data = chars[i] + 1;
            if(i == 0 && data == 10){
                //达到最大值
                return false;
            }else {
                if(data<10){
                    //不发生进位操作
                    chars[i] = data;
                    break;
                }else {
                    chars[i] = 0;
                }
            }
        }
        return true;
    }
}
