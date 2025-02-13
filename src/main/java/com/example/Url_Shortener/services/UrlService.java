package com.example.Url_Shortener.services;
import com.example.Url_Shortener.dto.UrlDto;



public interface UrlService {
    public UrlDto addOne(UrlDto url);
    public UrlDto getOne(String hash);
    void updateClicks(String hash,Long count);
}
