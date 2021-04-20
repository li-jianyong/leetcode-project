package com.springbatch.demo.mianshi;

/**
 * 判断字符串里是否存在重复字符，最好不要使用多余的数据结构
 */
public class T0101 {
    public boolean isUnique(String astr) {
        if (astr.length() == 1 || astr.length() == 0) {
            return true;
        }
        boolean flag = true;
        for (int i=0,len=astr.length();i<len-1;i++) {
            if (astr.indexOf(astr.charAt(i)) != astr.lastIndexOf(astr.charAt(i))) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
