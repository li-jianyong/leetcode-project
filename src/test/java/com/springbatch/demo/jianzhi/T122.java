package com.springbatch.demo.jianzhi;

/** 股票的最佳时机
 * @author: jianyong.li
 * @since: 2021/6/13 9:51
 */
public class T122 {
    /** 动态规划算法，只保留前一个状态
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return -1;
        int length = prices.length;
        // 持有股票的收益
        int hold = -prices[0];
        // 不持有股票的收益
        int noHold = 0;
        for (int i=1;i<length;i++) {
            noHold = Math.max(noHold,hold + prices[i]);
            hold = Math.max(hold,noHold - prices[i]);
        }
        return noHold;
    }

    /** 贪心算法:对问题求解时，总是做出在当前看来是最好的选择，得到的是局部最优解
     * 本题适用贪心算法是因为，从局部来看，只要是有上涨部分就可以纳入到最终结果
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int total = 0,index=0,length = prices.length;
        while(index < length) {
            // 股票一直下跌，就一直往后走
            while(index < length-1 && prices[index] >= prices[index+1]) index++;
            // 走出上面的循环，来到下跌位置最小值
            int min = prices[index];
            // 后续，如果一直上涨，来到最大值
            while(index < length-1 && prices[index] <= prices[index+1]) index++;
            total += prices[index++] - min;
        }
        return total;
    }

    /** 贪心算法进阶，只要后一个元素减去前一个元素是正的就加起来；
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int total = 0;
        for(int i=0;i<prices.length;i++) {
            total += Math.max(prices[i+1] - prices[i],0);
        }
        return total;
    }
}