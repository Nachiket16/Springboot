package com.nachiket.blog.services.impl;

import com.nachiket.blog.entities.Category;
import com.nachiket.blog.entities.Post;
import com.nachiket.blog.entities.User;
import com.nachiket.blog.exception.ResourceNotFoundException;
import com.nachiket.blog.payloads.CategoryDto;
import com.nachiket.blog.payloads.PostDto;
import com.nachiket.blog.payloads.UserDto;
import com.nachiket.blog.repositories.CategoryRepo;
import com.nachiket.blog.repositories.PostRepo;
import com.nachiket.blog.repositories.UserRepo;
import com.nachiket.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
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
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User id", userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "Category id", categoryId));

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
    public List<PostDto> getAllPost() {
        List<Post> posts = this.postRepo.findAll();
        List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostByID(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post ID", postId));

        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "category id", categoryId));
        List<Post> posts = this.postRepo.findByCategory(cat);
        List<PostDto> postDtos = posts.stream()
                .map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userID) {
        User user = this.userRepo.findById(userID)
                .orElseThrow(() -> new ResourceNotFoundException("User", "User id", userID));
        List<Post> posts = this.postRepo.findByUser(user);
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
