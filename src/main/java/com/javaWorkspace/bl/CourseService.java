package com.javaWorkspace.bl;

import com.javaWorkspace.beans.Course;
import com.javaWorkspace.beans.Mark;
import com.javaWorkspace.dao.CourseDao;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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

    private ArrayList<Double> getAllMarksPerCourse(Course course){
        ArrayList<Double> returnList = new ArrayList<Double>();
        Collection<Mark> marks = course.getStudentList().values();
        for (Mark mark : marks) returnList.add(mark.getValue());
        return returnList;
    }

    @Transactional
    public Double getMiddleMarkPerCourse(Course course) throws ArithmeticException{
        Double sumOfAllMarks = 0d;
        ArrayList<Double> allMarksPerCourse = getAllMarksPerCourse(course);
        for (Double a : allMarksPerCourse)
            sumOfAllMarks += a;
        return sumOfAllMarks / allMarksPerCourse.size();
    }

    @Transactional
    public Double getMiddleMarkPerYear(Integer year) throws ArithmeticException {
        Double sumOfAllMarks = 0d;
        List<Course> allCourses = courseDao.getAllCourses();
        ArrayList<Double> allMarksPerCourse = new ArrayList<Double>();
        for (Course course : allCourses)
            if (course.getYear().equals(year))
                allMarksPerCourse.addAll(getAllMarksPerCourse(course));
        for (Double a : allMarksPerCourse)
            sumOfAllMarks += a;
        return sumOfAllMarks / allMarksPerCourse.size();
    }
}
