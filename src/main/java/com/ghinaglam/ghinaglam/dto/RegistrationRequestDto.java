package com.ghinaglam.ghinaglam.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.ghinaglam.ghinaglam.model.Role;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequestDto {
    @NotEmpty
    private String firstName;
    private String lastName;
    @NotEmpty
    private String email;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String password;
    private Role roles;
}

