package com.sire.algorithm.queue;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/06/10
 * Author:Sire
 * Description:
 * ==================================================
 */
public class Consumer {
    private CircleQueue circleQueue;

    public Consumer(CircleQueue circleQueue) {
        this.circleQueue = circleQueue;
    }
    public void consume() throws InterruptedException {
        while (true){
            if(circleQueue.poll() == null){
                Thread.sleep(100);
            }else {
                // do some stuff
            }

        }
    }
}
