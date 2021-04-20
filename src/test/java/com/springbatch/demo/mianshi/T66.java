package com.springbatch.demo.mianshi;

/**
 * @ClassName:T66
 * @author: Administrator
 * @Date: 2020/10/22 20 54
 **/
public class T66 {
    public double[] twoSum(int n) {
        double[] pre = {1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        for (int i=2;i<=n;i++) {
            double tmp[] = new double[5*i+1];
            for (int j=0;j<pre.length;j++) {
                for (int x=0;x<6;x++) {
                    tmp[j+x] += pre[j]/6;
                }
            }
            pre = tmp;
        }
        return pre;
    }
}
