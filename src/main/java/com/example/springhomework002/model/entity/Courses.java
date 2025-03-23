package com.example.springhomework002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    private int courseId;
    private String courseName;
    private String description;
    private Instructors instructors;
}
