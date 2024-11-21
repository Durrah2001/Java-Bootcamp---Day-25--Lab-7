package org.example.lmslab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Array;

@Data
@AllArgsConstructor
public class Course {

    @NotEmpty(message = "ID can't be empty!")
    @Size(min= 3, max= 8, message = "ID must be more than 2 and less than 9 digits!")
    private String ID;

    @NotEmpty(message = "Name can't be empty!")
    private String name;

    @Size(max= 300, message = "Course description can't be more than 300 characters!")
    private String description;

    @NotEmpty(message = "Course's teacher name can't be empty!")
    private String courseTeacher;

    @Positive(message = "Week number must be a positive number!")
    private int weeks; //Duration of this course

    @AssertFalse(message = "Default value must be false!")
    private boolean hasEnrolledStudent;


}
