package com.boat;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.boat.entity.PilotStation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 李云鹏
 * @version 1.0
 * @date 2023/1/1 21:55
 */
@SpringBootTest
public class RedisTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        this.stringRedisTemplate.opsForValue().set("age", String.valueOf(18));
        this.stringRedisTemplate.opsForValue().set("name", "张三");
        Object name = this.stringRedisTemplate.opsForValue().get("name");
        Object age = this.stringRedisTemplate.opsForValue().get("age");
        System.out.println(age + "---" + name);
    }

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void StringRedisTemplateTest() throws JsonProcessingException {
        // 创建对象
        PilotStation pilotStation = new PilotStation(10L, "测试引航站", "CCCCC");
        // 手动序列化
        String json = mapper.writeValueAsString(pilotStation);
        // 存入数据
        this.stringRedisTemplate.opsForValue().set("pilotStation", json);
        // 读取数据
        String s = this.stringRedisTemplate.opsForValue().get("pilotStation");
        // 手动反序列化
        PilotStation pilotStation1 = mapper.readValue(s, PilotStation.class);
        System.out.println(pilotStation1);
    }
}
