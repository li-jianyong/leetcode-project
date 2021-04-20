package com.springbatch.demo.jianzhi;

/** 剪绳子 快速幂
 * @ClassName:T14
 * @author: Administrator
 * @Date: 2020/10/20 21 37
 **/
public class T14 {
        public int cuutingRope(int n) {
            if (n<=3) return n-1;
            int b = n%3,p=1000000007;
            long rem = 1,x=3;
            // 次数是奇数，结果rem乘上去一个 使之变为偶数，偶数的话，直接将基础x二倍，那样可以使得次数缩小一半
            for (int a = n/3-1;a>0;a/=2) {
                // 快速幂，如果奇数，那就rem乘x再取余
                if (a % 2 == 1) rem = (rem * x) % p;
                x = (x * x) % p;
            }
            if (b == 0) return (int)(rem * 3 % p);
            if (b == 1) return (int)(rem * 4 % p);
            return (int)(rem * 6 % p);
        }
}
