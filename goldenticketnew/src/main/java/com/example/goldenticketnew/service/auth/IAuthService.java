package com.example.goldenticketnew.service.auth;

import com.example.goldenticketnew.payload.resquest.LoginRequest;
import com.example.goldenticketnew.payload.resquest.SignUpRequest;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public interface IAuthService {
    String authenticateUser(LoginRequest loginRequest);
    URI registerUser(SignUpRequest signUpRequest);

}
