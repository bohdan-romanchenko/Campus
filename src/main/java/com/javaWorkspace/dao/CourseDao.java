package com.javaWorkspace.dao;

import com.javaWorkspace.beans.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by Bohdan Romanchenko (nadman)
 * Date : 6/12/16.
 */
public class CourseDao {

    @Autowired
    SessionFactory sessionFactory;

    public Long createCourse(Course course){
        return (Long) sessionFactory.getCurrentSession().save(course);
    }

    public void deleteCourse(Course course){
        sessionFactory.getCurrentSession().delete(course);
    }

    public Course getCourse(Long id){
        return sessionFactory.getCurrentSession().get(Course.class, id);
    }

    public List<Course> getAllCourses(){
        return sessionFactory.getCurrentSession().createCriteria(Course.class).list();
    }

    public ArrayList<Integer> getAllMarksPerCourse(Course course){
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        Set<Integer> marks = course.getStudentList().keySet();
        for (Integer mark : marks) returnList.add(mark);
        return returnList;
    }
}
