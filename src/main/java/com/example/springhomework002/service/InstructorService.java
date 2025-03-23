package com.example.springhomework002.service;
import com.example.springhomework002.model.dto.request.InstructorRequest;
import com.example.springhomework002.model.entity.Instructors;
import org.springframework.stereotype.Service;
import java.util.List;

public interface InstructorService {
    public List<Instructors> getAllInstructors();
    public Instructors addNewInstructor(InstructorRequest instructorRequest);
    public Instructors deleteInstructor(int instructorId);
    public Instructors getInstructorById(int instructorId);
    public Instructors updateInstructorById(int instructorId, InstructorRequest instructorRequest);
}
