package com.springbatch.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springbatch.demo.dto.ResponseDto;
import com.springbatch.demo.model.User;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
public class TestController {
    // 方案一，本地hashmap,或者ThreadLocal来处理，同理重启挂掉
    // 内部缓存 这样每个session的信息都将作为map的值放到map里
    // 本地内存存储，如果服务重启，所有session状态全部丢失，存到第三方高可用地方更好，
    static Map<String, Object> map = new HashMap<>();

    // 方案二 引入redis,如果服务停掉，session状态还维护在redis里，下次服务可用时，客户端无感知无需重新登录
    @Autowired
    RedisTemplate redisTemplate;
    @GetMapping(value = "/aa")
    public ResponseDto getMessage() {
        ResponseDto<Object> objectResponseDto = new ResponseDto<>();

        objectResponseDto.setCode("111");
        objectResponseDto.setMessage("222");
        return objectResponseDto;
    }

    // 定义一个方法，设置cookie
    @GetMapping(value = "/setCookies")
    public String setCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("sessionId", "CookieInfo");
        Cookie cookie1 = new Cookie("username", "小王");
        response.addCookie(cookie);
        response.addCookie(cookie1);
        return "添加cookie信息成功";
    }

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    public String getCookies(HttpServletRequest request) {
        //HttpServletRequest 装请求信息类
        //HttpServletRespionse 装相应信息的类
        //   Cookie cookie=new Cookie("sessionId","CookieTestInfo");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    // 操作session
    @GetMapping("/setSession/{age}/{name}")
    public String setSession(HttpServletRequest request, HttpServletResponse response, @PathVariable int age,@PathVariable String name) {
        HttpSession session = request.getSession();
        User u1 = new User();
        u1.setAge(age);
        u1.setName(name);
        String tmp = JSON.toJSONString(u1);
        // 操作redisTemplate
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(session.getId(),tmp);
        return u1.toString();
    }

    @GetMapping("/getSession")
    public String getSession(HttpServletRequest request, HttpServletResponse responseid) {
        // 拿到当前 用户的session信息
        String result = "";
        HttpSession session = request.getSession();
        // session服务端状态化，获取之前放入该session的值
        String id = session.getId();
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String o1 = (String)valueOperations.get(id);
        User user = JSON.parseObject(o1, User.class);
        log.info(user.toString());
        return user.toString();
    }

}