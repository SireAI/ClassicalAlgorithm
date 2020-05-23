package com.sire.algorithm.string;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/06
 * Author:Sire
 * Description:28.输入一个字符串打印这个节字符串的全排列
 * ==================================================
 */
public class StringP implements IAlgorithm {
    @Override
    public void go() {
        printAll("abc".toCharArray(),0);
    }

    /**
     * 分治思想，将字符串分成两部分，第一个字符和后面所有的字符，假设将后面的字符设为X
     * 那么穷尽当前?x这种排列
     * 将数组分为两部分第一个部分和第二部分
     * 第一部分是单个字符，第二部分是字符串，第二部分的每个字符串都与第一个部分
     * 发生交换
     */
    public void printAll(char[] chars,int start){
        //指针走到末尾，打印字符串
        if(start == chars.length){
            System.out.println("===>"+new String(chars));
        }else {
            for (int i = start; i < chars.length; i++) {
                //完成每一位的交换
                char temp = chars[i];
                chars[i] = chars[start];
                chars[start] = temp;
                //?x完成排列，对x进行操作
                printAll(chars,++start);
                //保持原样交换回来
                char temp1 = chars[--start];
                chars[start] = chars[i];
                chars[i] = temp1;
            }
        }
    }
}
