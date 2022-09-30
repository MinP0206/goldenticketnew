package com.example.goldenmovieticketnew.controllers;

import com.example.goldenmovieticketnew.models.User;
import com.example.goldenmovieticketnew.payload.ApiResponse;
import com.example.goldenmovieticketnew.payload.SignUpRequest;
import com.example.goldenmovieticketnew.payload.UserProfile;
import com.example.goldenmovieticketnew.services.User.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
@Api(value = "User APIs")
public class UserController {
    @Autowired
    private IUserService userService;
    @ApiOperation(value = "Xem chi tiet user by email")
    @GetMapping("/{email}")
    public ResponseEntity<User> getUserProfile(@PathVariable String email) {

        return new ResponseEntity<>(userService.getUser(email), HttpStatus.OK);
    }
    @ApiOperation(value = "Xem danh sách User", response = List.class)
    @GetMapping("")
    public ResponseEntity<List<User>>  getAllUser() {

        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
    @GetMapping("/hello")
    public ResponseEntity<String>  getAllUseraaa() {

        return new ResponseEntity<>("hello", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ApiResponse DeleteUser(@PathVariable String id) {

        if(userService.deleteUser(id))
            return new ApiResponse(true, "Delete User Successfully");


        return new ApiResponse(false, "Please check the id");
    }
    @ApiOperation(value = "Cap nhat chi tiet user")
    @PutMapping("")
    public ResponseEntity<?> updateInfoUser(@RequestBody UserProfile userProfile) {
        return new ResponseEntity<>(userService.updateUser(userProfile), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewUser(@RequestBody SignUpRequest signUpRequest) {
        return new ResponseEntity<>(userService.addUser(signUpRequest),HttpStatus.OK);
    }
}


