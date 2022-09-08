package com.example.goldenticketnew.service.user;


import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.payload.UserProfile;
import com.example.goldenticketnew.payload.UserSummary;
import com.example.goldenticketnew.security.UserPrincipal;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAllUser();
    UserSummary getCurrentUser(UserPrincipal currentUser) ;
    UserProfile getUserProfile(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    URI updateInfoUser(UserProfile userProfile);
    Boolean deleteUserById(Long Id);
}
