package com.example.goldenticketnew.service.auth;

import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.payload.LoginRequest;
import com.example.goldenticketnew.payload.SignUpRequest;
import com.example.goldenticketnew.payload.UserProfile;
import com.example.goldenticketnew.payload.UserSummary;
import com.example.goldenticketnew.security.UserPrincipal;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public interface AuthService  {
    String authenticateUser(LoginRequest loginRequest);
    URI registerUser(SignUpRequest signUpRequest);

}
