package com.example.springhomework002.controller;

import com.example.springhomework002.model.dto.request.CourseRequest;
import com.example.springhomework002.model.dto.response.ApiResponse;
import com.example.springhomework002.model.entity.Courses;
import com.example.springhomework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }
    @GetMapping("/getAllCourses")
    public ResponseEntity<ApiResponse<List<Courses>>> getAllCourses(){
        ApiResponse<List<Courses>> response = ApiResponse.<List<Courses>>builder()
                .message("Get All Courses Successful!!!")
                .payload(courseService.getAllCourses())
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("/addNewCourse")
    public ResponseEntity<ApiResponse<Courses>> addNewCourse(@RequestBody CourseRequest courseRequest){
        ApiResponse<Courses> response = ApiResponse.<Courses>builder()
                .message("Add New Course Successful!!!")
                .payload(courseService.addNewCourse(courseRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Courses> deleteCourse(@PathVariable int id){
        ApiResponse<Courses> response = ApiResponse.<Courses>builder()
                .message("Delete Course Successful!!!")
                .payload(courseService.deleteCourse(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response.getPayload());
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Courses>> updateCourse(@PathVariable int id, @RequestBody CourseRequest courseRequest){
        ApiResponse<Courses> response = ApiResponse.<Courses>builder()
                .message("Update Course Successful!!!")
                .payload(courseService.updateCourse(id, courseRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Courses>> getCourseById(@PathVariable int id){
        ApiResponse<Courses> response = ApiResponse.<Courses>builder()
                .message("Get Course Successful!!!")
                .payload(courseService.getCourseById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
