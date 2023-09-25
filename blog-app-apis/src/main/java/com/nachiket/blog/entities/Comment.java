package com.nachiket.blog.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    private String content;

    //User will comment on the Post


    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

}
