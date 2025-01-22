package com.example.Url_Shortener.controllers;
import com.example.Url_Shortener.annotations.ToHash;
import com.example.Url_Shortener.dto.UrlDto;
import com.example.Url_Shortener.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {
    private final UrlService urlService;
    @Autowired
    public UrlShortenerController(UrlService urlService){
        this.urlService=urlService;

    }
    @PostMapping("/url/{user_id}")
    @ToHash
    public ResponseEntity<UrlDto> addUrl(@RequestBody UrlDto url,@PathVariable Long user_id){
        url.setUserId(user_id);
        UrlDto response=urlService.addOne(url);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/url/{hash}")
    public ResponseEntity<String> getUrl(@PathVariable String hash){
        UrlDto response=urlService.getOne(hash);
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", response.getUrl())
                .build();
    }

}
