package com.ghinaglam.ghinaglam.dto;
import com.ghinaglam.ghinaglam.model.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class ClientDto {
    private Long id;
    @NotEmpty
    private String firstName;

    private String lastName;

    @NotEmpty
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty
    @Column(unique = true)

    private String phoneNumber;

    private String streetAddress;

    private String city;

    private String state;

    private String gender;
    private String address;

  private AppUserDto user;

}
