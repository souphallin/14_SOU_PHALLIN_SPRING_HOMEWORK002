package com.example.springhomework002.repository;
import com.example.springhomework002.model.dto.request.InstructorRequest;
import com.example.springhomework002.model.entity.Instructors;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface InstructorRepository {
    @Select("""
        SELECT * FROM instructors
    """)
    @Results(id = "getMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
            @Result(property = "instructorEmail", column = "email")
    })
    public List<Instructors> getAllInstructors();

    @Select("""
        INSERT INTO instructors VALUES (DEFAULT, #{add.instructorName}, #{add.instructorEmail} ) returning *
    """)
    @ResultMap("getMapper")
    public Instructors addNewInstructor(@Param("add") InstructorRequest instructorRequest);

    @Select("""
        DELETE FROM instructors WHERE instructor_id = #{instructorId} RETURNING *
    """)
    @ResultMap("getMapper")
    public Instructors deleteInstructor(@Param("instructorId") int instructorId);

    @Select("""
        SELECT * FROM instructors WHERE instructor_id = #{instructorId}
    """)
    @ResultMap("getMapper")
    public Instructors getInstructorById(int instructorId);

    @Select("""
        update instructors set instructor_name = #{request.instructorName}, email = #{request.instructorEmail}
                           where instructor_id = #{instructorId} RETURNING *
    """)
    @ResultMap("getMapper ")
    public Instructors updateInstructorById(@Param("instructorId") int instructorId, @Param("request") InstructorRequest instructorRequest);
}
