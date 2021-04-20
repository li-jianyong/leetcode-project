package com.springbatch.demo.transaction;

import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName:T
 * @author: Administrator
 * @Date: 2020/12/4 14 38
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class T {
    int i = 4;
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void test1() throws Exception{
        i++;
        System.out.println("i的值时\n执行非事务方法之后，再次打印i\n");
        int res = test2();

        System.out.println(i);
    }
    public static int test2() throws Exception{
        int a = 0;
        try {
            a = 1/0;
        } catch (Exception e) {
            throw e;
        }
        return a;
    }
}
