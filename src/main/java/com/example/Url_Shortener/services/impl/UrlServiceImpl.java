package com.example.Url_Shortener.services.impl;

import com.example.Url_Shortener.dto.UrlDto;
import com.example.Url_Shortener.entities.Url;
import com.example.Url_Shortener.mappers.UrlMapper;
import com.example.Url_Shortener.repositories.UrlRepository;
import com.example.Url_Shortener.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {
    private final UrlRepository urlRepository;
    @Autowired
    UrlServiceImpl(UrlRepository urlRepository){
        this.urlRepository=urlRepository;
    }
    @Override
    public UrlDto addOne(UrlDto url){
        Url response=urlRepository.save(UrlMapper.toEntity(url));
       return UrlMapper.toDto(response);
    }
    @Override
    public UrlDto getOne(String  hash){
        Url response=urlRepository.findByHash(hash);
        return UrlMapper.toDto(response);
    }
}
