package com.springbatch.demo.mianshi;

import java.util.Arrays;

/** 堆箱子，下层箱子三围严格大于上层箱子。判断堆砌起来的箱子的最大高度
 * @ClassName:T08
 * @author: Administrator
 * @Date: 2020/12/28 20 34
 **/
public class T08 {
    public int pileBox(int[][] box) {
        int len = box.length;
        // 数组严格排序，按照宽，深，高的几个排序字段降序排
        Arrays.sort(box, (a, b) -> a[0] == b[0] ? a[1] == b[1] ? b[2] - a[2] : b[1] - a[1] : a[0] - b[0]);
        // 动态规划数组，dp_val[0]表示第0个箱子为顶部的一堆箱子的高度总和
        int[] dp_val = new int[len];
        // 初始高度为二维数组的第三个维度值
        dp_val[0] = box[0][2];
        // 初始状态
        int res = dp_val[0];
        // 外层遍历每个盒子
        for (int i = 1; i < len; ++i) {
            // 宽度已经严格排序，
            //  max_val代表当前盒子上面能放的最高的高度盒子，
            //  base_depth当前行的深度，base_height当前行的高度，
            int max_val = 0, base_depth = box[i][1], base_height = box[i][2];
            // 判断i行前面的元素，后面不用判断因为数组已经排序过，后面的元素宽度不符合规范了。
            for (int j = 0; j < i; ++j)
                // 如果当前的深度大于下一个盒子的深度，并且高度大于下一个盒子的高度
                    if (base_depth > box[j][1] && base_height > box[j][2])
                    // 更新最大值
                    max_val = Math.max(max_val, dp_val[j]);
            // 内层for循环，算出了i元素上能够方的最高高度，加上i元素自身的高度，得到当前盒子为顶部能得到的最大高度。
            dp_val[i] = max_val + base_height;
            // 结果每次更新为最大
            res = Math.max(res, dp_val[i]);
        }
        return res;
    }
}
