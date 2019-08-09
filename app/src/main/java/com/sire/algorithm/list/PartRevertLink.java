package com.sire.algorithm.list;

import com.sire.algorithm.IAlgorithm;

import java.util.Stack;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/08
 * Author:Sire
 * Description:*byte给定一个链表，实现一个调整单链表的函数，使得每k个节点
 * 为一组进行逆序，并且从链表的尾部开始组起，头部剩余节点数量不够一组的不需要逆序
 * 1->2->3->4->5->6->7->8->null
 * 6->7->8,3->4->5,1->2,三组
 * 1->2-5->4->3->8->7->6->null
 * 87654321
 * 67834521
 * 12543876
 * 不能使用栈或者队列作为辅助
 * ==================================================
 */
public class PartRevertLink implements IAlgorithm {
    @Override
    public void go() {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        Node end = partRevert2(node, 3);
//        Node end = revertNodeStack(node);
        System.out.println("====>"+end);
    }

    /***
     * 1.翻转链表
     * 2.遍历链表，每三个做一次取反操作
     * 3.在翻转一次链表
     *
     * 链表的指针遍历
     * 链表的结构改变,next复制操作
     * 普通正向遍历的解决方案
     * @param node
     * @return
     */
    private Node partRevert(Node node,int k){
        if(node == null){
            return null;
        }
        //遍历操作计算个数，获得余数
        Node p = node;
        int size = 0;
        while (p!=null){
            size++;
            p = p.next;
        }
        int left = size%k;

        //再次遍历，从余数开始每k个元素进行反转
        //小于K则直接返回
        if(size<k){
            return node;
        }
        int index = 0;
        p = node;
        Node pre = null;
        while (p!=null){
            index++;
            if(index>left){
               //反转K个节点，并与之前的链接
              p = revertPart(p,k);
              pre.next = p;
              //跳过反转的节点
              int count = k;
              while (count>0){
                  count--;
                  pre = p;
                  p = p.next;
              }
            }else {
                //余数不做处理
                pre = p;
                p = p.next;
            }
        }

        return node;
    }
    private Node revertPart(Node node,int k){
        int index = 0;
        Node temp = null;
        Node newHead = null;
        Node tail = null;
        //反转K个
        while (node!=null && index<k){
            index++;
            if(newHead == null){
                //记录尾部，便于与K+节点链接
                tail = node;
                newHead = tail;
                node = node.next;
            }else {
                temp = node.next;
                node.next = newHead;
                newHead = node;
                node = temp;
            }
        }
        //连接
        tail.next = node;
        return newHead;
    }

    /**
     * @param node
     * @return
     */
    private Node revertNode(Node node){
        //终止条件
        if(node == null || node.next == null){
            return node;
        }
        Node result = revertNode(node.next);
        Node p = result;
        while (p.next!=null){
            p = p.next;
        }
        p.next = node;
        node.next = null;
        return result;
    }

    /**
     * 栈的实现方式
     * @param node
     * @return
     */
    private Node revertNodeStack(Node node){
        Stack<Node> stack = new Stack<>();
        Node p = node;
        while (p!=null){
            stack.push(p);
            p  = p.next;
        }
        Node header = null;
        Node tail = null;
        while (!stack.isEmpty()){
            if(header == null){
                tail =  stack.pop();
                header = tail;
            }else {
                tail.next = stack.pop();
                tail = tail.next;
            }
        }
        return header;
    }

    /**
     * 分治思想解决
     * @param node
     * @param k
     * @return
     */
    private Node partRevert2(Node node,int k){
        //用例检查
        if(k == 0 || k == 1 || node == null){
            throw new RuntimeException("invalid input");
        }
        Node head = revertNode(node);
        head = revertNodeInKGroup(head,k);
        head = revertNode(head);
        return head;
    }

    private Node revertNodeInKGroup(Node head, int k) {
        if(head.next == null ){
            return head;
        }
        //获取k长度的链
        Node leftTail = head;
        for (int i = 1; i < k && leftTail!=null; ++i) {
          leftTail = leftTail.next;
        }
        //不满足K长度则直接返回
        if(leftTail == null){
            return head;
        }
        //分治，问题分成两部分：K个需要反转的节点+剩余的需要做分组反转的节点
        Node rightPart = leftTail.next;
        leftTail.next = null;
        head = revertNode(head);
        //衔接
        leftTail = head;
        while (leftTail.next!=null){
            leftTail = leftTail.next;
        }
        leftTail.next = revertNodeInKGroup(rightPart,k);

        return head;
    }


}
