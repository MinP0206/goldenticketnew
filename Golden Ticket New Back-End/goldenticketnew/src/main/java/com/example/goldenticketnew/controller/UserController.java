package com.example.goldenticketnew.controller;


import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.security.payload.ApiResponse;
import com.example.goldenticketnew.security.payload.UserIdentityAvailability;
import com.example.goldenticketnew.security.payload.UserProfile;
import com.example.goldenticketnew.security.payload.UserSummary;
import com.example.goldenticketnew.security.CurrentUser;
import com.example.goldenticketnew.security.UserPrincipal;
import com.example.goldenticketnew.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {



    @Autowired
    private UserService userService;

    //private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return userService.getCurrentUser(currentUser);
    }
    @GetMapping("/user/getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUser(){
        return  new ResponseEntity<>(userService.getAllUser(), HttpStatus.NOT_FOUND);
    }
    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {

        return new UserIdentityAvailability(!userService.existsByUsername(username));
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {

        return new UserIdentityAvailability(!userService.existsByEmail(email));
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {

        return userService.getUserProfile(username);
    }

    //Edit user
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/user/updateInfo")
    public ResponseEntity<?> updateInfoUser(@Valid @RequestBody UserProfile userProfile) {

        return ResponseEntity.created(userService.updateInfoUser(userProfile)).body(new ApiResponse(true, "User changed successfully"));
    }

    //Delete user
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/user/{id}")
    public ApiResponse DeleteUser(@Valid @PathVariable Long id) {

        if(userService.deleteUserById(id))
            return new ApiResponse(true, "Delete User Successfully");


        return new ApiResponse(false, "Please check the id");
    }
}
