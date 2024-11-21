package org.example.lmslab7.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lmslab7.ApiResponse.ApiResponse;
import org.example.lmslab7.Model.Course;
import org.example.lmslab7.Model.Student;
import org.example.lmslab7.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/LMS/course")
@RequiredArgsConstructor
public class CourseController {


    private final CourseService courseS;

    @GetMapping("/get")
    public ResponseEntity getCourse(){
        ArrayList<Course> courses= courseS.getCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course, Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        courseS.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully!"));


    }

    @PutMapping("/update/{ID}")
    public ResponseEntity updateCourse(@PathVariable String ID, @RequestBody @Valid Course course, Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        boolean isUpdated = courseS.updateCourse(ID, course);

        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully!"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Course's ID not found!"));


    }

    @DeleteMapping("/delete/{ID}")
    public ResponseEntity deleteCourse(@PathVariable String ID){

        boolean isDeleted = courseS.deleteCourse(ID);

        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully!"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Course with this ID not found!"));

    }

    //End CRUD


    @GetMapping("/search-teacher/{name}")
    public ResponseEntity searchByTeacher(@PathVariable String name){

        ArrayList<Course> courses = courseS.searchByTeacher(name);

        if(courses != null){
            return ResponseEntity.status(200).body(courses);
        }
        return ResponseEntity.status(400).body("Teacher's name not found!");

    }


    @PutMapping("enroll-student/{ID}")

    public ResponseEntity enrollStudent(@PathVariable String ID) {  //Course ID

        boolean isEnroll = courseS.enrollStudent(ID);

        if (isEnroll) {
            return ResponseEntity.status(200).body(new ApiResponse("This course has enrolled student now!"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("This Course's ID not found!"));
    }

    @GetMapping("/hasEnrolled")
    public ResponseEntity courseHasEnrolledStudent(){


        ArrayList<Course> courses = courseS.courseHasEnrolledStudent();

        if(courses != null){
            return ResponseEntity.status(200).body(courses);
        }

        return ResponseEntity.status(400).body(new ApiResponse("No course has enrolled students !"));
    }











}//End controller
