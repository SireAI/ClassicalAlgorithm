package com.sire.algorithm.array;


import android.support.v4.util.Pair;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/04
 * Author:Sire
 * Description:一个数组中除了两个数字外，其他数字都出现了两次，请找出只出现了一次的两个数字
 *  * 要求时间复杂度是O(n)  【1，1，2，7，3，4，2，4，3，5】
 * ==================================================
 */
public class XOR implements IAlgorithm {
    @Override
    public void go() {
        int[] array = {2,1,2,3,4,5,6,5,1,7,6,4};
        Pair<Integer, Integer> integerIntegerPair = xorFind(array);
        System.out.println("=====>"+integerIntegerPair.first+","+integerIntegerPair.second);
    }

    /**
     * 解法1：异或运算有累加不同数消去相同数的功能，利用这个特性可以将偶数个数消去，奇数个数保留
     * 那么剩下的问题就是如何将奇数拆分到两个数组里。
     * 两个数异或结果不为0，说明二者不相等，二进制位上存在1，这个1的意义是这两个数在这个位置上不相等，或为
     * 1，0，或为0，1，可以按照这个位置对数据进行分类。对于相同的数字，这个位置上的二进制相等，因此肯定在同一组
     * 时间复杂度O(N),空间复杂度O(1)
     * 但是不用真的放数组里，最后也需要通过加总的变量来进行以后求值，不如直接在循序中进行。
     * 解法2：使用一个Map来存储各个值存储的次数，然后遍历集合判断次数的奇偶性，时间复杂度O(N)
     * 空间复杂度O(N)
     */
    public Pair<Integer,Integer> xorFind(int[] array){
      //遍历异或,获得异或结果
        int resultXOR = 0;
        for (int i = 0; i < array.length; i++) {
            resultXOR^=array[i];
        }
      //获得异或结果二级制第一个1的位置
        int index = 0;
        while ((resultXOR & 1)==0 && index <= 32){
            resultXOR >>= 1;
            index++;
        }
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < array.length; i++) {
            if(isBit1(array[i],index)){
                num1^=array[i];
            }else {
                num2^=array[i];
            }
        }
        //两个数组分别装下分组的元素
        //异或求和
        return new Pair<>(num1,num2);
    }

    private boolean isBit1(int num,int index){
        return ((num >> index) & 1) == 1;
    }
}
