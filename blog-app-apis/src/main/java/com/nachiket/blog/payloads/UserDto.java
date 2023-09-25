package com.nachiket.blog.payloads;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    @NotEmpty
    @Email(message = "Email address is not valid !!")
    private String email;
    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be size of 3 chars to max of 10 chars")
    private String password;
    @NotEmpty(message = "About must not be empty !!!")
    private String about;

//    private Set<Comment> comments = new HashSet<>();
    private Set<RoleDto> roles = new HashSet<>();

    @JsonIgnore
    public String getPassword(){
        return this.getPassword();
    }

    @JsonProperty
    public void setPassword(String password){
        this.password = password;
    }
}
