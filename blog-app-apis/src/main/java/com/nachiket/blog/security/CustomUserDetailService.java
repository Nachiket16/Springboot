package com.nachiket.blog.security;

import com.nachiket.blog.entities.User;
import com.nachiket.blog.exception.ResourceNotFoundException;
import com.nachiket.blog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Loading user from db by username
        User user = this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("username","user email not found : ", username));
        return user;
    }
}
