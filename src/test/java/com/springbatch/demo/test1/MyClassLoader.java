package com.springbatch.demo.test1;

import org.openjdk.jol.info.ClassLayout;

public class MyClassLoader extends ClassLoader {
    private String rootPath;
    public MyClassLoader() {
        super();
    }

}
