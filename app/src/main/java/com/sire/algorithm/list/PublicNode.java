package com.sire.algorithm.list;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/05
 * Author:Sire
 * Description:输入两个链表，找出它们的公共节点
 * ==================================================
 */
public class PublicNode implements IAlgorithm {
    @Override
    public void go() {
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(4);
        node3.next = node4;
        Node node5 = new Node(5);
        node4.next = node5;
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node6.next = node7;
        node7.next = node3;
        int i = find(node1, node6);
        System.out.println("=====>"+i);
    }

    /**
     * 1.双层遍历即可解决，时间复杂度O(N^2)
     * 2.使用两个栈辅助，反向遍历方式，直到不相同的两个节点，时间复杂度O(N)，空间复杂度 O(N)
     * 3.确定两个栈的长度，较长的链表先走，然后二者同步遍历，相同的节点及时时间复杂度O(N)
     */
    public int find(Node node1, Node node2) {
        int length1 = 1;
        int length2 = 1;
        Node temp1 = node1;
        Node temp2 = node2;
        while (temp1.next != null) {
            temp1 = temp1.next;
            length1++;
        }
        while (temp2.next != null) {
            temp2 = temp2.next;
            length2++;
        }
        temp1 = node1;
        temp2 = node2;
        if(length1 < length2){
            int k = length2-length1;
            while (k>0){
                temp2 = temp2.next;
                k--;
            }
        }else {
            int k = length1-length2;
            while (k>0){
                temp1 = temp1.next;
                k--;
            }
        }

        while (temp1.key != temp2.key){
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        return temp1.key;


    }
}
