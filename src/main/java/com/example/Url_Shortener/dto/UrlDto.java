package com.example.Url_Shortener.dto;

import com.example.Url_Shortener.entities.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class UrlDto {
    private Long id;
    private String url;
    private String hash;
    private Long clicks;
    private String qrCode;
    private Boolean status;
    private Long userId;

}
