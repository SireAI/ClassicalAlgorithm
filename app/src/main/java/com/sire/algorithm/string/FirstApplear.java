package com.sire.algorithm.string;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/05
 * Author:Sire
 * Description:35.在字符串中找出第一个只出现一次的字符，如"agaccdeff"
 * 则输出b
 * ==================================================
 */
public class FirstApplear implements IAlgorithm {
    @Override
    public void go() {
        char re = findOutFirstChar2("agaccdeff");
        System.out.println("====>"+re);
    }

    /**
     * 是不是只出现一次，只有扫描完字符数组才只能
     * 第一个可以按照顺序来获取
     * 按序遍历搜索
     * @param str
     * @return
     */
    public char findOutFirstChar(String str){
        if(str == null || str.length() == 0){
            throw new RuntimeException("invalid input");
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                continue;
            }
            int j = i+1;
            boolean find = false;
            if(j< chars.length){
                for (; j < chars.length; j++) {
                    if(chars[i] == chars[j]){
                        find = true;
                        chars[i] = chars[j]= ' ';
                        break;
                    }
                }
            }
            if(!find){
                return chars[i];
            }
        }
        return 0;
    }

    /**
     * 和出现次数有关，可以使用Map来记录字符出现的次数。
     * 加入不让使用map，那么使用数组来模拟，字符表示元组位置，值表示字符出现的次数
     * 字符8为，有256种可能，因此创建一个数组256大小
     * 简单的散列表建设：确定字符大大小范围来确定数组的大小，按照asii码来进行映射
     * @return
     */
    public char findOutFirstChar2(String str){
        int[] datas = new int[256];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            datas[chars[i]]+=1;
        }
        for (int i = 0; i < chars.length; i++) {
            if(datas[chars[i]] == 1){
                return chars[i];
            }
        }
        return 0;
    }
}
