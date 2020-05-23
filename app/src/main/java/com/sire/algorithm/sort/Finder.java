package com.sire.algorithm.sort;

import java.util.Stack;

/**
 * =====================================================
 * All Right Reserved
 * Date:2019/5/20
 * Author:wangkai
 * Description:
 * =====================================================
 */
public class Finder {
    public static void main(String[] args){
        final int[] ints = {2, 3, 1, 7,11, 9, 4, 6, 5};
        final int[] search = search(ints, 0, ints.length - 1);
        System.out.println(search[0]+":"+search[1]);
    }

    private static void coding(int[] b ,int n){
        //组合的问题，基本项，当只有一个布尔值的时候输出0或者1
        //当有n个布尔值的时候，递归项,n位输出0或者1，2^(n-1）输出字符创
        if(n == 0){
            b[n] = 0;
            print(b);
            b[n] = 1;
            print(b);
        }else {
            b[n-1] = 0;
            coding(b,n-2);
            b[n-1]=1;
            coding(b,n-2);
        }
    }

    private static int[] search(int[] array,int left,int right){
        //将数组分成两个比较，求得每个数组中的最大值和最小值，然后两个数组中的最小最大值进行比较
        //基本项，若一个数中只有两个元素，那么最小值最大值相互比较下即可获得
        final int[] result = new int[2];
        if(right - left == 1){
            if(array[right] >= left){
                result[0]=array[left];
                result[1] = array[right];
            }else {
                result[0]=array[right];
                result[1] = array[left];
            }
        }else {
            int mid = left+(right-left)/2;
            final int[] leftResult = search(array, left, mid);
            final int[] rightResult = search(array, mid, right);
            result[0] = leftResult[0]<=rightResult[0]?leftResult[0]:rightResult[0];
            result[1] = leftResult[1]>=rightResult[1]?leftResult[1]:rightResult[1];
        }
        return result;
    }

    private static void print(int[] b){
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
        System.out.println();
    }

    /**
     *
     * @param positions  迷宫举证的数学模型
     * @param startX  起始点x
     * @param startY  起始点y
     * @param endX    结束点x
     * @param endY    结束点Y
     */
    private void mazeExsit(Position[][] positions,int startX,int startY,int endX,int endY){
        //起点
        final Position startPosition = new Position(startX, startY, '0', true);
        final Stack<Position> positionStack = new Stack<>();
        positionStack.push(startPosition);
        while (!positionStack.empty()){
            final Position peek = positionStack.peek();
            if(peek.x == endX && peek.y == endY && peek.type == '0'){
                //终点
                break;
            }else if(peek.type == '1'){
                positionStack.pop();
            }else {
                if(peek.x-1>=0){
                    final Position position = positions[peek.x - 1][peek.y];
                    if(!position.visited){
                       positionStack.push(position);
                    }
                }else if(peek.y-1>=0){
                    final Position position = positions[peek.x][peek.y-1];
                    if(!position.visited){
                        positionStack.push(position);
                    }
                }else if(peek.x+1<=positions.length){
                    final Position position = positions[peek.x+1][peek.y];
                    if(!position.visited){
                        positionStack.push(position);
                    }
                }else if(peek.y+1<=positions[0].length){
                    final Position position = positions[peek.x - 1][peek.y];
                    if(!position.visited){
                        positionStack.push(position);
                    }
                }
            }
        }
    }
    static class Position{
        private int x;
        private int y ;
        private char type;
        private boolean visited;

        public Position(int x, int y, char type, boolean visited) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.visited = visited;
        }
    }
}
