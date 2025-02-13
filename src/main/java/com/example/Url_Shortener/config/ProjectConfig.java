package com.example.Url_Shortener.config;

import com.example.Url_Shortener.proxies.IdGeneratorProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAspectJAutoProxy
@EnableFeignClients(basePackageClasses = IdGeneratorProxy.class)
@Configuration
@EnableScheduling
public class ProjectConfig {
}
