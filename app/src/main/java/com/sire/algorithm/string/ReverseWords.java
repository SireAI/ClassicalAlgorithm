package com.sire.algorithm.string;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/04
 * Author:Sire
 * Description:
 * ==================================================
 */
public class ReverseWords implements IAlgorithm {
    @Override
    public void go() {
        String words = "I am a student.";
        String revercse = revercse(words);
        System.out.println("==>"+revercse);
    }

    /**
     * 通过收尾双指针遍历交换完成句子的翻转
     * 识别单词，如果识别单词，空格开始，空格结束，处理特殊情况
     * 完成单词的翻转
     * @param words
     * @return
     */
    public String revercse(String words){
        if(words == null || words.length() == 0){
            throw new RuntimeException("invalid input");
        }
        char[] chars = words.toCharArray();
        reverseWords(chars,0,chars.length-1);
        int low = 0;
        int heigh = 0;
        while (heigh<chars.length){
            //low从0位置或者空格位置开始
            //heigh从空格位置后退一步结束
            if(low!=0){
                while (low<chars.length && chars[low]!=' '){
                    low++;
                }
                low++;
            }
            while (heigh<chars.length && chars[heigh]!= ' '){
                heigh++;
            }
            heigh--;
            reverseWords(chars,low,heigh);
            if(low == 0){
                low+=1;
            }
            heigh+=2;
        }
        return new String(chars);
    }

    private void reverseWords(char[] words,int low,int heigh){
        while (low<heigh){
            char temp = words[low];
            words[low] = words[heigh];
            words[heigh] = temp;
            low++;
            heigh--;
        }
    }
}
