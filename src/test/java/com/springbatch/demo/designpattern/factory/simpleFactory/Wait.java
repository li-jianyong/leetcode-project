package com.springbatch.demo.designpattern.factory.simpleFactory;

public class Wait {
    public static final int MEAN_MEET = 1;
    public static final int MEAN_FISH = 2;
    public static final int MEAN_DUCK = 3;

    /** 客户端调用getMean方法传入指定的类型，来获取Resaurant
     * @param meantype
     * @return
     */
    public static Resaurant getMean(int meantype){
        switch (meantype){
            case MEAN_MEET :
                return new Meet();
            case MEAN_FISH :
                return new Fish();
            case MEAN_DUCK :
                return new Duck();
            default:
                return null;
        }
    }
}
