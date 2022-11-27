package com.ghinaglam.ghinaglam.dto;

import com.ghinaglam.ghinaglam.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {
    private Long id;
    private String firstName;
    private String lastName;

    private String email;

    private String phoneNumber;
    private Role roles;
}
