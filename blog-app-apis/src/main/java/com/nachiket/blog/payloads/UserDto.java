package com.nachiket.blog.payloads;

import com.nachiket.blog.entities.Comment;
import com.nachiket.blog.entities.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

//  Same as the ENTITY but using it for the passing/ exposing the value to the client side
//  So that Entity will be safe as DB connection is there
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
    @NotEmpty
    @Size(min = 3, message = "Username must be of 3 character")
    private String name;
    @Email(message = "Email address is not valid !!")
    private String email;
    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be size of 3 chars to max of 10 chars")
    private String password;
    @NotEmpty
    private String about;

//    private Set<Comment> comments = new HashSet<>();
    private Set<RoleDto> roles = new HashSet<>();
}
