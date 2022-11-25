package com.ghinaglam.ghinaglam.dto;
import com.ghinaglam.ghinaglam.model.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

@Getter
@Setter
public class MakeUpDto{
    private Long id;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    //    @Column(unique = true)
    private String phoneNumber;
    private String password;

    private String licensePath;

    @Lob
    private byte[] licenseData;

    private int yearsOfExperience;
    private double salary;
    private Category category = Category.MAKEUP_ARTIST;
}
