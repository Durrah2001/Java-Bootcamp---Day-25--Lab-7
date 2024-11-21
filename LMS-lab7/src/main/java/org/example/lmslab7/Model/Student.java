package org.example.lmslab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    @NotEmpty(message = "ID can't be empty!")
    @Size(min= 3, max= 4, message = "ID must be more than 2 and less than 5 digits!")
    private String ID;

    @NotEmpty(message = "Name can't be empty!")
    @Size(min= 4, max= 30, message = "Name must be more than 4 and less than 30 letters!" )
    private String name;

    @NotEmpty(message = "Email can't be empty!")
    @Email(message = "Invalid email format!")
    private String email;

    @NotEmpty(message = "Password can't be empty!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password must contain at least one digit [0-9], \n at least one lowercase Latin character [a-z], \nat least one uppercase Latin character [A-Z], \n at least one special character like ! @ # & ( ), \na length of at least 8 characters and a maximum of 20 characters.")
    private String password;

    @Positive(message = "Age must be a positive number only!")
    @Min(12)
    private int age;

    @AssertFalse(message = "This variable must be false by default!")
    private boolean hasCourse;













}
