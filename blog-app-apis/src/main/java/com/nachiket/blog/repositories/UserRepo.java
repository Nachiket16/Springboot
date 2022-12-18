package com.nachiket.blog.repositories;

import com.nachiket.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    //JpaRepository<Entity, Id type> -> provide pre-defined method
    //Extends pagingAndSortingRepository
    //findAll, getById, deleteAllInBunch so many method available by default
}
