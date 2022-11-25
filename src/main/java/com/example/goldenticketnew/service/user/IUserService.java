package com.example.goldenticketnew.service.user;


import com.example.goldenticketnew.dtos.UserDto;
import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.payload.UserProfile;
import com.example.goldenticketnew.payload.UserSummary;
import com.example.goldenticketnew.payload.resquest.UpdateUserRequest;
import com.example.goldenticketnew.security.UserPrincipal;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public interface IUserService {
    List<UserDto> getAllUser();
    UserSummary getCurrentUser(UserPrincipal currentUser) ;
    UserProfile getUserProfile(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    UserProfile updateInfoUser(UpdateUserRequest request);
    Boolean deleteUserById(Long Id);
}
