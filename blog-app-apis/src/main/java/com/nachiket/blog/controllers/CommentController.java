package com.nachiket.blog.controllers;

import com.nachiket.blog.entities.Comment;
import com.nachiket.blog.entities.Post;
import com.nachiket.blog.payloads.CommentDto;
import com.nachiket.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
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

}
