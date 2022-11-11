package com.example.goldenticketnew.controller;


import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.payload.*;

import com.example.goldenticketnew.security.CurrentUser;
import com.example.goldenticketnew.security.UserPrincipal;
import com.example.goldenticketnew.service.user.IUserService;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
@Tag(name = "User Controller", description = "Thao tác với auth")
public class UserController {



    @Autowired
    private IUserService IUserService;

    //private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//    @ApiOperation(value = "Get user dang lam viec hien tai")
    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return IUserService.getCurrentUser(currentUser);
    }
//    @ApiOperation(value = "Get all")
    @GetMapping("/user/getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUser(){
        return  new ResponseEntity<>(IUserService.getAllUser(), HttpStatus.NOT_FOUND);
    }
    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {

        return new UserIdentityAvailability(!IUserService.existsByUsername(username));
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {

        return new UserIdentityAvailability(!IUserService.existsByEmail(email));
    }
//    @ApiOperation(value = "Get chi tiet user")
    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {

        return IUserService.getUserProfile(username);
    }
//    @ApiOperation(value = "update user")
    //Edit user
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/user/updateInfo")
    public ResponseEntity<?> updateInfoUser(@Valid @RequestBody UserProfile userProfile) {

        return ResponseEntity.created(IUserService.updateInfoUser(userProfile)).body(new ApiResponse(true, "User changed successfully"));
    }
//    @ApiOperation(value = "delete user")
    //Delete user
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/user/{id}")
    public ApiResponse DeleteUser(@Valid @PathVariable Long id) {

        if(IUserService.deleteUserById(id))
            return new ApiResponse(true, "Delete User Successfully");


        return new ApiResponse(false, "Please check the id");
    }
}
