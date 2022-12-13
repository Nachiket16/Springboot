package com.example.springbootproject.dao;

import com.example.springbootproject.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
