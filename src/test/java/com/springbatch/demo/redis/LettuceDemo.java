package com.springbatch.demo.redis;

import com.springbatch.demo.model.User;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName:LettuceDemo
 * @author: Administrator
 * @Date: 2020/12/1 21 01
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LettuceDemo {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 6379;
    @Autowired
    private RedisTemplate redisTemplate;
    // 设置redis的key,value序列化为字符串序列化，因为默认JDK自带序列化，会存在显示问题。
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    @Test
    public void t(){
        // 创建单机的连接信息
        RedisURI redisURI = RedisURI.builder()
                .withHost("localhost")
                .withPort(6379)
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS)).build();
        // 创建客户端
        RedisClient redisClient = RedisClient.create(redisURI);
        //  创建线程安全的连接
        StatefulRedisConnection<String,String> connection = redisClient.connect();
        // 创建同步命令
        RedisCommands<String,String> redisCommands = connection.sync();
//        SetArgs setArgs = SetArgs.Builder.nx().ex(5);
//        String result = redisCommands.set("name","throwable",setArgs);
//        Assertions.assertThat(result).isEqualToIgnoringCase("OK");
        String result = redisCommands.get("name");
        System.out.println("打印redis返回的结果：" + result);
        // 关闭连接
        connection.close();
        // 关闭客户端
        redisClient.shutdown();
    }
    @Test
    public void t1(){
        ValueOperations objOps = redisTemplate.opsForValue();
//        redisTemplate.delete("age");
        int age = 11;
        objOps.set("age", "11");
        System.out.println("打印内容：" + objOps.get("age"));
        Set<String> keys = redisTemplate.keys("*");
        for (String a : keys) {
            System.out.println(a);
        }
    }
    Jedis jedis;
    @Before
    public void connectTest(){
        System.out.println("执行junit before注解");
        jedis = new Jedis(HOST,PORT);
        System.out.println(jedis.exists("name"));
        System.out.println(jedis.keys("*"));
        jedis.set("stu","student");
        System.out.println(jedis.get("stu"));
        jedis.mset("a","1","b","2");
        List<String> values = jedis.mget("a","b");
        System.out.println(values);
        // 批量删除
        jedis.del("a","b","age");
    }
    @Test
    public void t3(){
        String key = "user_1";
        Map<String, String> hash = new HashMap<String, String>();
        hash.put("name", "小王");
        hash.put("age", "22");
        jedis.hmset(key, hash);
//        jedis.hset(key, "ddd", "44");
        System.out.println(jedis.hkeys(key));
        System.out.println(jedis.hvals(key));
        String name = jedis.hget(key, "name");
        String age = jedis.hget(key, "age");
        User u1 = new User();
        u1.setName(name);
        u1.setAge(Integer.valueOf(age));
        System.out.println("redis获取hash类型得到的user：" + u1);
    }
}
