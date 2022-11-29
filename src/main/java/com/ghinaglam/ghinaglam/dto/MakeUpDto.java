package com.ghinaglam.ghinaglam.dto;
import com.ghinaglam.ghinaglam.model.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MakeUpDto{
    private Long id;
    @NotEmpty
    private String firstName;
    private String lastName;
    @NotEmpty(message = "Email is required")
    @Column(name = "email", unique = true)
    private String email;

    private String phoneNumber;
    @NotEmpty
    private String password;
    @NotEmpty
    private String specialization;
    @NotEmpty
    private int yearsOfExperience;

    private double salary;

    private AppUserDto user;
}
