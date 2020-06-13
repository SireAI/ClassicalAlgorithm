package com.sire.algorithm.dp;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/06/12
 * Author:Sire
 * Description:
 * 0-1背包：背包最大承载量是9，有5个不同物品，每个物品的重量是2，2，4，6，3
 * 使用动态规划求解如何放置物品达到最大承载量
 * 动态规划思想：将问题分为多个阶段，每个阶段有多种决策，根据上个阶段
 * 的状态以及当前的决策，确定下个阶段的状态。
 * 特点：每个阶段的选择相互影响；动态性体现在每个阶段的状态依据上个状态和
 * 当前选择来确定
 * ==================================================
 */
public class ZeroOnePackage implements IAlgorithm {
    public int dpPack(int w, int[] weight) {
        //状态数组，用来记录选择的状态
        boolean[][] states = new boolean[weight.length][w + 1];
        //计算第一个阶段状态
        states[0][0] = true;//不选择
        if (weight[0] < w) {
            states[0][weight[0]] = true;  //选择
        }
        //循环计算剩余阶段
        for (int i = 1; i < weight.length; i++) {
            //根据上一阶段状态，决定当前阶段状态
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j]) {
                    //不选择，则直接继承上次的选择状态
                    states[i][j] = true;
                    //添加的数量不能超过总重量
                    if ((j + weight[i]) <= w) {
                        //选择，在上次状态上累加
                        states[i][j + weight[i]] = true;
                    }
                }
            }

        }
        //倒叙搜索最后一层
        for (int i = w; i >= 0; i--) {
            if (states[weight.length - 1][i]) {
                return i;
            }
        }
        return -1;
    }

    public int dpPack2(int w, int[] weight) {
        //状态数组，用来记录选择的状态
        boolean[] states = new boolean[w + 1];
        //计算第一个阶段状态
        states[0] = true;//不选择
        if (weight[0] < w) {
            states[weight[0]] = true;  //选择
        }
        //循环计算剩余阶段
        for (int i = 1; i < weight.length; i++) {
            //根据上一阶段状态，决定当前阶段状态
            for (int j = w; j >= 0; j--) {
                //添加的数量不能超过总重量
                if (states[j] && (j + weight[i]) <= w) {
                    //选择，在上次状态上累加
                    states[j + weight[i]] = true;
                }
            }

        }
        //倒叙搜索最后一层
        for (int i = w; i >= 0; i--) {
            if (states[i]) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 0-1背包，限制重量下，总价值最大
     * 思路状态数组记录价值，同一个位置，高价值覆盖低价值
     * 1.状态数组
     * 2.阶段
     * 3.上一阶段状态决定下一阶段状态
     * @param w
     * @param weight
     * @return
     */
    public int dpPack3(int w, int[] weight, int[] value) {
        //状态数组，用来记录选择的状态,值是最大值
        int[][] states = new int[weight.length][w + 1];
        //初始化值
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < w + 1; j++) {
                states[i][j] = -1;
            }
        }
        //计算第一个阶段状态
        states[0][0] = 0;//不选择
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];  //选择
        }
        //循环计算剩余阶段
        for (int i = 1; i < weight.length; i++) {
            //根据上一阶段状态，决定当前阶段状态
            for (int j = 1; j <= w; j++) {
                if (states[i - 1][j] > 0) {
                    //不选择物品
                    states[i][j] = states[i - 1][j];
                    if (j + weight[i] <= w) {
                        //选择物品
                        int newValue = states[i - 1][j] + value[i];
                        if (newValue > states[i][j + weight[i]]) {
                            //价值更大
                            states[i][j + weight[i]] = value[i];
                        }
                    }
                }
            }


        }
        //倒叙搜索最后一层
        int max=-1;
        for (int i = w; i >= 0; i--) {
            if (states[weight.length-1][i]>max) {
                max = states[weight.length-1][i];
            }
        }
        return max;
    }

    @Override
    public void go() {
        ZeroOnePackage zeroOnePackage = new ZeroOnePackage();
        int i = zeroOnePackage.dpPack2(17, new int[]{2, 4, 6, 1, 7});
        System.out.println(i);
    }
}
