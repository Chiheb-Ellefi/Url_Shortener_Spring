package com.example.Url_Shortener.controllers;
import com.example.Url_Shortener.annotations.ToCheckCache;
import com.example.Url_Shortener.annotations.ToHash;
import com.example.Url_Shortener.dto.UrlDto;
import com.example.Url_Shortener.services.RedisService;
import com.example.Url_Shortener.services.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {
     private final HttpServletRequest request;
    private final UrlService urlService;
    private final RedisService redisService;

    @Autowired
    UrlShortenerController(HttpServletRequest request, UrlService urlService, RedisService redisService){
        this.request=request;
        this.urlService=urlService;
        this.redisService = redisService;
    }

    @PostMapping("/url/{user_id}")
    @ToHash
    public ResponseEntity<String> addUrl(@RequestBody UrlDto url,@PathVariable Long user_id){
        url.setUserId(user_id);
        urlService.addOne(url);
        return  ResponseEntity.status(HttpStatus.CREATED).body(url.getHash());
    }
        @GetMapping("/url/{hash}")
        @ToCheckCache
        public ResponseEntity<String> getUrl(@PathVariable String hash, HttpServletRequest request){
            UrlDto response=urlService.getOne(hash);
            String cacheStatus = (String) request.getAttribute("cacheStatus");
           if (cacheStatus != null && cacheStatus.equals("MISS")) {
               response.setClicks(response.getClicks()+1);
               String result = redisService.setUrlInCache(response.getHash(), response.getUrl(), response.getClicks() + 1);
               System.out.println("Set URL in cache result: " + result);
           }
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", response.getUrl())
                    .build();
        }

    }
