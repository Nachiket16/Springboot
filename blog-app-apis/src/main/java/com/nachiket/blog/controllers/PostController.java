package com.nachiket.blog.controllers;

import com.nachiket.blog.config.AppConstants;
import com.nachiket.blog.payloads.ApiResponse;
import com.nachiket.blog.payloads.PostDto;
import com.nachiket.blog.payloads.PostResponse;
import com.nachiket.blog.services.FileService;
import com.nachiket.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

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

//    @GetMapping("/posts")
//    public ResponseEntity<List<PostDto>> getAllPosts(){
//        return ResponseEntity.ok(this.postService.getAllPost());
//    }

    //Get All using the Pagination method
//    @GetMapping("/posts")
//    public ResponseEntity<List<PostDto>> getAllPosts(
//            @RequestParam(value = "pageNumber", defaultValue = "0", required = false)Integer pageNumber,
//            @RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize){
//        return ResponseEntity.ok(this.postService.getAllPost(pageNumber, pageSize));
//    }

    //Get All using pagination with added information -> Total pages, elements, last page, page No -> Helpful for UI
//    @GetMapping("/posts")
//    public ResponseEntity<PostResponse> getAllPosts(
//            @RequestParam(value = "pageNumber", defaultValue = "0", required = false)Integer pageNumber,
//            @RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize){
//        PostResponse postResponse = this.postService.getAllPost(pageNumber,pageSize);
//        return ResponseEntity.ok(postResponse);
//    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false)Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false)String sortDir) {
        PostResponse postResponse = this.postService.getAllPost(pageNumber,pageSize, sortBy, sortDir);
        return ResponseEntity.ok(postResponse);
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

    //Search controller Method
    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(
            @PathVariable("keywords") String keywords
    ){
      List<PostDto> result = this.postService.searchPosts(keywords);
      return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);
    }

    //Search Posts By Content containing keyword
    @GetMapping("/posts/search/content/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByContent(
            @PathVariable("keywords") String keywords
    ){
        List<PostDto> result = this.postService.searchPostsContent("%"+keywords+"%");
        return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);
    }

    //Post Image Upload
    @PostMapping("/post/image/upload/{postId}")
    public ResponseEntity<PostDto> uploadPostImage(
            @RequestParam("image")MultipartFile image,
            @PathVariable Integer postId
    ) throws IOException {
        PostDto postDto = this.postService.getPostByID(postId);
        String fileName = this.fileService.uploadImage(path,image);
        postDto.setImageName(fileName);
        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
    }

    @GetMapping(value = "/post/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(
            @PathVariable("imageName") String imageName,
            HttpServletResponse response
    )throws IOException{
        InputStream resource = this.fileService.getResource(path,imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }

}
