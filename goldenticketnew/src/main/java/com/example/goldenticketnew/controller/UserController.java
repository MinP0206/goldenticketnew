package com.example.goldenticketnew.controller;


import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.payload.*;

import com.example.goldenticketnew.payload.response.ApiResponse;
import com.example.goldenticketnew.security.CurrentUser;
import com.example.goldenticketnew.security.UserPrincipal;
import com.example.goldenticketnew.service.user.IUserService;


import io.swagger.v3.oas.annotations.Operation;
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
@Tag(name = "User Controller", description = "Thao tác với User")
public class UserController {


    @Autowired
    private IUserService userService;

    @Operation(
        summary = "Get thông tin user hiện tại",
        description = "- Get thông tin user hiện tại toàn bộ user"
    )
    @GetMapping("/user/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return userService.getCurrentUser(currentUser);
    }

    @Operation(
        summary = "Get toàn bộ user",
        description = "- Get toàn bộ user"
    )
    @GetMapping("/user/getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {

        return new UserIdentityAvailability(!userService.existsByUsername(username));
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {

        return new UserIdentityAvailability(!userService.existsByEmail(email));
    }

    @Operation(
        summary = "Get chi tiết user by username",
        description = "- Get chi tiết user"
    )
    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {

        return userService.getUserProfile(username);
    }

    //Edit user
    @Operation(
        summary = "Chỉnh sửa thông tin User",
        description = "- Chỉnh sửa thông tin UserXóa một User"
    )
    @PostMapping("/user/updateInfo")
    public ResponseEntity<?> updateInfoUser(@Valid @RequestBody UserProfile userProfile) {

        return ResponseEntity.created(userService.updateInfoUser(userProfile)).body(new ApiResponse(true, "User changed successfully"));
    }

    @Operation(
        summary = "Xóa một User",
        description = "- Xóa một User"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/user/{id}")
    public ApiResponse deleteUser(@Valid @PathVariable Long id) {
        if (userService.deleteUserById(id))
            return new ApiResponse(true, "Delete User Successfully");
        return new ApiResponse(false, "Please check the id");
    }

}
