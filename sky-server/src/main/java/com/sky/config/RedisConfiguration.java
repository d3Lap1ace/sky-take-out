package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @classname sky
 * @Auther d3Lap1ace
 * @Time 27/6/2024 11:24 周四
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@Configuration
@Slf4j
public class RedisConfiguration {
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        log.info("开始创建redis模板对象...");
        RedisTemplate redisTemplate = new RedisTemplate();

        redisTemplate.setConnectionFactory(redisConnectionFactory);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
