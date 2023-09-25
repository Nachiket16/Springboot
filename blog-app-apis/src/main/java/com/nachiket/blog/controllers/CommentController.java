package com.nachiket.blog.controllers;

import com.nachiket.blog.payloads.ApiResponse;
import com.nachiket.blog.payloads.CommentDto;
import com.nachiket.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto comment,
            @PathVariable Integer postId
            ){
        CommentDto comment1 = this.commentService.createComment(comment, postId);
        return new ResponseEntity<CommentDto>(comment1, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> createComment(
            @PathVariable Long commentId
    ){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Comment Successfully ", true), HttpStatus.OK);
    }


}
