package com.nachiket.blog.services;

import com.nachiket.blog.payloads.UserDto;

import java.util.List;
public interface UserService {

    UserDto registerNewUser(UserDto user);

    UserDto createUser(UserDto user);
    //We are using UserDto because rather than exposing the Entity we are using the payload

    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);

}
