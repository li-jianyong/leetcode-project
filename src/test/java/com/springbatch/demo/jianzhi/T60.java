package com.springbatch.demo.jianzhi;

/**
 * n个骰子和为S的概率分布  P(k)= k出现的次数/总次数
 */
public class T60 {
    public double[] dicesProbability(int n) {
        double pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        for(int i=2;i<=n;i++){
            double mid[]=new double[5*i+1];
            for(int j=0;j<pre.length;j++)
                for(int x=0;x<6;x++)
                    mid[j+x]+=pre[j]*(1/6d);
            pre=mid;
        }
        return pre;
    }
}
