package com.sire.algorithm.array;

import com.sire.algorithm.IAlgorithm;

import java.util.ArrayList;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/01
 * Author:Sire
 * Description:输入一个S，打印所有和为S的连续整数序列。比如15
 * 则有12345   456  78
 * ==================================================
 */
public class SequenceArray implements IAlgorithm {

    @Override
    public void go() {
        sequenceArray(15);
    }

    /**
     * 按序累加，保值数是连续的
     * 比较与对应值的大小，若大于曾舍去最小位，若小于则增加最大为
     * 相等则打印
     * 特点，观察数组自身的演算范式，泛化
     */
    public void sequenceArray(int n) {
        if(n<=2){
            throw new RuntimeException("invalid input");
        }
        int low = 1;
        int heigh = 2;
        int sum = 3;
        for (int i = 1;i<=n;i++){
            if(sum<n){
                heigh+=1;
                sum+=heigh;
            }else if(sum > n){
                sum-=low;
                low+=1;
            }else {
                for (int j = low; j <= heigh; j++) {
                    System.out.print(j);
                }
                System.out.println("");
                heigh+=1;
                sum+=heigh;
                sum-=low;
                low+=1;
            }

        }
    }



}
