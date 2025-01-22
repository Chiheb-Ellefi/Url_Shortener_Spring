package com.example.Url_Shortener.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserDto {
    private Long user_id;
    private String email;
    private String password;
    private List<UrlDto> urls;
    public Boolean isNull(){
        return  email.isEmpty()  || password.isEmpty();
    }
}
