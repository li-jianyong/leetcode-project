package com.springbatch.demo.leetcode;

/**
 * Trie 字典树，通过二维数组来存放所有的单词
 */
public class T208 {
    class Trie {
        int N = 100009; // 直接设置为十万级
        int[][] trie;
        int[] count;
        int index;

        public Trie() {
            trie = new int[N][26];
            count = new int[N];
            index = 0;
        }

        public void insert(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                /** 如果第i个字符不存在则为0，将其位置的值改为index+1的值
                 * */
                if (trie[p][u] == 0) trie[p][u] = ++index;
                /** p的值更新为当前单元格的值
                 * */
                p = trie[p][u];
            }
            count[p]++;
        }

        public boolean search(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trie[p][u] == 0) return false;
                p = trie[p][u];
            }
            return count[p] != 0;
        }

        public boolean startsWith(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (trie[p][u] == 0) return false;
                p = trie[p][u];
            }
            return true;
        }
    }
}
