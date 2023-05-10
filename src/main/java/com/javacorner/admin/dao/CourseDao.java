package com.javacorner.admin.dao;

import com.javacorner.admin.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseDao extends JpaRepository<Course, Long> {

    List<Course> findCourseByCourseNameContains(String keyword);

    @Query(value = "select * from courses as c where c.course_id in (select e.course_id from enrolled_in as e where e.stydent_id=:studentId)",nativeQuery = true)
    List<Course> getCourseByStudentId(@Param("studentId") Long student_id);
}
