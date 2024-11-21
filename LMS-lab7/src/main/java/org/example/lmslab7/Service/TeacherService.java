package org.example.lmslab7.Service;

import org.example.lmslab7.Model.Course;
import org.example.lmslab7.Model.Student;
import org.example.lmslab7.Model.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {


    ArrayList<Teacher> teachers = new ArrayList<>();


    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }


    public boolean updateTeacher(String ID, Teacher teacher) {

        for (int i = 0; i < teachers.size(); i++) {

            if(teachers.get(i).getID().equals(ID)) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(String ID) {

        for (Teacher t : teachers) {
            if (t.getID().equals(ID)) {
                teachers.remove(t);
                return true;
            }
        }
        return false;
    }


    public ArrayList<Teacher> getBySpecificCourse(String course) {

        ArrayList<Teacher> basedCourse = new ArrayList<>();
        for (Teacher t : teachers) {
            if (t.getCourse().equalsIgnoreCase(course)) {
                basedCourse.add(t);
            }
        }
        return basedCourse;
    }

    public String classifyByYears(String ID) {
        for (Teacher t : teachers) {
            if (t.getID().equals(ID)) {
                if (t.getExperienceYears() < 2) {
                    return "Beginner";
                } else if (t.getExperienceYears() >= 2 && t.getExperienceYears() <= 5) {
                    return "Intermediate";
                } else {
                    return "Expert";
                }
            }
        }
        return null;
    }


    public ArrayList<Teacher> getExpertTeacher(){

        ArrayList<Teacher> teachersExpert = new ArrayList<>();
        for(Teacher t : teachers){

            if( t.getExperienceYears() > 5){
                teachersExpert.add(t);
            }
        }

        return teachersExpert;

    }







}



