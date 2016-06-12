package com.javaWorkspace.dao;

import com.javaWorkspace.beans.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bohdan Romanchenko (nadman)
 * Date : 6/12/16.
 */
public class CourseDao {

    @Autowired
    SessionFactory sessionFactory;

    public Integer createCourse(Course course){
        return (Integer) sessionFactory.getCurrentSession().save(course);
    }

    public void deleteCourse(Course course){
        sessionFactory.getCurrentSession().delete(course);
    }
}
