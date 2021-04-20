package com.springbatch.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/** A,B两个人轮流抽数，保证自己抽数时刚好超过指定的数字
 * 回溯，
 */

public class T464 {
    public boolean canIWin(int maxChoosableInteger,int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        // 数列和都小，那么不满足最大
        if ((1+maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        int[] state = new int[maxChoosableInteger + 1];
        return backtrackWithMemo(state,desiredTotal,new HashMap<String,Boolean>());
    }
    private boolean backtrackWithMemo(int[] state,int desiredTotal,HashMap<String,Boolean> map) {
        String key = Arrays.toString(state);
        if (map.containsKey(key)) return map.get(key);
        for (int i=1;i<state.length;i++) {
            if (state[i] == 0) {
                state[i] = 1;
                if (desiredTotal - i <= 0 || !backtrackWithMemo(state,desiredTotal-i,map)) {
                    map.put(key,true);
                    state[i] = 0;
                    return true;
                }
                // 赢不了继续回溯
                state[i] = 0;
            }
        }
        map.put(key,false);
        return false;
    }
}
