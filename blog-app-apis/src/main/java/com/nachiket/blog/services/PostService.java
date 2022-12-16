package com.nachiket.blog.services;


import com.nachiket.blog.entities.Post;
import com.nachiket.blog.payloads.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    Post updatePost(PostDto postDto, Integer postId);

    void deletePost(Integer postId);

    List<Post> getAllPost();

    Post getPostByID(Integer postId);

    //Get all by Category
    List<Post> getPostByCategory(Integer postId);

    //Get all by User
    List<Post> getPostByUser(Integer userID);

    //Search Post
    List<Post> searchPosts(String keyword);

    //
}