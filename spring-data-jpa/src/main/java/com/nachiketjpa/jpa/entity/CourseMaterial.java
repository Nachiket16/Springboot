package com.nachiketjpa.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL   //This will avoid unsaved transient instances
            //eg-> if we want to save course material without saving course this error will shown
            //to avoid this we will use Cascade
    )
    @JoinColumn(
            name = "course_Id", //Name inside the DB table
            referencedColumnName = "courseId"   //referring to Course
    )
    private Course course;

}
