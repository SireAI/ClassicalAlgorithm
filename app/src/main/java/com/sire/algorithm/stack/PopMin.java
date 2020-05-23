package com.sire.algorithm.stack;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/13
 * Author:Sire
 * Description:21.定义栈的数据结构，实现一个能获得栈最小值的函数，实现min,push,pop
 * 函数，时间复杂度O(1)
 * ==================================================
 */
public class PopMin implements IAlgorithm{

    @Override
    public void go() {

    }

    interface IStack<T>{
        void push(T t);
        void pop();
        T min();
    }


    class StackImpl<T> implements IStack<T>{

        @Override
        public void push(T t) {

        }

        @Override
        public void pop() {

        }

        @Override
        public T min() {
            return null;
        }
    }
}
