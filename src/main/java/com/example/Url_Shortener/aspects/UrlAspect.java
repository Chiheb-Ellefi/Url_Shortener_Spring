package com.example.Url_Shortener.aspects;

import com.example.Url_Shortener.dto.UrlDto;
import com.example.Url_Shortener.proxies.IdGeneratorProxy;
import com.example.Url_Shortener.utils.HashUrl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UrlAspect {
    private final HttpServletRequest request;
    private  final HttpServletResponse response;
    private final IdGeneratorProxy idGeneratorProxy;

    @Autowired
    UrlAspect(HttpServletRequest request,HttpServletResponse response,IdGeneratorProxy idGeneratorProxy){
        this.response=response;
        this.request=request;
        this.idGeneratorProxy=idGeneratorProxy;

    }

@Around("@annotation(com.example.Url_Shortener.annotations.ToHash)")
    public void hashUrl(ProceedingJoinPoint joinPoint) throws Throwable{
        Long id=Long.parseLong(idGeneratorProxy.getUniqueId());
    Object[] args = joinPoint.getArgs();
    UrlDto url;
    if (args.length > 0 && args[0] instanceof UrlDto) {
        String hash= HashUrl.hashToBase62(id);
        url = (UrlDto) args[0];
        url.setId(id);
        url.setHash(hash);
        url.setQrCode("qrcode");
        url.setClicks(0L);
        url.setStatus(true);
    }
    joinPoint.proceed();
}
}
