package org.example.lmslab7.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lmslab7.ApiResponse.ApiResponse;
import org.example.lmslab7.Model.Student;
import org.example.lmslab7.Model.Teacher;
import org.example.lmslab7.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/LMS/teacher")
@RequiredArgsConstructor
public class TeacherController {


      private final TeacherService teacherS;

      @GetMapping("/get")
      public ResponseEntity getTeachers(){
          ArrayList<Teacher> teachers = teacherS.getTeachers();
          return ResponseEntity.status(200).body(teachers);
      }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){

        if(errors.hasErrors()){

            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        teacherS.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added successfully"));

    }

    @PutMapping("/update/{ID}")
    public ResponseEntity updateTeacher(@PathVariable String ID, @RequestBody @Valid Teacher teacher, Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        boolean isUpdated = teacherS.updateTeacher(ID, teacher);

        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Teacher updated successfully!"));
        }

        return ResponseEntity.status(400).body(new ApiResponse("Teacher's ID not found!"));


    }


    @DeleteMapping("/delete/{ID}")
    public ResponseEntity deleteTeacher(@PathVariable String ID){

          boolean isDeleted = teacherS.deleteTeacher(ID);

          if(isDeleted){
              return ResponseEntity.status(200).body(new ApiResponse("Teacher with this ID deleted successfully!"));
          }

          return ResponseEntity.status(400).body(new ApiResponse("Teacher with this ID not found!"));

    }





    //End CRUD
    @GetMapping("/getByCourse/{course}")
    public ResponseEntity getBySpecificCourse(@PathVariable String course){

        ArrayList<Teacher> teachersBasedCourse = teacherS.getBySpecificCourse(course);

        if(teachersBasedCourse != null){
            return ResponseEntity.status(200).body(teachersBasedCourse);
        }
        return ResponseEntity.status(400).body(new ApiResponse("There is no teacher has this course!"));

    }


    @PutMapping("/classification/{ID}")
    public ResponseEntity classifyByYears(@PathVariable String ID){

          String classification = teacherS.classifyByYears(ID);

          if(classification != null){
              return ResponseEntity.status(200).body(new ApiResponse("This teacher classification as: " + classification));
          }


              return ResponseEntity.status(400).body(new ApiResponse("Teacher with this ID not found!"));
    }



    @GetMapping("/getExpert")
    public ResponseEntity getExpertTeacher(){


          ArrayList<Teacher> expertTeachers = teacherS.getExpertTeacher();

          if(expertTeachers != null){
              return ResponseEntity.status(200).body(expertTeachers);
          }

          return ResponseEntity.status(400).body(new ApiResponse("No expert teacher found!"));
    }





} //End controller
