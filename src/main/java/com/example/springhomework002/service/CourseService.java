package com.example.springhomework002.service;

import com.example.springhomework002.model.dto.request.CourseRequest;
import com.example.springhomework002.model.entity.Courses;

import java.util.List;

public interface CourseService {
    public List<Courses> getAllCourses();
    public Courses addNewCourse(CourseRequest courseRequest);
    public Courses deleteCourse(int id);
    public Courses updateCourse(int id, CourseRequest courseRequest);
    public Courses getCourseById(int id);
}
