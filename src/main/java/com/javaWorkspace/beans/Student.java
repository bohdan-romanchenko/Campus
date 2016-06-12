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
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    @Getter
    @Setter
    private Long id;

    @Column(name = "student_name", nullable = false)
    @Getter @Setter private String nameCourse;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "studentList")
    @Getter @Setter private List<Course> courseList;

    public Student(String nameCourse, List<Course> courseList) {
        this.nameCourse = nameCourse;
        this.courseList = courseList;
    }
}
