package com.springbatch.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.springbatch.demo.model.User;
import org.springframework.stereotype.Service;

/**
 * @ClassName:TokenService
 * @author: Administrator
 * @Date: 2020/12/16 17 06
 **/
@Service
public class TokenService {
    // 使用HS256生成token 把id存入token,密钥是用户的密码
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
