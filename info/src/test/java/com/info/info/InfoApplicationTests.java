package com.info.info;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class InfoApplicationTests {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        this.redisTemplate.opsForValue().set("age", 18);
        Object age = this.redisTemplate.opsForValue().get("age");
        System.out.println(age);
    }

}
