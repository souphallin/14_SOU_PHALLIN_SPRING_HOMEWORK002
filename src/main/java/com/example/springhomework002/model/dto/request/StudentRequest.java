package com.example.springhomework002.model.dto.request;

import com.example.springhomework002.model.entity.Courses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String studentEmail;
    private String studentPhone;
    private List<Integer> courseId;
}
