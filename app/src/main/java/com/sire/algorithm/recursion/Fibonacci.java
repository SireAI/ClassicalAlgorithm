package com.sire.algorithm.recursion;

import com.sire.algorithm.IAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/09
 * Author:Sire
 * Description:9.写一个函数斐波那契数列，f(n) = f(n-1)+f(n-2),n>1
 * f(0)=0;f(1)=1
 * ==================================================
 */
public class Fibonacci implements IAlgorithm{
    @Override
    public void go() {
        int fibonacci = fibonacci(5);
        int fibonacci2 = fibonacci2(5);
        int fibonacci3 = fibonacci3(5);
    System.out.println(fibonacci+"=====>"+fibonacci3);
    }

    /**
     * 根据通项公式，由动态规划很容得出递归实现
     * 通项公式即是要解决的子问题,本质是个二叉树结构
     * 大量的重复计算结果随着n的增大，性能下降的厉害
     * 提升的方向是重复使用已经计算的结果
     * @param n
     * @return
     */
    private int fibonacci(int n){
        if(n<0){
            throw new RuntimeException("invalid inuput");
        }
        if(n == 0 || n == 1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    /**
     * 对计算结果进行缓存的改进方案
     * 面向子问题
     */
    private int[] cachedResult ;
    private int fibonacci2(int n){

        if(n<0){
            throw new RuntimeException("invalid inuput");
        }
        if(n == 0 || n == 1){
            return n;
        }
        if(cachedResult == null){
            cachedResult = new int[n];
        }
        int first = cachedResult[n - 1];
        if(first == 0){
            first = fibonacci(n-1);
            cachedResult[n-1] = first;
        }
        int second = cachedResult[n - 2];
        if(second == 0){
            second = fibonacci(n-2);
            cachedResult[n-1]=second;
        }
        return first+second;
    }

    /**
     * 正面从通项公式本身出发，使用循环和指针的方式来解决这个问题
     * 正面的解决方案是从不断迭代的角度来思考的.
     * 面向过程
     * @param n
     * @return
     */
    private int fibonacci3(int n){
        if(n<0){
            throw new RuntimeException("invalid inuput");
        }
        if(n == 0 || n == 1){
            return n;
        }
        //三个指针分别表示通向公式中的三项
        int f1 = 0;
        int f2 = 1;
        int c = 0;
        for (int i = 2; i <= n; ++i) {
            c = f2+f1;
            f1 = f2;
            f2 = c;
        }
        return c;
    }
}
