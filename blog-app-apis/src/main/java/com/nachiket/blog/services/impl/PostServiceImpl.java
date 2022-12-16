package com.nachiket.blog.services.impl;

import com.nachiket.blog.entities.Category;
import com.nachiket.blog.entities.Post;
import com.nachiket.blog.entities.User;
import com.nachiket.blog.exception.ResourceNotFoundException;
import com.nachiket.blog.payloads.PostDto;
import com.nachiket.blog.repositories.CategoryRepo;
import com.nachiket.blog.repositories.PostRepo;
import com.nachiket.blog.repositories.UserRepo;
import com.nachiket.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id",userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","Category id", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("defalut.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post savePost = this.postRepo.save(post);
        return this.modelMapper.map(savePost, PostDto.class);
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post getPostByID(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostByUser(Integer userID) {
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
