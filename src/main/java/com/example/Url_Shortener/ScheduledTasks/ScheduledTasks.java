package com.example.Url_Shortener.ScheduledTasks;

import com.example.Url_Shortener.services.RedisService;
import com.example.Url_Shortener.services.UrlService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private final RedisService redisService;
    private final UrlService urlService;
    @Autowired
    ScheduledTasks(RedisService redisService, UrlService urlService) {
        this.redisService = redisService;
        this.urlService = urlService;
    }
    @Scheduled(fixedRate = 60000)
    @Transactional
    public void updateClicks() {
        System.out.println("Updating clicks !");
    String[] hashes=redisService.getAllHashesInCache();
    if(hashes!=null ){
        for(String hash:hashes){
            Long clicks= redisService.getClicks(hash);
            if(clicks!=null && clicks!=-1){
                urlService.updateClicks(hash,clicks);
                System.out.println("Updated clicks for hash: "+hash);
            }
        }
    }


    }
}
