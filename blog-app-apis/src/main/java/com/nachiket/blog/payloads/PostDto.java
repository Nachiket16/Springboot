package com.nachiket.blog.payloads;

import com.nachiket.blog.entities.Category;
import com.nachiket.blog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private String title;
    private String content;

    private String imageName;

    private Date addedDate;

    private CategoryDto category;

    private UserDto user;
}
