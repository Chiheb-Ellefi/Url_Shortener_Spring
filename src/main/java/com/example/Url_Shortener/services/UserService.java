package com.example.Url_Shortener.services;

import com.example.Url_Shortener.dto.UserDto;


public interface UserService {
    public UserDto addUser(UserDto user);
    public UserDto getUser(Long user_id);
}
