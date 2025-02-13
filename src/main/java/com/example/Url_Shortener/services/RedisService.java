package com.example.Url_Shortener.services;


import java.util.List;

public interface RedisService {
    String getUrlFromCache(String hash);
    Long getClicks(String hash);
    String setUrlInCache(String hash, String url, Long clicks);
    String[] getAllHashesInCache();
}
