package com.sire.algorithm.queue;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/06/10
 * Author:Sire
 * Description:
 *
 * ==================================================
 */
public class Producer {
    private CircleQueue circleQueue;

    public Producer(CircleQueue circleQueue) {
        this.circleQueue = circleQueue;
    }

    public void produce(Long data) throws InterruptedException {
        while (!circleQueue.offer(data)){
            Thread.sleep(100);
        }
    }
}
