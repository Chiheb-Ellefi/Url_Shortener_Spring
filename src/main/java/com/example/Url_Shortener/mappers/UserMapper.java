package com.example.Url_Shortener.mappers;

import com.example.Url_Shortener.dto.UserDto;
import com.example.Url_Shortener.entities.User;
import java.util.stream.Collectors;

public class UserMapper {
    public static User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }


        User user = new User();
        user.setUser_id(userDto.getUser_id());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        if (userDto.getUrls() != null) {
            user.setUrls(userDto.getUrls().stream()
                    .map(UrlMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        return user;
    }

    public static UserDto toDto(User user) {
        if (user == null) {
            return null;
        }


        return UserDto.builder()
                .user_id(user.getUser_id())
                .email(user.getEmail())
                .password(user.getPassword())
                .urls(user.getUrls() != null ? user.getUrls().stream()
                        .map(UrlMapper::toDto)
                        .collect(Collectors.toList()) : null)
                .build();
    }
}
