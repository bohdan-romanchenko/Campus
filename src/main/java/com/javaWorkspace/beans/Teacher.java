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
@Table(name = "TEACHER")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    @Getter
    @Setter
    private Long id;

    @Column(name = "teacher_name", nullable = false)
    @Getter @Setter private String nameCourse;

    @Column(name = "teacher_education")
    @Getter @Setter private String education;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacherList")
    @Getter @Setter private List<Course> courseList;

    public Teacher(String nameCourse, String education, List<Course> courseList) {
        this.nameCourse = nameCourse;
        this.education = education;
        this.courseList = courseList;
    }
}
