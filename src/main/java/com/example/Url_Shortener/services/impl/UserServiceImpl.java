package com.example.Url_Shortener.services.impl;

import com.example.Url_Shortener.dto.UserDto;
import com.example.Url_Shortener.entities.User;
import com.example.Url_Shortener.mappers.UserMapper;
import com.example.Url_Shortener.repositories.UserRepository;
import com.example.Url_Shortener.services.UserService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public UserDto addUser(UserDto user) {
        User entity= userRepository.save(UserMapper.toEntity(user));
        return UserMapper.toDto(entity);

    }

    @Override
    public UserDto getUser(Long user_id) {
        Optional<User> entity= userRepository.findById(user_id);
        //change the Runtime Exception to a more descriptive custom exception
        return entity.map(UserMapper::toDto).orElseThrow(()->new RuntimeException("User not found"));

    }
}
