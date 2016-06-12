package com.javaWorkspace.bl;

import com.javaWorkspace.beans.Course;
import com.javaWorkspace.dao.CourseDao;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Bohdan Romanchenko (nadman)
 * Date : 6/12/16.
 */
@Transactional
public class CourseService {

    @Setter CourseDao courseDao;

    @Transactional
    public Course createCourse(Course course){
        Integer id = courseDao.createCourse(course);
        System.out.println("Course " + id + " : " + course.getNameCourse() + " - created");
        return course;
    }

    public void deleteCourse(Course course){
        courseDao.deleteCourse(course);
        System.out.println("Course " + course.getNameCourse() + " - deleted");
    }

}
