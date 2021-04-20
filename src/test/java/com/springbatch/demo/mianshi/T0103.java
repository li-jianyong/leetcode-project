package com.springbatch.demo.mianshi;

public class T0103 {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        char[] arr = S.toCharArray();
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
    // 方法2
    public String replaceSpaces2(String S, int length) {
        return S.substring(0, length).replace(" ", "%20");
    }
    // 方法3
    public String replaceSpaces3(String S, int length) {
        char[] ch = new char[length * 3];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                ch[index++] = '%';
                ch[index++] = '2';
                ch[index++] = '0';
            } else {
                ch[index] = c;
                index++;
            }
        }
        return new String(ch, 0, index);
    }
}
