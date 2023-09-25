package com.nachiket.blog.controllers;

import com.nachiket.blog.payloads.ApiResponse;
import com.nachiket.blog.payloads.UserDto;
import com.nachiket.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Post - For creation
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    //Put - Update
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto userDto, @PathVariable("userId") Integer userId){
        UserDto updatedUser = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updatedUser);
    }

    //Delete -

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@Valid @PathVariable("userId") Integer uid){
        this.userService.deleteUser(uid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
    }


    //GET - User list
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return  ResponseEntity.ok(this.userService.getAllUsers());
    }

    //GET - User
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@Valid @PathVariable("userId") Integer userId){
        return  ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
