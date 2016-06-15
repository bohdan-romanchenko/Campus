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
    @Getter @Setter private Map<Course, Mark> courseList;

    public Student(String nameStudent, Map<Course, Mark> courseList) {
        this.nameStudent = nameStudent;
        this.courseList = courseList;
    }

    public Student() {
    }
}