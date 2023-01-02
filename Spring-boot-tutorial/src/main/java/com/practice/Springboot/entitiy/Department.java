package com.practice.Springboot.entitiy;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder    //Builder pattern-> want to use different set of prop u can create object
//Either u have to use different construction so better go with builder
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotNull(message = "Please add the department Name")
    private String departmentName;
    private String departmentAddress;

    private String departmentCode;

}
