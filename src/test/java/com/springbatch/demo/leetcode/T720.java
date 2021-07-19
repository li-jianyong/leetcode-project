package com.springbatch.demo.leetcode;

/** 返回最长单词，且字典序最小
 * @author: lijianyong
 * @since: 2021/7/11 9:59
 */
public class T720 {
    Trie root = new Trie();
    private int maxLength = 0;
    private String res = "";
    public String longestWord(String[] words) {
        // 遍历单词数组，逐个插入字典树
        for (String word : words) {
            insert(word);
        }
        getMaxLengthWord(root,0);
        return res;
    }
    public void insert(String word) {
        int n = word.length();
        Trie node = this.root;
        for (int i=0;i<n;i++) {
            char c = word.charAt(i);
            // 处理当前单词，如果包含该字母，则向下遍历结点。继续遍历单词下个字符；如果不包含则创建该字母的结点；
            if (node.children[c-'a'] == null) {
                node.children[c-'a'] = new Trie();
            }
            node = node.children[c-'a'];
        }
        // 遍历结束后，将该节点标识为结束；结点标识单词的值
        node.isEnd = true;
        node.word = word;
    }

    /** 每次的更新结果都赋值给递归内容之外保存
     * @param node
     * @param deep
     */
    public void getMaxLengthWord(Trie node,int deep) {
        if (deep > 0 && !node.isEnd) return;
        // maxLength用来迭代单词最大长度，如果深度大于最大长度，更新结果和长度
        if (deep > maxLength) {
            res = node.word;
            maxLength = deep;
        }
        // 遍历可能的26个结点，
        for (int i=0;i<26;i++) {
            if (node.children[i] != null) {
                // 递归向下判断
                getMaxLengthWord(node.children[i],deep+1);
            }
        }
    }
    class Trie{
        Trie[] children;
        boolean isEnd;
        String word;
        public Trie(){
            children = new Trie[26];
            isEnd = false;
        }
    }
}
