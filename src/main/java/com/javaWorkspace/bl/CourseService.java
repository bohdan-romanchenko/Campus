package com.javaWorkspace.bl;

import com.javaWorkspace.beans.Course;
import com.javaWorkspace.dao.CourseDao;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bohdan Romanchenko (nadman)
 * Date : 6/12/16.
 */
@Transactional
public class CourseService {

    @Setter CourseDao courseDao;

    @Transactional
    public Course createCourse(Course course){
        Long id = courseDao.createCourse(course);
        System.out.println("Course " + id + " : " + course.getNameCourse() + " - created");
        return course;
    }

    public void deleteCourse(Course course){
        courseDao.deleteCourse(course);
        System.out.println("Course " + course.getNameCourse() + " - deleted");
    }

    @Transactional
    public Course getCourse(Long id){
        return courseDao.getCourse(id);
    }

    @Transactional
    public Double getMiddleMarkPerCourse(Course course) throws ArithmeticException{
        Double sumOfAllMarks = 0d;
        ArrayList<Integer> allMarksPerCourse = courseDao.getAllMarksPerCourse(course);
        for (Integer a : allMarksPerCourse)
            sumOfAllMarks += a;
        return sumOfAllMarks / allMarksPerCourse.size();
    }

    @Transactional
    public Double getMiddleMarkPerYear(Integer year) throws ArithmeticException {
        Double sumOfAllMarks = 0d;
        List<Course> allCourses = courseDao.getAllCourses();
        ArrayList<Integer> allMarksPerCourse = new ArrayList<Integer>();
        for (Course course : allCourses)
            if (course.getYear().equals(year))
                allMarksPerCourse.addAll(courseDao.getAllMarksPerCourse(course));
        for (Integer a : allMarksPerCourse)
            sumOfAllMarks += a;
        return sumOfAllMarks / allMarksPerCourse.size();
    }
}
