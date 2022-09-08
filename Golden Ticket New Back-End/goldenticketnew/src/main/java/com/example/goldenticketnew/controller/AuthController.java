package com.example.goldenticketnew.controller;


import com.example.goldenticketnew.exception.AppException;
import com.example.goldenticketnew.model.Role;
import com.example.goldenticketnew.model.RoleName;
import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.payload.ApiResponse;
import com.example.goldenticketnew.payload.JwtAuthenticationResponse;
import com.example.goldenticketnew.payload.LoginRequest;
import com.example.goldenticketnew.payload.SignUpRequest;
import com.example.goldenticketnew.repository.RoleRepository;
import com.example.goldenticketnew.repository.UserRepository;
import com.example.goldenticketnew.security.JwtTokenProvider;
import com.example.goldenticketnew.service.auth.AuthService;
import com.example.goldenticketnew.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        return ResponseEntity.ok(new JwtAuthenticationResponse(authService.authenticateUser(loginRequest)));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userService.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.created(authService.registerUser(signUpRequest)).body(new ApiResponse(true, "User registered successfully"));
    }
}
