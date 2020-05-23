package com.sire.algorithm.dataAl.stack;

import com.sire.algorithm.IAlgorithm;

import java.util.Stack;

import static com.sire.algorithm.dataAl.stack.Calculate.OP.ADD;
import static com.sire.algorithm.dataAl.stack.Calculate.OP.DIV;
import static com.sire.algorithm.dataAl.stack.Calculate.OP.MINUS;
import static com.sire.algorithm.dataAl.stack.Calculate.OP.MULTI;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/04/10
 * Author:Sire
 * Description:栈用来做表达式求值和括号匹配
 * ==================================================
 */
public class Calculate implements IAlgorithm {

    @Override
    public void go() {
        int calculate = calculate("3+2x4-3");
        System.out.println("=====>"+calculate);
    }

    /**
     * 两个栈，一个栈用来装数据，另一个栈用来装操作符
     * 运算符栈，若栈顶运算法高于即将入栈的运算符则栈顶运算符出栈，取两个数进行计算，将结果压
     * 入操作数栈
     *
     * @param expression
     * @return
     */
    public int calculate(String expression) {
        char[] exp = expression.toCharArray();
        Stack<Integer> opNum = new Stack<>();
        Stack<Character> op = new Stack<>();
        int sum = 0;
        for (int i = 0; i < exp.length; i++) {
            if (isNumber(exp[i])) {
                opNum.push(exp[i] - '0');
            } else {
                while (!op.isEmpty()&&exp[i] < op.peek()){
                    cal(opNum,op);
                }
                op.push(exp[i]);
            }
        }
        while (!op.isEmpty()){
            sum=cal(opNum,op);
        }
        return sum;
    }

    private int cal(Stack<Integer> opNum, Stack<Character> op) {
        Character pop = op.pop();
        int data1 = opNum.pop();
        int data2 = opNum.pop();
        int re = ca(data2, data1, pop);
        opNum.push(re);
        return re;
    }

    private int ca(int data2, int data1, Character pop) {
        if(pop == ADD.op){
            return data2 + data1;
        }else if(pop == MINUS.op){
            return data2 - data1;

        }else if(pop == MULTI.op){
            return data2 * data1;
        }else if(pop == DIV.op){
            return data2 / data1;
        }
        return 0;
    }

    private boolean isNumber(char number) {
        return number != ADD.op && number != MINUS.op && number != MULTI.op && number != DIV.op;
    }

    enum OP {
        ADD('+'), MINUS('-'), MULTI('x'), DIV('÷');
        private char op;

        OP(char op) {
            this.op = op;
        }
    }
}
