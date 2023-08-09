package com.boat.util;

import org.springframework.context.annotation.Configuration;

/**
 * @author 李云鹏
 * @version 1.0 仅供学习，Spring提供了一个StringRedisTemplate,将键和值全部转为字符串，但需要手动完成序列化和反序列化
 * @date 2023/1/1 22:21
 */
@Configuration
public class RedisConfig {
    /* @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        // 创建RedisTemplate对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 设置连接工厂
        template.setConnectionFactory(connectionFactory);
        // 创建Json序列化工具
        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        // 设置key的序列化
        template.setKeySerializer(RedisSerializer.string());
        template.setHashKeySerializer(RedisSerializer.string());
        // 设置value的序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        return template;
    }*/

}
