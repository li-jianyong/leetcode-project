package com.springbatch.demo.leetcode;

/**
 * 扁平化迭代器
 */
public class T341 {

//    class NestedIterator implements Iterator<Integer> {
//        Deque<Integer> queue = new ArrayDeque<>();
//        public NestedIterator(List<NestedIterator> nestedList) {
//            dfs(nestedList);
//        }
//        @Override
//        public boolean hasNext() {
//            return !queue.isEmpty();
//        }

//        @Override
//        public Integer next() {
//            return hasNext() ? queue.pollFirst() : -1;
//        }
//        void dfs(List<NestedIterator> list) {
//            for (NestedIterator item : list) {
//                if (item.isInteger()) {
//                    queue.addLast(item.getInteger());
//                } else {
//                    dfs(item.getList());
//                }
//            }
//        }
//    }
}
