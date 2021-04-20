package com.springbatch.demo.service;

public class TestServiceImpl2 implements TestService{

    @Override
    public void ins() {
        System.out.println("插入2");
    }

    @Override
    public void del() {
        System.out.println("删除2");
    }

    @Override
    public void upd() {
        System.out.println("更新2");
    }

    @Override
    public void sel() {
        System.out.println("查询2");
    }
}
