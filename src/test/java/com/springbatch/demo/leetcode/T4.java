package com.springbatch.demo.leetcode;

/**
 * 寻找两个数组的中位数
 */
public class T4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n=nums2.length;
        int left = -1,right = -1;
        int aStart = 0,bStart = 0;
        int len = m+n;
        for(int i=0;i<=len/2;i++) {
            left = right;
            // 以左边为准，只要nums1数组还存在，继续遍历，因为right取值根据数组1来定，直接走if语句，相反可以颠倒顺序，然后走else语句！
            if (aStart < m && (bStart>=n||nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }
}
