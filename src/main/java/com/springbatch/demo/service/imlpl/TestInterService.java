package com.springbatch.demo.service.imlpl;

import com.springbatch.demo.service.ITestInter;
import org.springframework.stereotype.Service;

@Service
public class TestInterService implements ITestInter {
    @Override
    public String say() {
        return "hello";
    }
}
