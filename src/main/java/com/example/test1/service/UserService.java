package com.example.test1.service;

import com.example.test1.dto.UserDto;
import com.example.test1.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
