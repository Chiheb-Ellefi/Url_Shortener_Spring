package com.example.Url_Shortener.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

@Configuration
public class RedisScriptConfig {
    @Bean
    RedisScript<String> getUrl(){
        DefaultRedisScript<String> script=new DefaultRedisScript<String>() ;
        script.setResultType(String.class);
        script.setLocation(new ClassPathResource("scripts/"));
        return script;
    }
    @Bean
    RedisScript<Long> updateCount(){
        DefaultRedisScript<Long> script=new DefaultRedisScript<Long>() ;
        script.setResultType(Long.class);
        script.setLocation(new ClassPathResource("scripts/"));
        return script;
    }
}
