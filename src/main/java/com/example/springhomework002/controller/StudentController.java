package com.example.springhomework002.controller;

import com.example.springhomework002.model.dto.request.StudentRequest;
import com.example.springhomework002.model.dto.response.ApiResponse;
import com.example.springhomework002.model.entity.Students;
import com.example.springhomework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Stream.builder;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<ApiResponse<List<Students>>> getAllStudents(){

//        ApiResponse<List<Students>> response = ApiResponse.<List<Students>>
        ApiResponse<List<Students>> response = ApiResponse.<List<Students>>builder()
                .message("Get All Students Success!!!")
                .payload(studentService.getAllStudents())
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("/addNewStudent")
    public ResponseEntity<ApiResponse<Students>> addNewStudent(@RequestBody StudentRequest studentRequest){
        ApiResponse<Students> response = ApiResponse.<Students>builder()
                .message("Add Student Successful!!!")
                .payload(studentService.addNewStudent(studentRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Students>> getStudentById(@PathVariable int id){
        ApiResponse<Students> response = ApiResponse.<Students>builder()
                .message("Get Student Successful!!!")
                .payload(studentService.getStudentById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Students>> deleteStudentById(@PathVariable int id){
        ApiResponse<Students> response = ApiResponse.<Students>builder()
                .message("Delete Student Successful!!!")
                .payload(studentService.deleteStudentById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Students>> updateStudentById(@PathVariable int id, @RequestBody StudentRequest studentRequest){
        ApiResponse<Students> response = ApiResponse.<Students>builder()
                .message("Update Student Successful!!!")
                .payload(studentService.updateStudentById(id, studentRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
