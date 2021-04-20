package com.springbatch.demo.designpattern.delegate;

public class DelegateTest {
    // 创建一个leader对象去做指定的事情
    public static void main(String[] args) {
        new Leader().dosomething("打印文件");
    }
}
