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
@Table(name = "JW_COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    @Getter @Setter private Long id;

    @Column(name = "course_name", nullable = false)
    @Getter @Setter private String nameCourse;

    @Column(name = "course_year", nullable = false)
    @Getter @Setter private Integer year;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "JW_STUDENT_COURSE_MARK",
            joinColumns = @JoinColumn(name = "COURSE_ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    @MapKeyJoinColumn(name = "MARK")
    @Getter @Setter private Map<Integer, Student> studentList;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "courseList")
    @Getter @Setter private List<Teacher> teacherList;

    public Course(String nameCourse, Integer year, Map<Integer, Student> studentList, List<Teacher> teacherList) {
        this.nameCourse = nameCourse;
        this.year = year;
        this.studentList = studentList;
        this.teacherList = teacherList;
    }

    public Course() {
    }
}