package com.springbatch.demo.test1;

import com.springbatch.demo.model.User;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName:Reflect
 * @author: Administrator
 * @Date: 2020/12/14 09 42
 **/
public class Reflect {
    @Test
    public void t(){
        Class userClazz = User.class;
        Constructor constructor;
        Method setAge = null;
        Field ageF = null;
        try {
            ageF = userClazz.getDeclaredField("age");
            ageF.setAccessible(true);
            System.out.println(userClazz.getDeclaredField("age"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            setAge = userClazz.getDeclaredMethod("increaseAge", int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            Object c = userClazz.newInstance();
            Object invoke = setAge.invoke(c,15);
            System.out.println(ageF.get(c));
            System.out.println("==============");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        try {
            constructor = userClazz.getConstructor(String.class, int.class);
            Constructor constructor1 = userClazz.getConstructor();
            Constructor constructor2 = userClazz.getConstructor(String.class);
            try {
//                User user = (User)constructor.newInstance("小李", 15);
                User user1 = (User)constructor1.newInstance();
                User user2 = (User)constructor2.newInstance("小王");
                System.out.println(user1);
                System.out.println(user2);
//                System.out.println(user2);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
