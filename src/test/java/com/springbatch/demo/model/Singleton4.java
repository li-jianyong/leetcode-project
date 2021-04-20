package com.springbatch.demo.model;
//饱汉式  DC 2.0 double check Lock
public class Singleton4 {
//    private static volatile Singleton4 singleton = null;
//    public int f1 =1;
//    public int f2 = 1;
//    private Singleton4(){}
//    public static Singleton4 getInstance() {
//        if (singleton == null){
//            // 因为无法保证原子性，所以，内部再次进行判断
//            synchronized (Singleton4.class) {
//                if (singleton == null) {
//                    singleton = new Singleton4();
//                }
//            }
//        }
//        return singleton;
//    }
    // DCL 两次枷锁监测，volatile禁止指令重排，防止jvm在内存分配时，不完整初始化造成对象的空的情况。
    private static volatile Singleton4 singleton = null;
    public int f1 =1;
    public int f2 = 2;
    private Singleton4(){}
    public static Singleton4 getInstance() {
        if (singleton==null) {
            synchronized (Singleton4.class) {
                if (singleton==null) {
                    singleton = new Singleton4();
                }

            }
        }
        return singleton;
    }
}
