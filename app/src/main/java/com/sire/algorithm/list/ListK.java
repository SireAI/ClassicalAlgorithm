package com.sire.algorithm.list;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/12
 * Author:Sire
 * Description:15.输出链表倒数第K个节点，例如 123456,倒是第三个节点
 * 是4
 * ==================================================
 */
public class ListK implements IAlgorithm {
    @Override
    public void go() {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        int k = listK(node, 7);
        System.out.println("===>"+k);
    }

    /**
     *
     * @param node
     * @param k
     * @return
     */
    private int listK(Node node,int k){
        if(node == null || k<=0){
            throw new RuntimeException("invalid input");
        }
        Node p1 = node;
        Node p2 = node;
        //p2先走K-1步
        for (int i = 0; i < k-1; ++i) {
          if(p2.next!=null){
              p2 = p2.next;
          }else {
              //链长不足
              throw new RuntimeException("invalid input");
          }
        }
        //p1 p2同时走
        while (p2.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.key;
    }
}
