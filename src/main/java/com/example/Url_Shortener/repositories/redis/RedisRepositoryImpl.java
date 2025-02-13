package com.example.Url_Shortener.repositories.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedisRepositoryImpl implements  RedisRepository{
    private final RedisTemplate<String,String> redisTemplate;

    @Autowired
   public  RedisRepositoryImpl(RedisTemplate<String,String> redisTemplate){
        this.redisTemplate=redisTemplate;


    }

    @Override
    public <T> T executeScript(RedisScript<T> redisScript, List<String> keys,String... args) {
        return redisTemplate.execute(redisScript,keys, (Object[]) args);
    }

    @Override
    public String getUrlFromCache() {
       return redisTemplate.opsForValue().get("urls");
    }
}
