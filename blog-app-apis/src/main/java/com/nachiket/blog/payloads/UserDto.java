package com.nachiket.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//  Same as the ENTITY but using it for the passing/ exposing the value to the client side
//  So that Entity will be safe as DB connection is there
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String password;
    private String about;

}
