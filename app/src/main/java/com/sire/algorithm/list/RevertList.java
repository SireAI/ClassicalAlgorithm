package com.sire.algorithm.list;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/13
 * Author:Sire
 * Description: 15.反转一个链表
 * ==================================================
 */
public class RevertList implements IAlgorithm{
    @Override
    public void go() {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next= new Node(4);
        node1.next.next.next.next = new Node(5);
        Node node = revertList1(node1);
        System.out.println("====>"+node);
    }

    /**
     * 正向遍历，使用两个指针
     * @param node
     * @return
     */
    private Node revertList(Node node){
        if(node == null){
            throw new RuntimeException("invalid input");
        }
        Node temp = null;
        Node newHeader = null;
        while (node!=null){
            if(newHeader == null){
                newHeader = node;
                node = node.next;
                //位于尾部的节点的下一个节点置空
                newHeader.next = null;
            }else {
                temp = node.next;
                node.next = newHeader;
                newHeader = node;
                node = temp;
            }
        }
        return newHeader;
    }

    private Node revertList1(Node node){
        if(node == null){
            throw new RuntimeException("invalid input");
        }
        Node newHeader = null;
        Node pre = null;
        Node p = node;
        while (p!=null){
            Node next = p.next;
            if (next == null){
                //最后一个节点
                newHeader = p;
            }
            //双指针替换
            p.next = pre;
            pre = p;
            p = next;
        }
        return newHeader;
    }
}
