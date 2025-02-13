package com.example.Url_Shortener.services.impl;

import com.example.Url_Shortener.repositories.redis.RedisRepository;
import com.example.Url_Shortener.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {
    private final RedisRepository redisRepository;
    private final RedisScript<String> getUrl;
    private final RedisScript<String> setUrl;
    private final RedisScript<Long> longRedisScript;
    @Autowired
  public   RedisServiceImpl(RedisRepository redisRepository,RedisScript<String> getUrl,RedisScript<Long> longRedisScript,RedisScript<String> setUrl){
        this.redisRepository=redisRepository;
        this.getUrl=getUrl;
        this.longRedisScript=longRedisScript;
        this.setUrl=setUrl;
    }
    @Override
    public String getUrlFromCache(String hash) {
        return redisRepository.executeScript(getUrl, Collections.singletonList(hash));
    }
    @Override
    public String setUrlInCache(String hash, String url, Long clicks) {
        return redisRepository.executeScript(setUrl, Collections.singletonList(hash),url,clicks.toString());
    }

    @Override
    public String[] getAllHashesInCache() {
       String urls= redisRepository.getUrlFromCache();
       if(urls!=null){
           return urls.split(":");
       }
       return null;
    }

    @Override
    public Long getClicks(String hash) {
       return redisRepository.executeScript(longRedisScript,Collections.singletonList(hash));

    }
}
