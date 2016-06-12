package com.javaWorkspace.bl;

import com.javaWorkspace.beans.Student;
import com.javaWorkspace.dao.StudentDao;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Bohdan Romanchenko (nadman)
 * Date : 6/12/16.
 */
@Transactional
public class StudentService {

    @Setter
    StudentDao studentDao;

    @Transactional
    public Student createStudent(Student student){
        Long id = studentDao.createStudent(student);
        System.out.println("Student " + id + " : " + student.getNameStudent() + " - created");
        return student;
    }

    public void deleteStudent(Student student){
        studentDao.deleteStudent(student);
        System.out.println("Student " + student.getNameStudent() + " - deleted");
    }

}
