package com.javaWorkspace.beans;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Bohdan Romanchenko (nadman)
 * Date : 6/12/16.
 */
@Entity
@Table(name = "JW_COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    @Getter @Setter private Long id;

    @Column(name = "course_name", nullable = false)
    @Getter @Setter private String nameCourse;

    @Column(name = "course_year", nullable = false)
    @Getter @Setter private String year;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "courseList")
    @Getter @Setter private List<Student> studentList;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "courseList")
    @Getter @Setter private List<Teacher> teacherList;

    public Course(String nameCourse, String year, List<Student> studentList, List<Teacher> teacherList) {
        this.nameCourse = nameCourse;
        this.year = year;
        this.studentList = studentList;
        this.teacherList = teacherList;
    }

    public Course() {
    }
}

//    CREATE TABLE INFORMATION_SCHEMA.JW_COURSE
//        (
//        course_id INT AUTO_INCREMENT NOT NULL,
//        course_name VARCHAR(255) NOT NULL,
//        course_year VARCHAR(255) NOT NULL
//        );
//        CREATE UNIQUE INDEX "JW_COURSE_course_id_uindex" ON INFORMATION_SCHEMA.JW_COURSE (course_id);
