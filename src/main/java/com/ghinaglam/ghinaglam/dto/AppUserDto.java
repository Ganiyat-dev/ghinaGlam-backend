package com.ghinaglam.ghinaglam.dto;

import com.ghinaglam.ghinaglam.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {
    private Long id;
    @NotEmpty
    private String firstName;
    private String lastName;
    @NotEmpty
    private String password;
    @NotEmpty
    @Column(unique = true)
    private String email;
    @NotEmpty
    private String phoneNumber;
    private Role roles;
}
