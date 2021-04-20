package com.springbatch.demo.mianshi;

public class T0106 {
    public String compressString(String S) {
        int N = S.length();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<N) {
            int j=i;
            while(j<N&& S.charAt(j) == S.charAt(i)) {
                j++;
            }
            sb.append(S.charAt(i));
            sb.append(j-i);
            i=j;
        }
        String res = sb.toString();
        if (res.length() < S.length()) {
            return res;
        } else {
            return S;
        }
    }
}
