package com.nachiket.blog.services;

import com.nachiket.blog.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Long commentId);
}
