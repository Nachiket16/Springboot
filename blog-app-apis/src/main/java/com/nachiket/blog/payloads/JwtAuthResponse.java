package com.nachiket.blog.payloads;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class JwtAuthResponse {
    private String token;

}
