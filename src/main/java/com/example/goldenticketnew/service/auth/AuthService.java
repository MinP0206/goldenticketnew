package com.example.goldenticketnew.service.auth;

import com.example.goldenticketnew.exception.AppException;
import com.example.goldenticketnew.model.Role;
import com.example.goldenticketnew.model.RoleName;
import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.payload.LoginRequest;
import com.example.goldenticketnew.payload.SignUpRequest;
import com.example.goldenticketnew.repository.IRoleRepository;
import com.example.goldenticketnew.repository.UserRepository;
import com.example.goldenticketnew.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

@Service
public class AuthService implements IAuthService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider tokenProvider;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    IRoleRepository IRoleRepository;

    @Autowired
    UserRepository userRepository;
    @Override
    public String authenticateUser(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return tokenProvider.generateToken(authentication); //jwt
    }

    @Override
    public URI registerUser(SignUpRequest signUpRequest) {
        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = IRoleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        //return URI
        return ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();
    }
}
