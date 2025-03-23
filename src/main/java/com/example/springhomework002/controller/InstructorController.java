package com.example.springhomework002.controller;

import com.example.springhomework002.model.dto.request.InstructorRequest;
import com.example.springhomework002.model.dto.response.ApiResponse;
import com.example.springhomework002.model.entity.Instructors;
import com.example.springhomework002.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;
    public InstructorController(InstructorService instructorService){
        this.instructorService = instructorService;
    }

    @GetMapping("/getAllInstructors")
    public ResponseEntity<ApiResponse<List<Instructors>>> getAllInstructors(){
        ApiResponse<List<Instructors>> response = ApiResponse.<List<Instructors>>builder()
                .message("Get All Instructors Successful!!!")
                .payload(instructorService.getAllInstructors())
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("/addNewInstructor")
    public ResponseEntity<ApiResponse<Instructors>> addNewInstructor(@RequestBody InstructorRequest instructorRequest){
        ApiResponse<Instructors> response = ApiResponse.<Instructors>builder()
                .message("Add New Instructor Successful!!!")
                .payload(instructorService.addNewInstructor(instructorRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructors>> deleteInstructor(@PathVariable int id){
//        for (Instructors instructor : instructorService.getAllInstructors()) {
//            if (instructor.getInstructorId() == id) {
//                instructorService.getAllInstructors().remove(instructor);
                ApiResponse<Instructors> response = ApiResponse.<Instructors>builder()
                        .message("Delete Instructor Successful!!!")
                        .payload(instructorService.deleteInstructor(id))
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build();
                return ResponseEntity.status(HttpStatus.OK).body(response);
//            }
//        }
//        ApiResponse<Instructors> response = ApiResponse.<Instructors>builder()
//                .message("Delete Instructor Failed!!!")
//                .payload(null)
//                .status(HttpStatus.NOT_FOUND)
//                .timestamp(LocalDateTime.now())
//                .build();
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @GetMapping("/{id}")
    public ApiResponse<Instructors> getInstructorById(@PathVariable int id){
        return ApiResponse.<Instructors>builder()
                .message("Get Instructor by ID Successful!!!")
                .payload(instructorService.getInstructorById(id))
                .status(HttpStatus.OK)
                .build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructors>> updateInstructorById(@PathVariable int id, @RequestBody InstructorRequest instructorRequest){
        ApiResponse<Instructors> response = ApiResponse.<Instructors>builder()
                .message("Update Instructor Successful!!!")
                .payload(instructorService.updateInstructorById(id, instructorRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
