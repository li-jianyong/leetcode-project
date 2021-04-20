package com.springbatch.demo.test1;


import com.springbatch.demo.dto.ResponseDto;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ReflectTest01 {
    @Test
    public void testReflect() {
        // 类加载
        Class<ResponseDto> clazz = ResponseDto.class;
        // 获取字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            String name = f.getName();
            int fModifiers = f.getModifiers();
            Class fType = f.getType();
            System.out.println("字段名" + name + "字段权限" + fModifiers + "字段类型" + fType);
            Annotation[] annotations = f.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                // 将打印所有的注释，包括处于注解默认属性都会被打印
                System.out.println(f.getName() + "字段上有注释：" + annotation);
                System.out.println(annotation);
            }
        }
    }
    @Test
    public void testSingleton(){

    }
}
