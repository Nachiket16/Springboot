package com.nachiket.blog.repositories;

import com.nachiket.blog.entities.Category;
import com.nachiket.blog.entities.Post;
import com.nachiket.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);
}
