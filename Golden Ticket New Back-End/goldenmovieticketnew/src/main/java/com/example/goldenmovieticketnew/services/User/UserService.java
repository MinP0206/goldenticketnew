package com.example.goldenmovieticketnew.services.User;

import com.example.goldenmovieticketnew.models.Role;
import com.example.goldenmovieticketnew.models.RoleName;
import com.example.goldenmovieticketnew.models.User;
import com.example.goldenmovieticketnew.payload.SignUpRequest;
import com.example.goldenmovieticketnew.payload.UserProfile;
import com.example.goldenmovieticketnew.repositories.RoleRepository;
import com.example.goldenmovieticketnew.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email).get();
    }

    @Override
    public User addUser(SignUpRequest signUpRequest) {
       // PasswordEncoder passwordEncoder = passwordEncoder();
//        User user = new User(signUpRequest.getEmail(), signUpRequest.getImage(),
//                signUpRequest.getPassword(), signUpRequest.getFullname());
//
//        //user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setPassword(user.getPassword());
//        Optional<Role> userRole = roleRepository.findByRole(RoleName.ROLE_USER);
//
//        user.setRoles(Collections.singleton(userRole.get()));
     //  return userRepository.save(user);
        return null;
    }

    @Override
    public User updateUser(UserProfile userProfile) {
        Optional<User> user = userRepository.findByEmail(userProfile.getEmail());
        if(!user.isEmpty())
        {
            user.get().setEmail(userProfile.getEmail());
            user.get().setFullname(userProfile.getFullname());
            return user.get();
        }
        else return null;
    }

    @Override
    public Boolean deleteUser(String id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);

            return true;
        }
        return false;
    }
}
