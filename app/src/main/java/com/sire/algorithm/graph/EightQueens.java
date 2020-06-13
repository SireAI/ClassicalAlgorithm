package com.sire.algorithm.graph;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/05/19
 * Author:Sire
 * Description:八皇后问题
 * 问题：8x8的棋盘，放入8个棋子，要求每个棋子所在的行、列、对角线不能
 * 有其他棋子，找出所有满足放置棋子的方式。
 * 分析：
 * 数学上这是个排列组合计数问题
 * 回溯思想：枚举所有可能的结果，从结果中寻找出期待的结果，如果路劲结果不满足，则
 * 回退到上一个岔路口。回溯思想特点是穷尽所有结果，判断结果是否满足，满足则收录，不满足则丢弃
 * 按照一定规则去寻找结果可以避免重复遍历和计算，图的深度优先遍历即是回溯思想的使用。
 * 回溯问题非常时候yoga递归来解决，结果 = 当前满足+下一个节点满足
 * ==================================================
 */
public class EightQueens implements IAlgorithm {
    /**
     * 记录棋子位置，索引代表结果所在行，值代表棋子所在列
     * 为什么可以回溯：因为每一行的位置只有一个，若结果不满足预期，之前记录的结果将会被覆盖
     */
    private int[] result = new int[8];

    /**
     * 按照行递增的规律来搜索结果，避免重复
     * 分为8个阶段，即为寻找一个满意的结果需要8步，上一步成功
     * 才能进行下一步
     */
    public void cal8Quenes(int row){
        if(row == 8){
            //说明前8行都已经满足条件，则递归结束
            printQueens();
            return;
        }
        //判断一行中的每个column是否满足条件
        for (int column = 0; column < 8; column++) {
            if(isOk(row,column)){
                result[row]=column;
                //判断下一行
                cal8Quenes(row+1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        //1.判断列上是否有棋子；2.判断对角线上是否有棋子
        int leftUp = column-1;
        int rightUp = column+1;
        for (int upRow = row -1; upRow >= 0; upRow--) {
            if(result[upRow] == column){
                return false;
            }
            if(leftUp>=0){
                if(result[upRow] == leftUp){
                    return false;
                }
            }
            if(rightUp<8){
                if(result[upRow] == rightUp){
                    return false;
                }
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    /**
     * 打印结果矩阵
     */
    private void printQueens() {
        System.out.println();
        System.out.println();
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if(result[row] == column){
                    System.out.print("Q");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void go() {
        cal8Quenes(0);
    }
}
