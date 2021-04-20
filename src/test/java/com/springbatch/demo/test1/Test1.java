package com.springbatch.demo.test1;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class Test1 {

    public void t1() {

    }
    // 剪绳子，按照数学求导运算，绳子最大长度控制在3，能够获得最大的乘积收益；
    // 题目描述： 将绳子长度n剪成m段，且长度为正整数，然后使得乘积最大满足的条件.
    public int cuttingRope(int n) {
        if (n<3) return n-1;
        int a = n/3,b=n%3;
        if (b ==0) return (int)Math.pow(3,a);
        if (b==1) return (int)Math.pow(3,a-1)*4;
        return (int)Math.pow(3,a) *2;
    }
    // 快速幂 x^n
    private long quickPow(int x,long n) {
        long res = 1;
        long tt = x;
        while (n!=0){
            // 如果n为奇数，抽出其中一个x
            if ((n&1) == 1) {
                res *= tt;
                res %= 1000000007;
            }
            // 如果是偶数，正常处理x的值。
            tt *= tt;
            tt %= 1000000007;
            n /=2;
        }
        return res;
    }

    // 大数取余的快速幂做法
    public int cuttingRope1(int n) {
        if (n <= 3) return n-1;
        long res = 1L;
        int p = (int)1e9+7;
        // 贪心算法，优先切3其次切2
        while(n>4) {
            res = res*3%p;
            n-=3;
        }
        return (int)(res*n%p);
    }
    // 剑指offer 青蛙跳台阶取快速幂的办法
    /*
    * 青蛙可以一次跳一级台阶也可以是两阶台阶，跳到第n层共有多少种跳法
    * 由于最后一步只有两个选择，跳一级或跳两级，那么f(n)=f(n-1)+f(n-2)那么多种办法
    *
    * */
    public int numWays(int n ) {
        if (n==0||n==1) return 1;
        int pre =1 ,cur=2;
        int p = (int)1e9+7;
        for (int i =3;i<=n;i++) {
            int tmp =(pre+cur)%p;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
    // 堆排序
    public static void adjustHeap(int[] arr,int i,int length) {

    }
    @Test
    public void test2(){
        int m = 2,n=3,k=0;
        System.out.println(movingCount(2,3,0));
    }
    public int movingCount(int m, int n, int k) {
        // 用来记录已经访问过的位置
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue= new LinkedList<int[]>();
        // int数组，分别表示坐标（i，j）以及i，j位置的数位和
        queue.add(new int[] { 0, 0, 0, 0 });
        while(queue.size() > 0) {
            int[] x = queue.poll();
            // si表示i位置的数位和，sj表示j位置的数位和
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if(i >= m || j >= n || k < si + sj || visited[i][j]) continue;
            visited[i][j] = true;
            res ++;
            // 添加向下i+1的个数 深度优先不断向下搜索，再遇到10的位置，数位和发生突变。并计算i+1的数位和
            queue.add(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
            // 添加向右的个数
            queue.add(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
        }
        return res;
    }
    @Test
    public void replaceString() {

        System.out.println("We are happy".replaceAll(" ","%20"));
    }
    @Test
    public void reversePrint() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        int count= 0;
        int[] res = new int[stack.size()];
        int i =0;
        while(!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        System.out.println(Arrays.toString(res));
    }
    // 利用反射，验证类型擦除
    @Test
    public void t2() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(12);
//        报错，类型不对
//        list.add("12");
        list.getClass().getMethod("add",Object.class).invoke(list,"as");
        for (int i = 0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }

    /*
    * 计算一个数字的全排列
    * */
    @Test
    public void t7() {

    }
    // 判断N的数字组合是否可以拆解重组成2的幂
    public boolean reorderedPowerOf2(int N) {
        // Build eg. N = 128 -> A = [1, 2, 8]
        String S = Integer.toString(N);
        int[] A = new int[S.length()];
        for (int i = 0; i < S.length(); ++i)
            A[i] = S.charAt(i) - '0';
        // 将数组拆成数组 装入数组
        return permutations(A, 0);
    }

    public boolean isPowerOfTwo(int[] A) {
        if (A[0] == 0) return false;  // no leading zero

        // Build eg. A = [1, 2, 8] -> N = 128
        int N = 0;
        for (int x: A)
            N = 10 * N + x;

        // 2的幂就可以一直除2，直到除不了那就结束，判断是不是1，是1就代表是2的幂，不是就代表不是2的幂
        while (N > 0 && ((N & 1) == 0))
            N >>= 1;

        // Check that there are no other factors besides 2
        return N == 1;
    }

    //
    public boolean permutations(int[] A, int start) {
        if (start == A.length)
            return isPowerOfTwo(A);

        // Choose some index i from [start, A.length - 1]
        // to be placed into position A[start].
        for (int i = start; i < A.length; ++i) {
            // 位置i和start位置进行更换
            swap(A, start, i);

            // 判断从后一个位置开始的元素是否包含2给定特征的结果
            if (permutations(A, start + 1))
                return true;

            // 将两个位置的序列更换回来
            swap(A, start, i);
        }

        return false;
    }

    private void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
    @Test
    public void t3(){
    }
    /*
    * 全排列算法实现
    * */
    ArrayList<String> res = new ArrayList<>();
    private void perm(int[] list,int k,int m) {
        if (k==m) {
            StringBuilder temp = new StringBuilder();
            for (int i =0 ;i<=m;i++) {
                temp.append(list[i]);
            }
            res.add(temp.toString());
        } else {
            for (int i = k;i<=m;i++) {
                swap(list,k,i);
                perm(list,k+1,m);
                swap(list,k,i);
            }
        }
    }
    @Test
    public void t4() {
        int[] test = {1,2,3};
        perm(test,0,2);
        res.forEach(System.out::println);
    }
    @Test
    public void t5() {
        int a = 3,b=4,c=5;
        System.out.println((1==2)|(2==2));
        System.out.println(1|2);
        System.out.println((1==2)&((c=a+b)==5));
        System.out.println(c);
        System.out.println("===========");
        int a1 = 3,b1=4,c1=5;
        System.out.println((1==2)||(2==2));
        System.out.println(1|2);
        System.out.println((1==2)&&((c1=a1+b1)==5));
        System.out.println(c1);
    }

    public boolean isPowerOfTwo(int N) {
        int[] A = count(N);
        // int类型所能表示的数据范围只能到2^31次方，左移动31次即可
        for (int i = 0 ;i<31;i++) {
            // 如果数组A和 将1左移后的数组类型匹配，那么数字个数都一样，直接返回true
            if (Arrays.equals(A,count(1<<i))) {
                return true;
            }
        }
        return false;
    }
    public int[] count(int N) {
        int[] ans = new int[10];
        while(N>0) {
            ans[N%10]++;
            N /= 10;
        }
        return ans;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // flag标识是否向前进1
        int flag = 0;
        ListNode l3 = null,tail=null;
        int i=0,j=0;
        while(l1 != null && l2 != null) {
            int sum = l1.val+l2.val + flag;
            // 每次计算sum的值之后，将flag的值改为0，
            flag = 0;
            if(sum >= 10) {
                // 如果当前位置的数字之和大于10，那么将flag的值改为1，留给下一位数字进行计算
                flag = 1;
                sum = sum - 10;
            }
            if (l3!=null) {
                tail.next = new ListNode(sum);;
                tail = tail.next;
            } else {
                l3 = new ListNode(sum);
                tail = l3;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        // 如果l1和l2都变为null了，再判断flag的值
        if(l1==null && l2==null) {
            if(flag == 1) {
                l3.next = new ListNode(flag);
                return l3;
            }
        }
        // 如果l1不为空
        while(l1 != null) {
            l3.next = new ListNode(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            l3.next = new ListNode(l2.val);
            l2 = l2.next;
        }
        return l3;
    }
    @Test
    public void t6() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l3 = addTwoNumbers(l1,l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
    // 滑动窗口解决最长不重复子串问题
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        // map里存放的字母的位置信息，散列表存放字符和字符位置信息；滑动窗口当有重复，滑动窗口使得第一个字符退出窗口然后继续向后搜索
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                // 将窗口的左侧位置移动和之前重复字母的位置往后移动1位，求最大值；
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            // 最长串长度 等于max和当前位置减去
            max = Math.max(max,i-left+1);
        }
        return max;
    }
    /*
    * A,B两个有序数组，获取中位数
    * */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }
    /*
    * 最长回文串，动态规划解法： 转移方程 边界处理
    * 已知：回文串的子串仍旧是回文串，abcba bcb也是回文串 p(i,j) 表示第i到j个字母组成的串是否为回文串
    * */
    public String longestPalindrome(String s) {
        int len = s.length();
        // 如果字符串长度小于2直接返回回文串s本身
        if (len < 2) {
            return s;
        }
        // 用来记录最长的串长度
        int maxLen = 1;
        // 记录回文串开始的索引位置
        int begin = 0;
        // 1,状态定义dp[i][j]是否为回文串
        // 2，初始化 i和i的位置必然相等肯定是回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0;i < len;i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        // 3,状态转移
        for (int j = 1;j<len;j++) {
            for (int i = 0 ;i<j;i++) {
                // i位置和j位置之间的串不相等
                if (chars[i] != chars[j]) {
                    dp[i][j]=false;
                } else {
                // 相等情况下 如果j-i位置剩下一个字符，或者没有字符的时候，肯定是回文
                    if (j-i<3){
                        dp[i][j] = true;
                    } else {
                        // 状态转移 i到j 是否为回文串转移到i+1到j-1是否为回文串；
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                // 只要dp[i][j]==true,表示s[i...j]为回文串
                // 更新记录返回回文长度和起始位置
                if (dp[i][j] && j-i+1>maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        // substring两个参数，始末索引位置！
        return s.substring(begin,begin+maxLen);
    }
    /*
    * Z字变换，从上到下展开，从左至右读取
    *
    * */
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0;i<numRows;i++) rows.add(new StringBuilder());
        int i  = 0,flag = -1;
        for (char c : s.toCharArray()) {
            // 每行都用一个StringBuilder来装字符，最后将StringBuilder进行拼接
            rows.get(i).append(c);
            // 首行 或者 末行之后 将flag的方向颠倒
            if (i==0||i==numRows-1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();

    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    // 链表反转逻辑实现
    public ListNode reverse(ListNode head) {
        // 指向已翻转链表

        ListNode pre = null;
        // 作为转移
        ListNode temp = head;
        while(temp!=null) {
            ListNode t = temp.next;
            // 当前temp节点指向已翻转节点尾部
            temp.next = pre;
             pre = temp;
             temp = t;
        }
        return pre;
    }
    /**/
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        // 遍历数组，找到最小绝对值差
        return min;
    }
    void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        if (prev!=null) min = Math.min(min,root.val - prev.val);
        // 每次遍历的时候，将当前的遍历节点置为前指针指向
        prev = root;
        inorder(root.right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}