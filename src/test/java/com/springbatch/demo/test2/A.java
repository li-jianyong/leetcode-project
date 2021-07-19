package com.springbatch.demo.test2;

import lombok.val;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName:A
 * @author: Administrator
 * @Date: 2020/9/29 15 40
 **/
public class A {
    private static void perm(int[] list, int k, int m) {
        if( k == m) {
            for (int i = 0; i <=m; i++) {
                System.out.print(list[i]);
            }
            System.out.println();
        }
        else{
            for(int i = k; i <= m; i++) {
                swap(list,k,i);
                perm(list, k+1 , m);
                swap(list,k,i);
            }
        }
    }
    private static void swap(int[] list, int a, int b) {
        int temp;
        temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
    private static void swap1(char[] list, int a, int b) {
        char temp;
        temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
    public static void main(String args[]) {
        int[] list = new int[5];
        for(int i = 0; i < list.length; i++) {
            list[i] = i+1;
        }
        int[] arr = {1,2,3};
        perm(arr,0,2);
    }
    @Test
    public void t1() {
        int[] heights = {2,1,5,6,3};
        val i = largestRectangleArea(heights);
        System.out.println(i);
    }
    // 哨兵解法，两端放置0高度的元素
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) new_heights[i] = heights[i - 1];
        //System.out.println(Arrays.toString(new_heights));
        for (int i = 0; i < new_heights.length; i++) {
            //System.out.println(stack.toString());
            // 当前位置i的高度 比前面的高度大的时候 无法确定以当前位置i为高度的最大面积，那就直接将下标添加到栈里。
            // 如果比当前位置小那就进行计算面积
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                // 弹出栈顶下标
                int cur = stack.pop();
                // 先计算宽度，当前位置i和栈顶元素的下标 -1 即宽度 乘以最小高度
                res = Math.max(res, (i - stack.peek() - 1) * new_heights[cur]);
            }
            // 首次进来，将下标入栈
            stack.push(i);
        }
        return res;
    }

    // 复杂度o(n^2)
    public int largestRectanleArea(int[] heights) {
        int len = heights.length;
        if (len==0) return  0;
        int res=0;
        for(int i=0;i<len;i++) {
            int left = i;
            int currHeight = heights[i];
            while(left>0 && heights[left-1]>=currHeight) {
                left--;
            }
            int right = i;
            while(right<len-1 && heights[right+1] >= currHeight) {
                right++;
            }
            int width = right-left+1;
            // 结果等于 长宽面积 和res
            res = Math.max(res,width*currHeight);
        }
        return res;
    }
    // 添加哨兵后的单调栈 o(n);
    public int largestRectanleArea1(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res=0;
        int[] newHeights = new int[len+2];
        newHeights[0]=0;
        // heights数组从0开始 复制元素到newHeights数组从1位置开始， 复制len长度
        System.arraycopy(heights,0,newHeights,1,len);
        newHeights[len+1] = 0;
        len+=2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先加入哨兵，避免循环判断
        stack.addLast(0);
        for(int i=1;i<len;i++) {
            while(heights[i]<heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() -1;
                res = Math.max(res,curHeight*curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }
    @Test
    public void t2() {
        String a = "abb";
        String b = "eidbabboo";
        checkInclusion(a,b);
    }

    public boolean checkInclusion(String s1, String s2) {
        // need存放需要包含的字符
        Map<Character,Integer> need = new HashMap<>();
        // work里包含所有的字符
        Map<Character,Integer> work = new HashMap<>();
        for(char ch:s1.toCharArray()){
            // 把出现的次数统计进去，
            need.put(ch,need.getOrDefault(ch, 0).intValue() + 1);
        }
        // 双指针遍历
        int left = 0, right = 0;
        // count用来维护匹配成功字符个数  匹配成功意味着重复字符必须达到数量 才算成功
        int count = 0;
        while(right<s2.length()){
            char right_char = s2.charAt(right);
            right++;
            if(need.containsKey(right_char)){
                work.put(right_char, work.getOrDefault(right_char,0).intValue() + 1);
                if(work.get(right_char).intValue() == need.get(right_char).intValue()){
                    // 记录work里有效字符数 即包含需要匹配的字符
                    count++;
                }
            }
            // s1长度为2 那么窗口大小至少要是2 如果变大了，那么就要缩小窗口
            while(right - left >= s1.length()){
                // 有效字符数和需要匹配的字符数量完全相等，那么说明已经达到了最小匹配了
                if(count == need.size()){
                    return true;
                }
                char left_char = s2.charAt(left);
                left++;
                if(need.containsKey(left_char)){

                    if(work.get(left_char) == need.get(left_char)){
                        count--;
                    }
                    work.put(left_char,work.get(left_char).intValue()-1);
                }
            }
        }
        System.out.println(count);
        return false;
    }
    @Test
    public void t(){
        String s = "abc";
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();
        dfs(res,chars,chars.length,0);
        System.out.println(Arrays.toString(res.toArray()));
    }
    private void dfs(List res,char[] chars,int len,int x) {
        if (x == len-1) {
            res.add(String.valueOf(chars));
            return;
        }
        // set 保证元素去重
        HashSet<Character> set = new HashSet<>();
        for (int i=x;i<len;i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap1(chars,i,x);
            dfs(res,chars,len,x+1);
            swap1(chars,i,x);
        }
    }
    @Test
    public void t3(){
        int[] arr = {3,2,1,5,6,4};
        int k = 2;

        System.out.println(findKthLargest(arr,k));
    }
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        // 第一大len-1 第k大即len-k
        return nums[len-k];
    }
    // 优先级队列实现
    // 1，维护一个大根堆，将所有元素加入，那么再弹出k-1个元素 那么剩下的大根堆堆顶就是第K大的数
    // 2，维护一个小根堆，小根堆里维持K个元素，那么尝试堆顶元素就是第K大，但是不确定没加入堆里元素大小，继续将后续元素往里加入，如果大于堆顶，
    //    就把当前堆顶元素弹出，当前遍历加入，继续维护小根堆，这样遍历结束，小根堆结束。小根堆堆顶也就是第K大元素
    public int findKthLargest1(int[] nums,int k) {
        int len = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for (int i=0;i<len;i++) {
            maxHeap.add(nums[i]);
        }
        for (int i=0;i<k-1;i++){
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    /** 分区策略 以left为参照 左侧元素小于left位置的值，右侧元素大于left位置的值
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums,int left,int right) {
        int pivot = nums[left];
        int j = left;
        // 从left+1位置开始向后搜索
        for (int i=left+1;i<=right;i++) {
            // 如果该位置大于标准值
            if (nums[i] < pivot) {
                j++;
                swap(nums,j,i);
            }
        }
        swap(nums,j,left);
        return j;
    }
}
