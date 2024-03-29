package com.nachiket.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private Integer postId;
    @NotNull
    @Size(min = 5, message = "Title should be at least 5 character !!!")
    private String title;
    @NotNull
    @Size(min = 10, message = "Content in the post should be at least 10 character !!!")
    private String content;

    private String imageName;

    private Date addedDate;

    private CategoryDto category;

    private UserDto user;

//    private Set<Comment> comments = new HashSet<>();

}
