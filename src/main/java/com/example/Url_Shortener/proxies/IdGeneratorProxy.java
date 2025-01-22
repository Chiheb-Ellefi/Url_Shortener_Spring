package com.example.Url_Shortener.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;



@FeignClient(name="id", url="http://localhost:80")
public interface IdGeneratorProxy {
    @GetMapping
    public String getUniqueId();
}
