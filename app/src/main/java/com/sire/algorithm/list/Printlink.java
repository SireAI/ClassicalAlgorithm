package com.sire.algorithm.list;

import com.sire.algorithm.IAlgorithm;

import java.util.Stack;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/08
 * Author:Sire
 * Description:5.从尾到头打印链表
 * ==================================================
 */
public class Printlink implements IAlgorithm {

    @Override
    public void go() {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next= new Node(3);
        printNodeFromTail(node);
    }

    /**
     * 遍历顺序是从头部到尾部，打印顺序是从尾部到头部
     * 符合先进后出原则，使用栈来实现
     * @param node
     */
    public void printNodeFromTail(Node node){
        Node p = node;
        Stack<Node> stack = new Stack<>();
        while (p!=null){
            stack.push(p);
            p = p.next;
        }
        while (!stack.isEmpty()){
            Node e = stack.pop();
         System.out.println("====>"+e.key);
        }
    }
}
