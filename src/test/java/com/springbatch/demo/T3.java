package com.springbatch.demo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/*
* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
示例 1：
输入：s = \()\
输出：true
示例 2：
输入：s = \()[]{}\
输出：true
示例 3
输入：s = \(]\
输出：false
示例 4：
输入：s = \([)]\
输出：false
示例 5：
输入：s = \{[]}\
输出：true
提示：
1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
class Solution {
    public boolean isValid(String s) {
    }
}
* */
public class T3 {
    public boolean isValid(String s) {
        // 存放映射关系
        Map<Character,Character> memo = new HashMap<>();
        memo.put('(',')');
        memo.put('[',']');
        memo.put('{','}');
        Stack<Character> stack = new Stack<>();
        for (Character a : s.toCharArray()) {
            if (memo.containsKey(a)) stack.add(a);
            else if (memo.get(stack.pop()) != a) return false;
        }
        return stack.size() == 0;
    }
    @Test
    public void testValid() {
        boolean valid1 = isValid("()");
        boolean valid2 = isValid("()[]{}");
        boolean valid3 = isValid("(]");
        boolean valid4 = isValid("([)]");
        boolean valid5 = isValid("{[]}");
        System.out.println(valid1);
        System.out.println(valid2);
        System.out.println(valid3);
        System.out.println(valid4);
        System.out.println(valid5);
    }
}
