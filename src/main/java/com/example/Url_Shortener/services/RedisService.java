package com.example.Url_Shortener.services;


public interface RedisService {
    String getUrlFromCache();
    Long updateClicksCount();
}
