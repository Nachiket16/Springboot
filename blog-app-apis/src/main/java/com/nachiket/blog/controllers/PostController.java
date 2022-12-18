package com.nachiket.blog.controllers;

import com.nachiket.blog.entities.Post;
import com.nachiket.blog.payloads.ApiResponse;
import com.nachiket.blog.payloads.CategoryDto;
import com.nachiket.blog.payloads.PostDto;
import com.nachiket.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    //Create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @Valid
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId)
    {
        PostDto createPost = this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }
    //Get By User

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@Valid @PathVariable Integer userId){
        List<PostDto> posts= this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@Valid @PathVariable Integer categoryId){
        List<PostDto> posts= this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return ResponseEntity.ok(this.postService.getAllPost());
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPostById(@Valid @PathVariable("postId") Integer postId) {
        return ResponseEntity.ok(this.postService.getPostByID(postId));
    }

    //Update By ID
    @PutMapping("/post/{postId}")
    public ResponseEntity<PostDto> updatePostById(@Valid @RequestBody PostDto postDto,@PathVariable("postId") Integer postId){
        PostDto updatedPost = this.postService.updatePost(postDto,postId);
        return ResponseEntity.ok(updatedPost);
    }



    //Delete By ID
    @DeleteMapping("/post/{postId}")
    public ResponseEntity<ApiResponse> deletePostById(@Valid @PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post successfully deleted ", true),HttpStatus.OK);
    }

}
