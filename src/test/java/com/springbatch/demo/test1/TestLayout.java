package com.springbatch.demo.test1;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

public class TestLayout {
    @Test
    public void test1() {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
