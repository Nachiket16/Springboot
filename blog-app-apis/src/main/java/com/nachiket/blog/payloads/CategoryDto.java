package com.nachiket.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Integer categoryId;
    @NotNull
    @Size(min = 4)
    private String categoryTitle;
    @NotBlank
    @Size(min = 10, message = "Minimum size of category description is 10")
    private String categoryDescription;
}
