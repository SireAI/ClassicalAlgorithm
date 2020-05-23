package com.sire.algorithm.list;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/13
 * Author:Sire
 * Description:17.合并两个递增排序的链表
 * ==================================================
 */
public class MergeList implements IAlgorithm{
    @Override
    public void go() {
        Node node = new Node(1);
        node.next = new Node(3);
        node.next.next = new Node(5);
        node.next.next.next = new Node(7);
        node.next.next.next.next = new Node(9);
        Node node1 = new Node(2);
        node1.next = new Node(4);
        node1.next.next = new Node(6);
        node1.next.next.next = new Node(8);
        Node node2 = mergerList1(node, node1);
        System.out.println("====>"+node2);
    }

    /**
     * 启用以个新的头结点遍历两个链表来合并
     * @param node1
     * @param node2
     * @return
     */
    private Node mergerList(Node node1,Node node2){
        if(node1 == null || node2 == null){
            throw new RuntimeException("invalid input");
        }
       Node newHeader = null;
        Node tail = null;
       while (node1!=null && node2!=null){
           //获取较小节点，并遍历
           Node smallNode = null;
           if(node1.key<node2.key){
               smallNode = node1;
               node1 = node1.next;
           }else {
               smallNode = node2;
               node2 = node2.next;
           }
           //组装新链表
           if(newHeader == null){
               newHeader = tail = smallNode;
           }else {
               tail.next = smallNode;
               tail = tail.next;
           }
       }
       while (node1!=null){
           tail.next = node1;
           tail = tail.next;
           node1 = node1.next;
       }
        while (node2!=null){
            tail.next = node2;
            tail = tail.next;
            node2 = node2.next;
        }
       return newHeader;
    }

    /**
     * 递归的思路来解决
     * 比分治的思想，去任意两个指针所指的节点来进行比较
     * 产生一个两个节点的新链
     * @param node1
     * @param node2
     * @return
     */
    private Node mergerList1(Node node1,Node node2){
       if(node1 == null){
           return node2;
       }else if(node2 == null){
           return node1;
       }
       Node p = null;
       if(node1.key<node2.key){
          p = node1;
          p.next = mergerList1(node1.next,node2);
       }else {
          p = node2;
           p.next = mergerList1(node1,node2.next);
       }
       return p;
    }
}
