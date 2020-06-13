package com.sire.algorithm.queue;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/06/09
 * Author:Sire
 * Description:
 * ==================================================
 */
public class CircleQueue {
    private Long[] datas;
    private int size=0,tail=0,head=0;

    public CircleQueue(int size) {
        this.datas = new Long[size];
        this.size = size;
    }
    public boolean offer(Long data){
        //尾部指针反追头部指针
        if((tail+1)%size==head){
            return false;
        }
        datas[tail] = data;
        tail = (tail+1)%size;
        return true;
    }

    public Long poll(){
        //头部指针反追尾部指针
        if(head == tail){
            return null;
        }
        long ret = datas[head];
        head = (head+1)%size;
        return ret;
    }
}
