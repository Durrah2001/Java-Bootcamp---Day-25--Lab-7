package org.example.lmslab7.Service;

import org.example.lmslab7.Model.Course;
import org.example.lmslab7.Model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class CourseService {

    ArrayList<Course> courses = new ArrayList<Course>();



    public ArrayList getCourses(){
        return courses;
    }

    public void addCourse(Course course){

        courses.add(course);

    }

    public boolean updateCourse(String ID, Course course) {

        for (int i = 0; i < courses.size(); i++) {

            if(courses.get(i).getID().equals(ID)) {
                courses.set(i, course);
                return true;
            }

        }
        return false;
    }

    public boolean deleteCourse(String ID){

        for(Course c : courses){
            if(c.getID().equals(ID)){
                courses.remove(c);
                return true;
            }
        }
        return false;
    }


    public ArrayList<Course> searchByTeacher(String name){
ArrayList<Course> courses1 = new ArrayList<>();
        for(Course c : courses){
            if(c.getCourseTeacher().equalsIgnoreCase(name)){
                courses1.add(c);
                return courses1;
            }
        }
        return null;
    }


    //////////////////////////

    public boolean enrollStudent(String ID ) {
        for (Course course : courses) {
            if (course.getID().equals(ID)) {
                course.setHasEnrolledStudent(true);
                return true;
            }
        }
        return false;
    }


    ///////////////////////

    public ArrayList<Course> courseHasEnrolledStudent (){

        ArrayList<Course> coursesBasedEnrolled = new ArrayList<>();
        for(Course c : courses){

            if(c.isHasEnrolledStudent()){
                coursesBasedEnrolled.add(c);
                return coursesBasedEnrolled;
            }
        }
        return null;
    }









}
