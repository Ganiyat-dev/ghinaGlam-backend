package com.ghinaglam.ghinaglam.service;


import com.ghinaglam.ghinaglam.dto.RegistrationRequestDto;

public interface RegistrationService {
    String register(RegistrationRequestDto request);

    String confirmToken(String token);
}
