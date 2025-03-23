package com.example.springhomework002.repository;

import com.example.springhomework002.model.dto.request.StudentRequest;
import com.example.springhomework002.model.entity.Students;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("""
        SELECT * FROM students
    """)
    @Results(id= "getMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentEmail", column = "email"),
            @Result(property = "studentPhone", column = "phone_number"),
            @Result(property = "courses", column = "student_id",
                    many = @Many(select = "com.example.springhomework002.repository.CourseRepository.getCourseByStudentId"))
    })
    List<Students> getAllStudents();

    @Select("""
        insert into students 
        values (default, #{request.studentName}, #{request.studentEmail}, #{request.studentPhone}) 
        RETURNING *
    """)
    @ResultMap("getMapper")
    Students addNewStudent(@Param("request") StudentRequest studentRequest);

    @Insert("""
        insert into student_course values (default, #{studentId}, #{courseId})
    """)
    void addStudentToStudentCourse(@Param("studentId") int studentId, @Param("courseId") int courseId);

    @Select("""
        SELECT * FROM students WHERE student_id = #{id}
    """)
    @ResultMap("getMapper")
    Students getStudentById(@Param("id") Integer id);

    @Select("""
        delete from students where student_id = #{id} returning *
    """)
    @ResultMap("getMapper")
    Students deleteStudentById(@Param("id") Integer id);

    @Select("""
        update students 
        set student_name = #{request.studentName}, email = #{request.studentEmail}, phone_number = #{request.studentPhone} 
        where student_id = #{id} returning *
    """)
    @ResultMap("getMapper")
    Students updateStudent(int id, @Param("request") StudentRequest student);
}
