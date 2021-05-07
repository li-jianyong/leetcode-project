package com.springbatch.demo.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl1 implements TestService{

    @Override
    public void ins() {
        System.out.println("插入");
    }

    @Override
    public void del() {
        System.out.println("删除");
    }

    @Override
    public void upd() {
        System.out.println("更新");
    }

    @Override
    public void sel() {
        System.out.println("查询");
    }
}
