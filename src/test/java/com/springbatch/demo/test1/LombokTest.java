package com.springbatch.demo.test1;

import com.springbatch.demo.model.Student;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName:LombokTest
 * @author: Administrator
 * @Date: 2020/12/14 10 29
 **/
public class LombokTest {
    @Test
    public void t(){
        Student stu1 = new Student();
        stu1.setName("hhh")
                .setAddress("student1-address")
                .setId(1)
//                .setCreateTime(20190310140423L)
                .setUpdateTime(20190310140423L);
        Class clazz = Student.class;
        List<Field> allFields = new ArrayList<>(100);
        allFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        Class clazzSuper = clazz.getSuperclass();
        // 循环遍历所有的父类字段
        while (clazzSuper != Object.class) {
            allFields.addAll(Arrays.asList(clazzSuper.getDeclaredFields()));
            clazzSuper = clazzSuper.getSuperclass();
        }
        allFields.stream().forEach(field -> {
            field.setAccessible(true);
            String fieldName = field.getName();
            try {
                Object o = field.get(stu1);
                System.out.println(fieldName + "=" + o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
