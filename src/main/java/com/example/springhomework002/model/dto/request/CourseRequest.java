package com.example.springhomework002.model.dto.request;

import com.example.springhomework002.model.entity.Instructors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String courseName;
    private String description;
    private Integer instructors;
}
