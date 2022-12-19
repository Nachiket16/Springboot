package com.nachiket.blog.services;


import com.nachiket.blog.entities.Post;
import com.nachiket.blog.payloads.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    PostDto updatePost(PostDto postDto, Integer postId);

    void deletePost(Integer postId);

//    List<PostDto> getAllPost();
    List<PostDto> getAllPost(Integer pageNumber, Integer PageSize);

    PostDto getPostByID(Integer postId);

    //Get all by Category
    List<PostDto> getPostByCategory(Integer postId);

    //Get all by User
    List<PostDto> getPostByUser(Integer userID);

    //Search Post
    List<PostDto> searchPosts(String keyword);

    //
}
