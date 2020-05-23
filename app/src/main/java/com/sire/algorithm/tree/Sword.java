package com.sire.algorithm.tree;

public class Sword {

    public static void main(String[] args){
        int[][] data = new int[][]{new int[]{1,2,4,6},new int[]{2,4,7,8},new int[]{8,9,10,11},new int[]{9,12,13,15}};
        findNumber(data,data.length-1,0,5);
    }

    /**
     * 用例：边界检查，正负数检查
     * 1,从右上角取数比较，若查找数比数组中取得的数大，则丢弃该数所在行；否则丢弃该数所在列
     * 2,重复1，直到找到该数或者行达到最大值，列达到最小值
     * @param data  二维矩阵
     * @param column  最大列
     * @param row   起始行
     * @param number 要查找的数
     */
    public static void findNumber(int[][] data,int column,int row,int number){
        if(column<0 || row >= data[0].length){
            System.out.println("did not find the number");
        }else {
            final int element = data[column][row];
            if(element == number){
                System.out.println("find the number");
            }else if(element<number){
                findNumber(data,column,++row,number);
            }else {
                findNumber(data,--column,row,number);
            }
        }
    }
}
