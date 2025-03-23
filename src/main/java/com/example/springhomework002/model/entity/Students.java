package com.example.springhomework002.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    private int studentId;
    private String studentName;
    private String studentEmail;
    private String studentPhone;
    private List<Courses> courses;
}
