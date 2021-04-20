package com.springbatch.demo.designpattern.delegate;

public class ATarget implements Target {
    //A员工做具体的事情
    @Override
    public void dosomething(String commond) {
        System.out.println("A员工做具体的事情"+commond + "");
    }
}
