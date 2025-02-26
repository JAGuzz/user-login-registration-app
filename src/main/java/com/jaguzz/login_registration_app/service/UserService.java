package com.jaguzz.login_registration_app.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.jaguzz.login_registration_app.model.User;
import com.jaguzz.login_registration_app.web.dto.UserRegistrationDto;

@Service
public interface UserService extends UserDetailsService{

    User save(UserRegistrationDto registrationDto);

}
