package com.springbatch.demo.leetcode;

import lombok.val;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName:T10
 * @author: Administrator
 * @Date: 2020/10/8 10 31
 **/
public class T14 {
    // 剑指offer 14
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
    // 增加快速幂的过程 答案取模
    public int cuttingRopeF(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        long rem = 1,x=3;
        int p = 1000000007;
        // 下面三种情况 可以采用快速幂的方式先对3^(a-1)次幂进行运算
        /* x^a%p
         * 当a为奇数  那么 该结果等于 [x * (x^2%p)^(a%2) ] %p
        *  当a为偶数  那么 该结果等于 [(x^2%p)^(a%2)] %p
        * */
        for(int i = n/3 -1;i>=0;i/=2) {
            if (i%2==1) rem = (rem * 3) % p;
            x = (x * x) % p;
        }
        // 遍历结束rem = 3^(a-1)
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }

}
