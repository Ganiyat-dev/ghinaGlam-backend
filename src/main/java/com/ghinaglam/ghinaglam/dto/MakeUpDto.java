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
    private String firstName;
    private String lastName;
    @NotEmpty(message = "Email is required")
    @Column(name = "email", unique = true)
    private String email;

    private String phoneNumber;

//    private String licensePath;
//
//    @Lob
//    private byte[] licenseData;
    private String specialization;
    private int yearsOfExperience;

    private double salary;

    private AppUserDto user;
}
