package com.sire.algorithm.stack;

import com.sire.algorithm.IAlgorithm;

import java.util.Stack;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/09
 * Author:Sire
 * Description:用两个栈实现队列。
 * 队列的两个函数appendTail,deleteHead分别完成在尾部插入，在都不删除
 * ==================================================
 */
public class StackQueue implements IAlgorithm{

    @Override
    public void go() {
        Queue<String> queue = new QueueImpl<>();
        queue.appendTail("1");
        queue.appendTail("2");
        queue.appendTail("3");
        queue.appendTail("4");
        String first = queue.deleteHead();
        System.out.println("====>"+first);
        queue.appendTail("6");
         first = queue.deleteHead();
        System.out.println("====>"+first);
         first = queue.deleteHead();
        System.out.println("====>"+first);
         first = queue.deleteHead();
        System.out.println("====>"+first);
         first = queue.deleteHead();
        System.out.println("====>"+first);
         first = queue.deleteHead();
        System.out.println("====>"+first);

    }

    public interface Queue<T>{
        void appendTail(T t);
        T deleteHead();
    }

    /**
     * A栈用于装入元素
     * B栈用于从A中获取元素并推出栈顶
     * @param <T>
     */
    class QueueImpl<T> implements Queue<T>{
        Stack<T> head = new Stack<>();
        Stack<T> tail = new Stack<>();

        @Override
        public void appendTail(T t) {
            tail.push(t);
        }

        @Override
        public T deleteHead() {
            if(head.isEmpty()){
                while (!tail.isEmpty()){
                    head.push(tail.pop());
                }
            }
            if(!head.isEmpty()){
               return head.pop();
            }
            return null;
        }
    }
}
