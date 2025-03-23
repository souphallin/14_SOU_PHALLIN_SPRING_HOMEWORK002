package com.example.springhomework002.service.implement;

import com.example.springhomework002.model.dto.request.StudentRequest;
import com.example.springhomework002.model.entity.Courses;
import com.example.springhomework002.model.entity.Students;
import com.example.springhomework002.repository.CourseRepository;
import com.example.springhomework002.repository.StudentRepository;
import com.example.springhomework002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentImplement implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentImplement(StudentRepository studentRepository, CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Students> getAllStudents(){

        System.out.println(studentRepository.getAllStudents());
        return studentRepository.getAllStudents();
    }
    @Override
    public Students addNewStudent(StudentRequest studentRequest){
        Students students = studentRepository.addNewStudent(studentRequest);

        for(Integer courseId : studentRequest.getCourseId()){
            studentRepository.addStudentToStudentCourse(students.getStudentId(), courseId);
        }

        return studentRepository.getStudentById(students.getStudentId());
    }
    @Override
    public Students getStudentById(int id){
        return studentRepository.getStudentById(id);
    }
    @Override
    public Students deleteStudentById(int id){
        return studentRepository.deleteStudentById(id);
    }
}
