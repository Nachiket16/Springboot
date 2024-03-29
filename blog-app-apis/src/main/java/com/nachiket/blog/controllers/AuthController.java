package com.nachiket.blog.controllers;

import com.nachiket.blog.entities.User;
import com.nachiket.blog.exception.ApiException;
import com.nachiket.blog.payloads.JwtAuthRequest;
import com.nachiket.blog.payloads.JwtAuthResponse;
import com.nachiket.blog.payloads.UserDto;
import com.nachiket.blog.security.JwtTokenHelper;
import com.nachiket.blog.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(
            @RequestBody JwtAuthRequest request
            ) throws Exception {
        this.authenticate(request.getUsername(),request.getPassword());

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.jwtTokenHelper.generateToken(userDetails);

        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);
        response.setUser(this.modelMapper.map((User)userDetails,UserDto.class));
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    private void authenticate(String username, String password) throws Exception {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);

            try {
                this.authenticationManager.authenticate(authenticationToken);
            }catch (BadCredentialsException e){
                System.out.println("Invalid Username pass Details");
                throw new ApiException("Invalid Username or Password !!!");
            }
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody @Valid UserDto userDto){
        System.out.println("userDto = " + userDto);
        UserDto registerNewUser = this.userService.registerNewUser(userDto);
        return new ResponseEntity<UserDto>(registerNewUser, HttpStatus.CREATED);
    }

}
