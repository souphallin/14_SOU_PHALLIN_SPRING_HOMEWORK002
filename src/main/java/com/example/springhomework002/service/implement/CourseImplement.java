package com.example.springhomework002.service.implement;

import com.example.springhomework002.model.dto.request.CourseRequest;
import com.example.springhomework002.model.entity.Courses;
import com.example.springhomework002.repository.CourseRepository;
import com.example.springhomework002.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImplement implements CourseService {
    private final CourseRepository courseRepository;
    public CourseImplement(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    @Override
    public List<Courses> getAllCourses() {
        return courseRepository.getAllCourses();
    }
    @Override
    public Courses addNewCourse(CourseRequest courseRequest) {
        return courseRepository.addNewCourse(courseRequest);
    }
    @Override
    public Courses deleteCourse(int id) {
        System.out.println(id);
        return courseRepository.deleteCourse(id);
    }
    @Override
    public Courses updateCourse(int id, CourseRequest courseRequest) {
        return courseRepository.updateCourse(id, courseRequest);
    }
    @Override
    public Courses getCourseById(int id) {
        return courseRepository.getCourseById(id);
    }
}
