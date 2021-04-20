package com.springbatch.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计停车系统
 */
public class T1603 {
    int[] parkingLot = new int[3];
    public T1603(int big, int medium, int small) {
        parkingLot[0] = big;
        parkingLot[1] = medium;
        parkingLot[2] = small;
    }

    public boolean addCar(int carType) {
        switch(carType) {
            case 1:
                return parkingLot[0]-- > 0 ? true : false;
            case 2:
                return parkingLot[1]-- > 0 ? true : false;
            case 3:
                return parkingLot[2]-- > 0 ? true : false;
            default:
                break;
        }
        Map<Integer,Integer> map =  new HashMap<>();
        return false;
    }
}
