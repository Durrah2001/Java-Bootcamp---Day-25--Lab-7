package org.example.lmslab7.Service;

import org.example.lmslab7.Model.Course;
import org.example.lmslab7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<>();


    public ArrayList getStudents(){
        return students;
    }

    public void addStudent(Student student){

        students.add(student);

    }

    public boolean updateStudent(String ID, Student student) {

        for (int i = 0; i < students.size(); i++) {

            if(students.get(i).getID().equals(ID)) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(String ID){

        for(Student s : students){
            if(s.getID().equals(ID)){
                students.remove(s);
                return true;
            }
        }
        return false;
    }


    ///////////


    public ArrayList getByAge(int age) {

        ArrayList<Student> students1 = new ArrayList<>();
        for (Student s : students) {
            if (s.getAge() == age) {
                students1.add(s);
            }
        }
        return students1;
    }


    public boolean enrollInCourse(String ID){

        for(Student s : students){

            if(!s.isHasCourse() && s.getID().equals(ID)){
                s.setHasCourse(true);
                return true;
            }
        }


        return false;

    }

    public ArrayList<Student> hasEnrolledCourse(){

        ArrayList<Student> studentHasCourse = new ArrayList<>();
        for(Student s : students){
            if(s.isHasCourse()){
                studentHasCourse.add(s);
            }
        }
        return studentHasCourse;
    }





}
