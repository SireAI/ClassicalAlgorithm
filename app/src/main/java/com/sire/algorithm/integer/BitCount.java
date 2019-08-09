package com.sire.algorithm.integer;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/09
 * Author:Sire
 * Description:10.输入以整数，统计这个整数二级制1的个数
 * ==================================================
 */
public class BitCount implements IAlgorithm {
    @Override
    public void go() {
        int count = oneBitCount(5);
    System.out.println("====>"+count);
    }

    /**
     * 判断是否为奇数或者二进制尾部是否为1
     * n&1 ==1
     * 右移>>
     * @param n
     * @return
     */
    private int oneBitCount(int n){
        int count = 0;
        while (n>0){
            if((n & 1) == 1){
                count++;
            }
            n>>=1;
        }
        return count;
    }
}
