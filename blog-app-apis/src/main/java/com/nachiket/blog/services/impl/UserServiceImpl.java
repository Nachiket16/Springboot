package com.nachiket.blog.services.impl;

import com.nachiket.blog.config.AppConstants;
import com.nachiket.blog.entities.Role;
import com.nachiket.blog.entities.User;
import com.nachiket.blog.exception.ResourceNotFoundException;
import com.nachiket.blog.payloads.UserDto;
import com.nachiket.blog.repositories.RoleRepo;
import com.nachiket.blog.repositories.UserRepo;
import com.nachiket.blog.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public UserDto registerNewUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        //Encoded the password
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        //Roles by default it's ROLE_NORMAl
        Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();

        user.getRoles().add(role);
        User newUser = this.userRepo.save(user);
        return this.modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", " Id ",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser = this.userRepo.save(user);
        UserDto userDto1 = this.userToDto(updatedUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
//        User user = this.userRepo.findById(userId)
//                .orElseThrow(()-> new ResourceNotFoundException("User", " Id ",userId));
//        User user = this.userRepo.getOne(userId);
        return this.userToDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos =  users.stream()
                                       .map(user -> this.userToDto(user))
                                       .collect((Collectors.toList()));
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
       User user = this.userRepo.findById(userId)
               .orElseThrow(() -> new ResourceNotFoundException("User", " ID ", userId));
       this.userRepo.delete(user);
    }

    public User dtoToUser(UserDto userDto){
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());
//        user.setPassword(userDto.getPassword());
//        return  user;
        //MODEL MAPPER DEPENDENCIES ADDED
        User user = this.modelMapper.map(userDto, User.class);

        return user;
    }
    public UserDto userToDto(User user){
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setAbout(user.getAbout());
//        userDto.setPassword(user.getPassword());
//        return userDto;
        //MODEL MAPPER DEPENDENCIES ADDED
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return  userDto;
    }

}
