package org.example.lmslab7.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Teacher {



    @NotEmpty(message = "ID can't be empty!")
    @Size(min= 3, max= 4, message = "ID must be more than 2 and less than 5 digits!")
    private String ID;

    @NotEmpty(message = "Name can't be empty!")
    @Size(min= 4, max= 30, message = "Name must be more than 4 and less than 30 letters!" )
    private String name;

    @NotEmpty(message = "Email cannot be empty!")
    @Email(message = "Invalid email format!")
    private String email;

    @NotEmpty(message = "Password can't be empty!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password must contain at least one digit [0-9], \n at least one lowercase Latin character [a-z], \nat least one uppercase Latin character [A-Z], \n at least one special character like ! @ # & ( ), \na length of at least 8 characters and a maximum of 20 characters.")
    private String password;


    @Pattern(regexp = "^05\\d{8}$", message = "Phone number must start with '05' and be 10 digits.")
    private String phoneNumber;

    @Pattern(regexp = "^(Python|Java|JS|SQL|Data Analytics)$", message = "Course must be either: \"Python\", \"Java\", \"JS\", \"SQL\", or \"Data Analytics\".")
    private String course;


    private int experienceYears;













}
