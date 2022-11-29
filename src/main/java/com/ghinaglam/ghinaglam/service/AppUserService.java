package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.dto.LoginDto;
import com.ghinaglam.ghinaglam.dto.UserResponse;
import com.ghinaglam.ghinaglam.model.AppUser;


import java.util.List;

public interface AppUserService {
    List<AppUser> getUsers();


    String signUpUser(AppUser appUser);

    AppUser getUser(AppUser currentUser);

    String deleteUser(String email);

    int enableAppUser(String email);


}
