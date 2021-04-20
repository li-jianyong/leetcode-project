package com.springbatch.demo.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
@Documented
public @interface SelfAnnotation {
    boolean value() default false;
//    String name();
//    int age();
}
