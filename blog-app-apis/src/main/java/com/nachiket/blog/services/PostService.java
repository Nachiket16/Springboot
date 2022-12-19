package com.nachiket.blog.services;


import com.nachiket.blog.entities.Post;
import com.nachiket.blog.payloads.PostDto;
import com.nachiket.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    PostDto updatePost(PostDto postDto, Integer postId);

    void deletePost(Integer postId);

    //Get All Post
//    List<PostDto> getAllPost();

    //Pagination Get All POst
//    PostResponse getAllPost(Integer pageNumber, Integer PageSize);

    //Sort By with Pagination
    PostResponse getAllPost(Integer pageNumber, Integer PageSize, String sortBy, String sortDir);


    PostDto getPostByID(Integer postId);

    //Get all by Category
    List<PostDto> getPostByCategory(Integer postId);

    //Get all by User
    List<PostDto> getPostByUser(Integer userID);

    //Search Post
    List<PostDto> searchPosts(String keyword);

    //
}
