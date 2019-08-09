package com.sire.algorithm.integer;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/09
 * Author:Sire
 * Description:11.实现函数，求一个整数的n次方
 * ==================================================
 */
public class DoublePower implements IAlgorithm {
    @Override
    public void go() {
        double result2 = power2(2, 10);
        System.out.println("====>"+result2);
    }

    /**
     * 分治的思想
     * exp = 1 + (exp-1)
     * 时间复杂度O(n)
     * @param base
     * @param exp
     * @return
     */
    private double power1(int base,int exp){
        //异常检测
        if(base == 0){
            throw new RuntimeException("invalid input");
        }
        if(exp == 0){
            return 1;
        }
        //当做正数处理，求的结果后取倒数即可
        boolean isMinus = exp<0;
        if(isMinus){
            exp = -exp;
        }

        double result =  powerBase1(base,exp);

        if(isMinus){
            result = 1.0/result;
        }
        return result;
    }

    /**
     * 正面求解替代递归
     * 时间复杂度O(n)
     * @param base
     * @param exp
     * @return
     */
    private double power3(int base,int exp){
        //异常检测
        if(base == 0){
            throw new RuntimeException("invalid input");
        }
        if(exp == 0){
            return 1;
        }
        //当做正数处理，求的结果后取倒数即可
        boolean isMinus = exp<0;
        if(isMinus){
            exp = -exp;
        }

        double result =  powerBase3(base,exp);

        if(isMinus){
            result = 1.0/result;
        }
        return result;
    }

    private double powerBase3(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; ++i) {
          result*=base;
        }
        return result;
    }

    private int powerBase1(int base, int exp) {

        if(exp==1){
            return base;
        }
        return base*powerBase1(base,exp-1);
    }



    /**
     * 3^4   (3^2)^2
     * 分治思想+复用结果的方式
     * 时间复杂度O(logn)
     * @param base
     * @param exp
     * @return
     */
    private double power2(int base,int exp){
        //异常检测
        if(base == 0){
            throw new RuntimeException("invalid input");
        }
        if(exp == 0){
            return 1;
        }
        //当做正数处理，求的结果后取倒数即可
        boolean isMinus = exp<0;
        if(isMinus){
            exp = -exp;
        }

        double result =  powerBase2(base,exp);

        if(isMinus){
            result = 1.0/result;
        }
        return result;
    }

    /**
     * 3^5 = 3*(3^2)^2
     * 3^4 = (3^2)^2
     * 减少一半运算量
     * @param base
     * @param exp
     * @return
     */
    private int powerBase2(int base, int exp) {
        if(exp==1){
            return base;
        }
        if((exp & 1) == 1){
            return base*powerBase2(base*base,(exp-1)>>1);
        }else {
            return powerBase2(base*base,exp>>1);
        }
    }

}
