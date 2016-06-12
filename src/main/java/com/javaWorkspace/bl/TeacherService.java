package com.javaWorkspace.bl;

import com.javaWorkspace.beans.Teacher;
import com.javaWorkspace.dao.TeacherDao;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Bohdan Romanchenko (nadman)
 * Date : 6/12/16.
 */
@Transactional
public class TeacherService {
    @Setter
    TeacherDao teacherDao;

    @Transactional
    public Teacher createTeacher(Teacher student){
        Long id = teacherDao.createTeacher(student);
        System.out.println("Teacher " + id + " : " + student.getNameTeacher() + " - created");
        return student;
    }

    public void deleteTeacher(Teacher student){
        teacherDao.deleteTeacher(student);
        System.out.println("Teacher " + student.getNameTeacher() + " - deleted");
    }

}
