package com.example.goldenticketnew.service.user;


import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.security.payload.UserProfile;
import com.example.goldenticketnew.security.payload.UserSummary;
import com.example.goldenticketnew.security.UserPrincipal;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public interface UserService {
    List<User> getAllUser();
    UserSummary getCurrentUser(UserPrincipal currentUser) ;
    UserProfile getUserProfile(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    URI updateInfoUser(UserProfile userProfile);
    Boolean deleteUserById(Long Id);
}
