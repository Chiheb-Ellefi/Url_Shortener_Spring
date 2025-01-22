package com.example.Url_Shortener.services.impl;

import com.example.Url_Shortener.repositories.redis.RedisRepository;
import com.example.Url_Shortener.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RedisServiceImpl implements RedisService {
    private final RedisRepository redisRepository;
    private final RedisScript<String> stringRedisScript;
    private final RedisScript<Long> longRedisScript;
    @Autowired
  public   RedisServiceImpl(RedisRepository redisRepository,RedisScript<String> stringRedisScript,RedisScript<Long> longRedisScript){
        this.redisRepository=redisRepository;
        this.stringRedisScript=stringRedisScript;
        this.longRedisScript=longRedisScript;
    }
    @Override
    public String getUrlFromCache() {
        return redisRepository.executeScript(stringRedisScript, Collections.singletonList("counter"),"hello","hi");
    }

    @Override
    public Long updateClicksCount() {
       return redisRepository.executeScript(longRedisScript,Collections.singletonList("he"));

    }
}
