package com.example.springhomework002.service.implement;

import com.example.springhomework002.model.dto.request.InstructorRequest;
import com.example.springhomework002.model.entity.Instructors;
import com.example.springhomework002.repository.InstructorRepository;
import com.example.springhomework002.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorImplement implements InstructorService {
    private final InstructorRepository instructorRepository;
    public InstructorImplement(InstructorRepository instructorRepository){
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructors> getAllInstructors(){
        return instructorRepository.getAllInstructors();
    }
    @Override
    public Instructors addNewInstructor(InstructorRequest instructorRequest){
        return instructorRepository.addNewInstructor(instructorRequest);
    }
    @Override
    public Instructors deleteInstructor(int instructorId){
        return instructorRepository.deleteInstructor(instructorId);
    }
    @Override
    public Instructors getInstructorById(int instructorId){
        return instructorRepository.getInstructorById(instructorId);
    }
    @Override
    public Instructors updateInstructorById(int instructorId, InstructorRequest instructorRequest){
        return instructorRepository.updateInstructorById(instructorId, instructorRequest);
    }
}
