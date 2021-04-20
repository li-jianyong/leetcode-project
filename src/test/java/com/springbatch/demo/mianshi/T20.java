package com.springbatch.demo.mianshi;

import java.util.HashMap;
import java.util.Map;

/** 面试题20. 表示数值的字符串
 * @ClassName:T20
 * @author: Administrator
 * @Date: 2020/10/26 21 43
 **/
public class T20 {
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap(){{put(' ',0);put('s',1);put('d',2);put('.',4);}},
                new HashMap() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap() {{ put('d', 3); }},                                        // 4.
                new HashMap() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap() {{ put('d', 7); }},                                        // 6.
                new HashMap() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap() {{ put(' ', 8); }}
        };
        int p =0;
        char t;
        for (char c :s.toCharArray()) {
            if (c >='0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else if (c == 'e' || c == 'E') t = 'e';
            else t = '?';
            if (!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p==2||p==3||p==7||p==8;
    }
    private int index = 0;//全局索引
    private boolean scanUnsignedInteger(String str) {
        //是否包含无符号数
        int before = index;
        while(str.charAt(index) >= '0' && str.charAt(index) <= '9')
            index++;
        return index > before;
    }
    private boolean scanInteger(String str) {
        //是否包含有符号数
        if(str.charAt(index) == '+' || str.charAt(index) == '-')
            index++;
        return scanUnsignedInteger(str);
    }
    public boolean isNumber1(String s) {
        //空字符串
        if(s == null || s.length() == 0)
            return false;
        //添加结束标志
        s = s + '|';
        //跳过首部的空格
        while(s.charAt(index) == ' ')
            index++;
        boolean numeric = scanInteger(s); //是否包含整数部分,如果包含整数那么小数点后面可以没有整数
        if(s.charAt(index) == '.') {
            index++;
            //有小数点，处理小数部分
            //小数点两边只要有一边有数字就可以，所以用||，
            //注意scanUnsignedInteger要在前面，否则不会进
            numeric = scanUnsignedInteger(s) || numeric;
        }
        if((s.charAt(index) == 'E' || s.charAt(index) == 'e')) {
            index++;
            //指数部分
            //e或E的两边都要有数字，所以用&&
            numeric = numeric && scanInteger(s);
        }
        //跳过尾部空格
        while(s.charAt(index) == ' ')
            index++;
        return numeric && s.charAt(index) == '|' ;
    }

}
