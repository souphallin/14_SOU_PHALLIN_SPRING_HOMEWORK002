package com.example.springhomework002.repository;
import com.example.springhomework002.model.dto.request.CourseRequest;
import com.example.springhomework002.model.entity.Courses;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Select("""
        SELECT * FROM courses
    """)
    @Results(id = "getMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructors", column = "instructor_id",
                    many = @Many(select = "com.example.springhomework002.repository.InstructorRepository.getInstructorById"))
    })
    public List<Courses> getAllCourses();

    @Select("""
            insert into courses 
            values (default, #{add.courseName}, #{add.description}, #{add.instructors}) 
            returning *
    """)
    @ResultMap("getMapper")
    public Courses addNewCourse(@Param("add") CourseRequest courseRequest);

    @Select("""
        delete from courses where course_id = #{id} returning *
    """)
    @ResultMap("getMapper")
    public Courses deleteCourse(int id);

    @Select("""
        update courses set course_name = #{request.courseName}, description = #{request.description}, instructor_id = #{request.instructors} where course_id = #{id} 
        returning *;
    """)
    @ResultMap("getMapper")
    public Courses updateCourse(int id, @Param("request") CourseRequest courseRequest);

    @Select("""
        select * from courses where course_id = #{id}
    """)
    @ResultMap("getMapper")
    public Courses getCourseById(int id);

    @Select("""
        SELECT c.course_id, c.course_name, c.description, c.instructor_id  FROM courses c
            INNER JOIN student_course sc on c.course_id = sc.course_id
            WHERE student_id = #{id}
    """)
    @ResultMap("getMapper")
    public List<Courses> getCourseByStudentId(int id);
}
