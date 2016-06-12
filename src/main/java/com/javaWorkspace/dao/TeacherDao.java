package com.javaWorkspace.dao;

import com.javaWorkspace.beans.Teacher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bohdan Romanchenko (nadman)
 * Date : 6/12/16.
 */
public class TeacherDao {

    @Autowired
    SessionFactory sessionFactory;

    public Long createTeacher(Teacher teacher){
        return (Long) sessionFactory.getCurrentSession().save(teacher);
    }

    public void deleteTeacher(Teacher teacher){
        sessionFactory.getCurrentSession().delete(teacher);
    }

    public Teacher getTeacher(Long id){
        return sessionFactory.getCurrentSession().get(Teacher.class, id);
    }
}