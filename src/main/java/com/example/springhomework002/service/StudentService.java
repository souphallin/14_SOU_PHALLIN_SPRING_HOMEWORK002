package com.example.springhomework002.service;
import com.example.springhomework002.model.dto.request.StudentRequest;
import com.example.springhomework002.model.entity.Students;

import java.util.List;

public interface StudentService {
    public List<Students> getAllStudents();
    public Students addNewStudent(StudentRequest studentRequest);
    public Students getStudentById(int id);
    public Students deleteStudentById(int id);
}
