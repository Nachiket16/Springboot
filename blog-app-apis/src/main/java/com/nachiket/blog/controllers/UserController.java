package com.nachiket.blog.controllers;

import com.nachiket.blog.entities.User;
import com.nachiket.blog.payloads.ApiResponse;
import com.nachiket.blog.payloads.UserDto;
import com.nachiket.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Post - For creation
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    //Put - Update
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer userId){
        UserDto updatedUser = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }

    //Delete -

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
    }


    //GET - User list
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return  ResponseEntity.ok(this.userService.getAllUsers());
    }

    //GET - User
    @GetMapping("/{userID}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable("userId") Integer userId){
        return  ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
