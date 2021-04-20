package com.springbatch.demo.service;

import com.springbatch.demo.model.User;
import org.springframework.stereotype.Service;


/**
 * @ClassName:userService
 * @author: Administrator
 * @Date: 2020/12/16 16 57
 **/
@Service
public class UserService {
    public User findUserById(String userId){
        User u = new User();
        u.setId(userId);
        return u;
    }
    public User findByUsername(User user){
        User user1 = new User();
        user1.setId("000");
        user1.setName("根据user名返回user");
        user1.setPassword("123456");
        return user1;
    }
}
