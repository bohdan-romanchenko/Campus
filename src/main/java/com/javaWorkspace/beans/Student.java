package com.javaWorkspace.beans;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Bohdan Romanchenko (nadman)
 * Date : 6/12/16.
 */
@Entity
@Table(name = "JW_STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    @Getter
    @Setter
    private Long id;

    @Column(name = "student_name", nullable = false)
    @Getter @Setter private String nameStudent;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Getter @Setter private Map<Integer, Course> courseList;

    public Student(String nameStudent, Map<Integer, Course> courseList) {
        this.nameStudent = nameStudent;
        this.courseList = courseList;
    }

    public Student() {
    }
}

//    CREATE TABLE INFORMATION_SCHEMA.JW_STUDENT
//        (
//        student_id INT AUTO_INCREMENT NOT NULL,
//        student_name VARCHAR(255) NOT NULL
//        );
//        CREATE UNIQUE INDEX "JW_STUDENT_student_id_uindex" ON INFORMATION_SCHEMA.JW_STUDENT (student_id);
