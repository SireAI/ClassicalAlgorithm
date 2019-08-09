package com.sire.algorithm.string;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/08
 * Author:Sire
 * Description:4.请实现一个函数把字符串中的空格替换成20%
 * ==================================================
 */
public class StringSpace implements IAlgorithm {
    @Override
    public void go() {
        String we_are_happy = stringSpace1("we are happy");
      System.out.println("====>"+we_are_happy);
    }

    /***
     * 遍历思想：遍历字符串，遇到空格后面的部分整体移动两个空格，然后填充20%，
     * 时间负责读n2
     */
    private static String stringSpace1(String str){
       if(str == null || str.equals("")){
           throw new RuntimeException("invalid input");
       }
        char[] chars = str.toCharArray();
       int size = chars.length;
       int finalSize = size;
        for (int i = 0; i < size;i++) {
          if(chars[i] == ' '){
              finalSize+=2;
          }
        }
        char[] finalChars = new char[finalSize];
        int finalIndex = 0;
        for (int i = 0; i < size;i++) {
            if(chars[i] == ' '){
                finalChars[finalIndex++]='2';
                finalChars[finalIndex++]='0';
                finalChars[finalIndex++]='%';
            }else {
                finalChars[finalIndex++]=chars[i];
            }
        }
        return new String(finalChars);
    }
}
