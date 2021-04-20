package com.springbatch.demo.mianshi;

public class T0105 {
    public boolean oneEditAway(String first,String second) {
        if (first == null || second == null) return false;
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1-len2) > 1) return false;
        if (len2 > len1) return oneEditAway(second,first);
        // 保持第一个比第二个长
        for (int i=0;i<len2;i++) {
            if (first.charAt(i) != second.charAt(i)) {
                // 长度相同比较后面的字符是否一样，不相同，则比较包含当前字符在内的是否相同
                return first.substring(i+1).equals(second.substring(len1 == len2 ? i+1:i));
            }
        }
        return true;
    }
}
