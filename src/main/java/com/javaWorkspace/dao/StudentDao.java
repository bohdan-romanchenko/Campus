package com.javaWorkspace.dao;

import com.javaWorkspace.beans.Course;
import com.javaWorkspace.beans.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Bohdan Romanchenko (nadman)
 * Date : 6/12/16.
 */
@Repository
public class StudentDao {

    @Autowired
    SessionFactory sessionFactory;

    public Integer createStudent(Student student){
        return (Integer) sessionFactory.getCurrentSession().save(student);
    }

    public void deleteStudent(Student student){
        sessionFactory.getCurrentSession().delete(student);
    }

}
