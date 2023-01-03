package com.nachiketjpa.jpa.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")       //As we are fetching lazy we don't need the course to be printed
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
            cascade = CascadeType.ALL,   //This will avoid unsaved transient instances
            //eg-> if we want to save course material without saving course this error will be shown
            //to avoid this we will use Cascade

            fetch = FetchType.LAZY  //Only going to print the data of course material not the course
    )
    @JoinColumn(
            name = "course_Id", //Name inside the DB table
            referencedColumnName = "courseId"   //referring to Course
    )
    private Course course;

}
