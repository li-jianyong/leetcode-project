package com.springbatch.demo.jianzhi;

/**
 * 判断字符串是否为合法数字 A.BEC A.BeC
 */
public class T20 {
    private int index = 0;
    private boolean scanUnsignedInteger(String str) {
        int before = index;
        while(str.charAt(index) >= '0' && str.charAt(index)<='9') {
            index++;
        }
        // 如果没扫到数字，返回false,如果有数字，index移动则返回了文本
        return index > before;
    }

    /** 扫描是否包含正负号，如果有正负号那就索引位置向后移动，然后
     * @param str
     * @return
     */
    private boolean scanInteger(String str) {
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            index++;
        }
        // 扫描完正负号之后，后面跟上数字
        return scanUnsignedInteger(str);
    }

    /** 判断主要逻辑
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        // 添加结尾标识符号
        s = s + '|';
        // 如果头部是空格，直接往后移动
        while(s.charAt(index) == ' ') {
            index++;
        }
        // 继续扫描首先是否为正负号，是否包含整数部分
        boolean numeric = scanInteger(s);
        if (s.charAt(index) == '.') {
            index++;
            // 小数点前后只要有一处有数字就行
            numeric = scanUnsignedInteger(s) || numeric;
        }
        if ((s.charAt(index) == 'E' || s.charAt(index) == 'e')) {
            index++;
            // e或者E的两边都要有数字，所以用&&
            numeric =numeric && scanInteger(s);
        }
        while(s.charAt(index) == ' ') {
            index++;
        }
        return numeric && s.charAt(index) == '|';
    }
}
