package com.example.Url_Shortener.mappers;
import com.example.Url_Shortener.dto.UrlDto;
import com.example.Url_Shortener.entities.Url;


public  class  UrlMapper {

    public static UrlDto toDto(Url url)  {
        return UrlDto.builder()
                .id(url.getId())
                .url(url.getUrl())
                .hash(url.getHash())
                .userId(url.getUserId())
                .clicks(url.getClicks())
                .qrCode(url.getQrCode())
                .status(url.getStatus())
                .build();
    }
    public static Url toEntity(UrlDto urlDto){
        return new Url(
                urlDto.getId(),
                urlDto.getUrl(),
                urlDto.getHash(),
                urlDto.getClicks(),
                urlDto.getQrCode(),
                urlDto.getStatus(),
                urlDto.getUserId()
        );
    }
}
