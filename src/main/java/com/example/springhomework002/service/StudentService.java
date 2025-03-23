package com.example.springhomework002.service;
import com.example.springhomework002.model.dto.request.StudentRequest;
import com.example.springhomework002.model.entity.Students;

import java.util.List;

public interface StudentService {
    List<Students> getAllStudents();
    Students addNewStudent(StudentRequest studentRequest);
    Students getStudentById(int id);
    Students deleteStudentById(int id);
    Students updateStudentById(int id, StudentRequest studentRequest);
}
