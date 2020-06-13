package com.sire.algorithm.graph;

import com.sire.algorithm.IAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/05/19
 * Author:Sire
 * Description:
 * 0-1背包问题：有一个背包w kg,有n个物品，这些物品的重量各不相同不可分割，我们期望从这n件物品中
 * 选择几件物品，使得在不超过背包承载量的情况下使得背包中的物品总重量最大
 * 回溯思想
 * ==================================================
 */
public class ZeroOnePackage implements IAlgorithm {


    private int[] weights = new int[5];

    @Override
    public void go() {
//    zeroOnePKG(10,new int[]{2,4,6,1,7},0);
        find(0,0,new int[]{2,4,6,1,7},17,new boolean[5][18]);
        System.out.println(mMax);
    }

    /**
     * 分成n个阶段来回溯
     * 使用一个容器来装所有的重量
     *
     * @param totalPackage
     * @param stuffs
     */
    public void zeroOnePKG(int totalPackage, int[] stuffs, int index) {
        if (index >= stuffs.length) {
            printWeights();
            return;
        }

        int current = getCurrentTotal();
        if ((current + stuffs[index]) <= totalPackage) {
            weights[index] = stuffs[index];
        }else {
            weights[index] = 0;
        }
        zeroOnePKG(totalPackage, stuffs, ++index);

    }

    private int getCurrentTotal() {
        int result = 0;
        for (int i = 0; i < weights.length; i++) {
            result+=weights[i];
        }
        return result;
    }

    private void printWeights() {
        System.out.println();
        System.out.println();
        for (int i = 0; i < weights.length; i++) {
            if(weights[i]!=0){
                System.out.print(weights[i]);
                System.out.print(" ");
            }
        }
    }


    private int mMax = 0;
    /**
     * 穷举2^n中情况，从中选择符合条件的结果
     * 分为n个步骤，每个步骤有两种选择，选择加入累计重量
     * 不选择加入累计重量。
     * 设置一个变量记录最大值，每次最终结果进行比较替换
     *
     * 反思：对比上面的解法有暴露出两个问题
     * 1.如何确定结果，结果只需要一个最接近包重量，而不是打印所有数字
     * 2.如何体现选择性，上面的解法，对一个阶段，只体现了选择这一阶段重量，所以结果只能满足前面，不能满足后面
     */
    /**
     *
     * @param index 考察的当前阶段
     * @param currentWeight 当前累计重量
     * @param items 重量
     * @param constraintWeight  包限制重量
     */
    public void find(int index,int currentWeight,int[] items,int constraintWeight,boolean mem[][]){
        //终止条件
        if(currentWeight == constraintWeight || index == items.length){
            if(currentWeight>mMax){
                mMax = currentWeight;
            }
            return;
        }
        //使用'备忘录'来剪裁分支
        if(mem[index][currentWeight]){
            return;
        }
        mem[index][currentWeight] = true;
        //跳过不选择
        find(index+1,currentWeight,items,constraintWeight,mem);
        //选择
        if(currentWeight+items[index]<=constraintWeight){
            find(index+1,currentWeight+items[index],items,constraintWeight,mem);
        }
    }
}
