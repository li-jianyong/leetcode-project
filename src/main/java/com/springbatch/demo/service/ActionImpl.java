package com.springbatch.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ActionImpl extends AbstractAction {
    @Value("${test.name}")
    private String name;

    @PostConstruct
    public void init() {
        super.name = name;
    }
    @Override
    public void doAction() {
        test();
    }
}
