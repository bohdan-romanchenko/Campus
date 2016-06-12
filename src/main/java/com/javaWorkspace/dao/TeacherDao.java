package com.javaWorkspace.dao;

import com.javaWorkspace.beans.Teacher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Bohdan Romanchenko (nadman)
 * Date : 6/12/16.
 */
@Repository
public class TeacherDao {

    @Autowired
    SessionFactory sessionFactory;

    public Integer createTeacher(Teacher teacher){
        return (Integer) sessionFactory.getCurrentSession().save(teacher);
    }

    public void deleteTeacher(Teacher teacher){
        sessionFactory.getCurrentSession().delete(teacher);
    }
}