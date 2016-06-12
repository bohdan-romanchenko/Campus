package com.javaWorkspace.dao;

import com.javaWorkspace.beans.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bohdan Romanchenko (nadman)
 * Date : 6/12/16.
 */
public class StudentDao {

    @Autowired
    SessionFactory sessionFactory;

    public Long createStudent(Student student){
        return (Long) sessionFactory.getCurrentSession().save(student);
    }

    public void deleteStudent(Student student){
        sessionFactory.getCurrentSession().delete(student);
    }

}
