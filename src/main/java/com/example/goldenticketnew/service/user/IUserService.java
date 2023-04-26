package com.example.goldenticketnew.service.user;


import com.example.goldenticketnew.dtos.UserDto;
import com.example.goldenticketnew.dtos.UserReportDto;
import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.payload.UserProfile;
import com.example.goldenticketnew.payload.UserSummary;
import com.example.goldenticketnew.payload.resquest.UpdateCategoryRequest;
import com.example.goldenticketnew.payload.resquest.UpdateUserRequest;
import com.example.goldenticketnew.security.UserPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    User getUser(Long id);

    User saveUser(User user);
    List<UserDto> getAllUser();
    UserSummary getCurrentUser(UserPrincipal currentUser) ;
    UserDto getUserProfile(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    UserDto updateInfoUser(UpdateUserRequest request);
    Boolean deleteUserById(Long Id);

    List<UserReportDto> getUserReport();

    UserDto updateCate(UpdateCategoryRequest request);
}
