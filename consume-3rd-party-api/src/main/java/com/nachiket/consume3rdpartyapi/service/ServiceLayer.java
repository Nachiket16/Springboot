package com.nachiket.consume3rdpartyapi.service;

import com.nachiket.consume3rdpartyapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceLayer {

    public final RestTemplate restTemplate;

    @Autowired
    public ServiceLayer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User consumeApi(){
        return restTemplate.getForObject("https://dummyjson.com/products/1", User.class);
    }

}
