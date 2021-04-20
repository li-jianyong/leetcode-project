package com.springbatch.demo.mianshi;


import java.util.HashMap;
import java.util.Map;

public class T0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for(char a : s1.toCharArray()) {

            map1.put(a,map1.getOrDefault(a,0)+1);
        }
        for(char a : s2.toCharArray()) {
            map2.put(a,map2.getOrDefault(a,0)+1);
        }
        if(map1.size()!=map2.size()) return false;
        for(Map.Entry entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey())) return false;
            if (entry.getValue() != map2.get(entry.getKey())) return false;
        }
        return true;
    }
}
