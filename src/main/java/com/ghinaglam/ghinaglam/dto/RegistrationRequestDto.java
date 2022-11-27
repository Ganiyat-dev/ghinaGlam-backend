package com.ghinaglam.ghinaglam.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.ghinaglam.ghinaglam.model.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private Role role;
}

