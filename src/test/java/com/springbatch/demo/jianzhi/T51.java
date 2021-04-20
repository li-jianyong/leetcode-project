package com.springbatch.demo.jianzhi;

/** 计算数组里的逆序对数
 * @ClassName:T51
 * @author: Administrator
 * @Date: 2020/12/28 21 44
 **/
public class T51 {
    // 方法1，暴力破解
    public int reversePairs1(int[] nums) {
        int cnt = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    // 用归并排序的思想，每次将逆序对统计进去
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        // 统计左侧逆序对数
        int leftPairs = reversePairs(nums, left, mid, temp);
        // 统计右侧逆序对数
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        // 如果整个数组已经有序，则无需合并，注意这里使用小于等于
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        // 左右两侧都局部有序后，开始归并到一起 ，归并过程中比较逆序对数
            int crossPairs = mergeAndCount(nums, left, mid, right, temp);
            return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        // 借用temp数组，来存放原始数组的值
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        // 分别从左右两侧的起始部分开始向后遍历，将值放到最后的数组里。
        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {
            // 有下标访问，得先判断是否越界
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 注意：这里是 <= ，写成 < 就不对，请思考原因
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;

                // 在 j 指向的元素归并回去的时候，计算逆序对的个数，只多了这一行代码
                // 在j归并回去的时候，进行判断
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
