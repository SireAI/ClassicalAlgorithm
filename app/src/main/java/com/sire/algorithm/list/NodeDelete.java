package com.sire.algorithm.list;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/12
 * Author:Sire
 * Description:给定一个单向链表的头指针和结点指针定义一个函数在O(1)时间删除该结点
 *12345
 * ==================================================
 */
public class NodeDelete implements IAlgorithm{
    @Override
    public void go() {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next= new Node(4);
        node1.next.next.next.next = new Node(5);
        Node node = deleteNode(node1, node1.next.next.next.next);
        System.out.println("====>"+node);
    }

    /**
     * 1.若将要删除结点的下个结点不为空，则使用覆盖值+链接的方式
     * 2.若头部与删除的节点相同，则直接置空
     * 3.若将要删除的节点处于尾部，则遍历删除尾部节点
     * @param header
     * @param delete
     * @return
     */
    private Node deleteNode(Node header,Node delete){
        if(header == null || delete == null){
            throw new RuntimeException("invalid input");
        }
        if(delete.next!=null){
            delete.key = delete.next.key;
            delete.next = delete.next.next;
        }else if(header == delete){
            header = null;
        }else {
            Node p = header;
            while (p.next!=delete){
                p = p.next;
            }
            p.next = null;
        }
        return header;
    }
}
