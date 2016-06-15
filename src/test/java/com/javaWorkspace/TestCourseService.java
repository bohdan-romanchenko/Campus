package com.javaWorkspace;

import com.javaWorkspace.beans.Course;
import com.javaWorkspace.beans.Student;
import com.javaWorkspace.beans.Teacher;
import com.javaWorkspace.bl.CourseService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static java.lang.Double.NaN;

/**
 * Created by Bohdan Romanchenko (nadman)
 * Date : 6/13/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springConfig.xml"})
public class TestCourseService {
//
//    CourseService courseService;
//
//    private Student student1;
//    private Student student2;
//    private Student student3;
//    private Student student4;
//    private Student student5;
//    private Student student6;
//    private Student student7;
//
//    private Teacher teacher1;
//    private Teacher teacher2;
//    private Teacher teacher3;
//    private Teacher teacher4;
//    private Teacher teacher5;
//
//    private Course course1;
//    private Course course2;
//    private Course course3;
//    private Course course4;
//
//    @Test
//    public void addCourse(){
//        Course courseServiceCourse1 = courseService.createCourse(course1);
//        Assert.assertNotNull(courseServiceCourse1);
//    }
//
//    @Test
//    public void deleteCourse(){
//        Assert.assertNotNull(courseService.getCourse(1L));
//        courseService.deleteCourse(course2);
//        Course course = courseService.getCourse(1L);
//        Assert.assertNull(course);
//    }
//
//    @Test
//    public void getCourse(){
//        Course courseNull = courseService.getCourse(10L);
//        Assert.assertNull(courseNull);
//
//        Course course = courseService.getCourse(1L);
//
//        int year = course.getYear();
//        Assert.assertEquals(2016, year);
//
//        String name = course.getNameCourse();
//        Assert.assertEquals(name, "course2");
//
//        Map<Integer, Student> studentList = course.getStudentList();
//        Collection<Student> students = studentList.values();
//        for (Student student : students)
//            Assert.assertTrue(student.getNameStudent().contains("student"));
//
//        List<Teacher> teacherList = course.getTeacherList();
//        for (Teacher teacher : teacherList){
//            Assert.assertTrue(teacher.getNameTeacher().contains("teacher"));
//            Assert.assertTrue(teacher.getEducation().contains("education"));
//        }
//    }
//
//    @Test
//    public void getMiddleMarkPerCourse(){
//        double middleMarkPerCourse1 = courseService.getMiddleMarkPerCourse(course2);
//        Assert.assertEquals(76, middleMarkPerCourse1, 0.0001);
//
//        double middleMarkPerCourse2 = courseService.getMiddleMarkPerCourse(course3);
//        Assert.assertEquals(66.5, middleMarkPerCourse2, 0.0001);
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void getMiddleMarkPerCourseNull(){
//        courseService.getMiddleMarkPerCourse(course4);   //because there are no students on course4
//    }
//
//    @Before
//    public void before(){
//        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:springConfig.xml"});
//        courseService = (CourseService) context.getBean("courseService");
//        course1 = new Course();
//        course1.setYear(2015);
//        course1.setNameCourse("course1");
//
//        course2 = new Course();
//        course2.setYear(2016);
//        course2.setNameCourse("course2");
//
//        course3 = new Course();
//        course3.setYear(2016);
//        course3.setNameCourse("course3");
//
//        course4 = new Course();
//        course4.setYear(2017);
//        course4.setNameCourse("course4");
//
//        teacher1 = new Teacher();
//        teacher1.setNameTeacher("teacher1");
//        teacher1.setEducation("education1");
//        List<Course> teacher1Courses = new ArrayList<Course>();
//        teacher1Courses.add(course1);
//
//        teacher2 = new Teacher();
//        teacher2.setNameTeacher("teacher2");
//        teacher2.setEducation("education2");
//        List<Course> teacher2Courses = new ArrayList<Course>();
//        teacher2Courses.add(course2);
//
//        teacher3 = new Teacher();
//        teacher3.setNameTeacher("teacher3");
//        teacher3.setEducation("education3");
//        List<Course> teacher3Courses = new ArrayList<Course>();
//        teacher3Courses.add(course3);
//        teacher3Courses.add(course1);
//
//        teacher4 = new Teacher();
//        teacher4.setNameTeacher("teacher4");
//        teacher4.setEducation("education4");
//        List<Course> teacher4Courses = new ArrayList<Course>();
//        teacher4Courses.add(course2);
//
//        teacher5 = new Teacher();
//        teacher5.setNameTeacher("teacher5");
//        teacher5.setEducation("education5");
//        List<Course> teacher5Courses = new ArrayList<Course>();
//        teacher5Courses.add(course1);
//        teacher5Courses.add(course2);
//
//        teacher1.setCourseList(teacher1Courses);
//        teacher2.setCourseList(teacher2Courses);
//        teacher3.setCourseList(teacher3Courses);
//        teacher4.setCourseList(teacher4Courses);
//        teacher5.setCourseList(teacher5Courses);
//
//        student1 = new Student();
//        student1.setNameStudent("student1");
//        Map<Integer, Course> student1Courses = new IdentityHashMap<Integer, Course>();
//        student1Courses.put(90, course1);
//        student1Courses.put(73, course2);
//
//        student2 = new Student();
//        student2.setNameStudent("student2");
//        Map<Integer, Course> student2Courses = new IdentityHashMap<Integer, Course>();
//        student1Courses.put(70, course2);
//        student1Courses.put(63, course3);
//
//        student3 = new Student();
//        student3.setNameStudent("student3");
//        Map<Integer, Course> student3Courses = new IdentityHashMap<Integer, Course>();
//        student1Courses.put(98, course1);
//        student1Courses.put(75, course2);
//
//        student4 = new Student();
//        student4.setNameStudent("student4");
//        Map<Integer, Course> student4Courses = new IdentityHashMap<Integer, Course>();
//        student1Courses.put(60, course1);
//        student1Courses.put(63, course3);
//
//        student5 = new Student();
//        student5.setNameStudent("student5");
//        Map<Integer, Course> student5Courses = new IdentityHashMap<Integer, Course>();
//        student1Courses.put(74, course3);
//        student1Courses.put(79, course2);
//
//        student6 = new Student();
//        student6.setNameStudent("student6");
//        Map<Integer, Course> student6Courses = new IdentityHashMap<Integer, Course>();
//        student1Courses.put(93, course1);
//        student1Courses.put(83, course2);
//
//        student7 = new Student();
//        student7.setNameStudent("student7");
//        Map<Integer, Course> student7Courses = new Map<Integer, Course>() {
//            public int size() {
//                return 0;
//            }
//
//            public boolean isEmpty() {
//                return false;
//            }
//
//            public boolean containsKey(Object key) {
//                return false;
//            }
//
//            public boolean containsValue(Object value) {
//                return false;
//            }
//
//            public Course get(Object key) {
//                return null;
//            }
//
//            public Course put(Integer key, Course value) {
//                return null;
//            }
//
//            public Course remove(Object key) {
//                return null;
//            }
//
//            public void putAll(Map<? extends Integer, ? extends Course> m) {
//
//            }
//
//            public void clear() {
//
//            }
//
//            public Set<Integer> keySet() {
//                return null;
//            }
//
//            public Collection<Course> values() {
//                return null;
//            }
//
//            public Set<Entry<Integer, Course>> entrySet() {
//                return null;
//            }
//        };
//        student1Courses.put(100, course1);
//        student1Courses.put(66, course3);
//
//        student1.setCourseList(student1Courses);
//        student2.setCourseList(student2Courses);
//        student3.setCourseList(student3Courses);
//        student4.setCourseList(student4Courses);
//        student5.setCourseList(student5Courses);
//        student6.setCourseList(student6Courses);
//        student7.setCourseList(student7Courses);
//
//        Map<Integer, Student> course1Students = new IdentityHashMap<Integer, Student>();
//        course1Students.put(90, student1);
//        course1Students.put(98, student3);
//        course1Students.put(60, student4);
//        course1Students.put(93, student6);
//        course1Students.put(100, student7);
//        List<Teacher> course1Teachers = new ArrayList<Teacher>();
//        course1Teachers.add(teacher1);
//        course1Teachers.add(teacher3);
//        course1Teachers.add(teacher5);
//
//        Map<Integer, Student> course2Students = new IdentityHashMap<Integer, Student>();
//        course2Students.put(73, student1);
//        course2Students.put(70, student2);
//        course2Students.put(75, student3);
//        course2Students.put(79, student5);
//        course2Students.put(83, student6);
//        List<Teacher> course2Teachers = new ArrayList<Teacher>();
//        course2Teachers.add(teacher2);
//        course2Teachers.add(teacher4);
//        course2Teachers.add(teacher5);
//
//        Map<Integer, Student> course3Students = new Map<Integer, Student>() {
//            public int size() {
//                return 0;
//            }
//
//            public boolean isEmpty() {
//                return false;
//            }
//
//            public boolean containsKey(Object key) {
//                return false;
//            }
//
//            public boolean containsValue(Object value) {
//                return false;
//            }
//
//            public Student get(Object key) {
//                return null;
//            }
//
//            public Student put(Integer key, Student value) {
//                return null;
//            }
//
//            public Student remove(Object key) {
//                return null;
//            }
//
//            public void putAll(Map<? extends Integer, ? extends Student> m) {
//
//            }
//
//            public void clear() {
//
//            }
//
//            public Set<Integer> keySet() {
//                return null;
//            }
//
//            public Collection<Student> values() {
//                return null;
//            }
//
//            public Set<Entry<Integer, Student>> entrySet() {
//                return null;
//            }
//        };
//        course3Students.put(63, student2);
//        course3Students.put(63, student4);
//        course3Students.put(74, student5);
//        course3Students.put(66, student7);
//        List<Teacher> course3Teachers = new ArrayList<Teacher>();
//        course3Teachers.add(teacher3);
//
//        course1.setStudentList(course1Students);
//        course2.setStudentList(course2Students);
//        course3.setStudentList(course3Students);
//
//        course1.setTeacherList(course1Teachers);
//        course2.setTeacherList(course2Teachers);
//        course3.setTeacherList(course3Teachers);
//
//        courseService.createCourse(course2);
//
//    }
//
}
