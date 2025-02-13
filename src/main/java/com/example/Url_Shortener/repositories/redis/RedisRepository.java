package com.example.Url_Shortener.repositories.redis;

import org.springframework.data.redis.core.script.RedisScript;

import java.util.List;

public interface RedisRepository {
   <T> T  executeScript(RedisScript<T> redisScript, List<String> keys, String... args) ;
   String getUrlFromCache();

}
