package com.springbatch.demo.jianzhi;

public class T58_1 {
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length()-1,i=j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            // 找到i的位置
            while (i>=0 && s.charAt(i) != ' ') i--;
            // 单词拼接到res里，加上空格
            res.append(s.substring(i+1,j+1) + " ");
            while (i >=0 && s.charAt(i) == ' ') i--;
            j=i;
        }
        return res.toString().trim();
    }

}
