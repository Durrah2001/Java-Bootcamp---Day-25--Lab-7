package org.example.lmslab7.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.lmslab7.ApiResponse.ApiResponse;
import org.example.lmslab7.Model.Student;
import org.example.lmslab7.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/LMS/student")
@RequiredArgsConstructor
public class StudentController {

        private final StudentService studentS;

        @GetMapping("/get")
        public ResponseEntity getStudents(){

            ArrayList<Student> students = studentS.getStudents();
            return ResponseEntity.status(200).body(students);
        }

        @PostMapping("/add")
        public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){

            if(errors.hasErrors()){

                return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
            }

            studentS.addStudent(student);
            return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));

        }

        @PutMapping("/update/{ID}")
        public ResponseEntity updateStudent(@PathVariable String ID, @RequestBody @Valid Student student, Errors errors){

            if(errors.hasErrors()){
                return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
            }

            boolean isUpdated = studentS.updateStudent(ID, student);

            if(isUpdated){
                return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully!"));
            }

            return ResponseEntity.status(400).body(new ApiResponse("Student's ID not found!"));


        }

        @DeleteMapping("/delete/{ID}")
        public ResponseEntity deleteStudent(@PathVariable String ID){

            boolean isDeleted = studentS.deleteStudent(ID);

            if(isDeleted){
                return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully!"));
            }

            return ResponseEntity.status(400).body(new ApiResponse("Student with this ID not found!"));

        }

        //End CRUD

    @GetMapping("get-age/{age}")
    public ResponseEntity getByAge(@PathVariable int age){

            ArrayList<Student> students = studentS.getByAge(age);

            if(students != null){
                return ResponseEntity.status(200).body(students);
            }
            return ResponseEntity.status(400).body(new ApiResponse("No students in this age!"));

    }

    @PutMapping("/enroll-course/{ID}")
    public ResponseEntity enrollInCourse(@PathVariable String ID){

            boolean isEnrolled = studentS.enrollInCourse(ID);

            if(isEnrolled){
                return ResponseEntity.status(200).body(new ApiResponse("Student with this ID has an enrolled course now!"));
            }


            return ResponseEntity.status(400).body(new ApiResponse("Student with this ID not found!"));

    }

    @GetMapping("/has-course")
    public ResponseEntity hasEnrolledCourse(){

            ArrayList<Student> studentHasCourse = studentS.hasEnrolledCourse();

            if(studentHasCourse != null){
                return ResponseEntity.status(200).body(studentHasCourse);
            }
            return ResponseEntity.status(200).body(new ApiResponse("No student has a course yet!"));

    }













} //End controller
