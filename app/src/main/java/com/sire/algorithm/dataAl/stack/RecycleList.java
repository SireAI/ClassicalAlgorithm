package com.sire.algorithm.dataAl.stack;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/11
 * Author:Sire
 * Description:队列实现
 * ==================================================
 */
public class RecycleList implements IAlgorithm {
    @Override
    public void go() {

    }


    public class CircularQueue {
        private String[] nums;
        private int head;
        private int tail;
        private int n ;

        public CircularQueue(int capcity) {
            this.n = capcity;
            nums = new String[capcity];
        }

        public boolean enqeue(String num){
            //存储已经满了
            if((tail+1) % n == head){
                return false;
            }
            nums[tail] = num;
            tail = (tail+1)%n;
            return true;
        }

        public String dequeue(){
           if(head == tail){
               return null;
           }
           String num = nums[head];
           head = (head+1)%n;
           return num;
        }
    }

}
