package com.springbatch.demo.mianshi;

/**
 * @ClassName:T58_1
 * @author: Administrator
 * @Date: 2020/10/21 17 59
 **/
public class T58_1 {
    public String reverseWords(String s ){
        s = s.trim();
        int j= s.length()-1,i=j;
        StringBuilder res = new StringBuilder();
        while(i>=0) {
            // 如果不为空格，向前
            while(i>=0 && s.charAt(i) != ' ') i--;
            res.append(s.substring(i+1,j+1) + " ");
            while(i>=0 && s.charAt(i) == ' ') i--;
            // 直接指向下个单词的尾部字符
            j = i;
        }
        return res.toString().trim();
    }
}
