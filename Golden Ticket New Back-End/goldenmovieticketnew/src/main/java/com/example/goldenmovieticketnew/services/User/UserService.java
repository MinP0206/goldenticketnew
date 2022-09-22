package com.example.goldenmovieticketnew.services.User;

import com.example.goldenmovieticketnew.models.User;
import com.example.goldenmovieticketnew.payload.SignUpRequest;
import com.example.goldenmovieticketnew.payload.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUser();
    User getUser(String email);
    User addUser(SignUpRequest signUpRequest);;
    User updateUser(UserProfile user);
    Boolean deleteUser(String id);
}
