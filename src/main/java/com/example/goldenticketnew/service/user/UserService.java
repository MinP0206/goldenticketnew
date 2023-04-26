package com.example.goldenticketnew.service.user;


import com.example.goldenticketnew.dtos.UserDto;
import com.example.goldenticketnew.dtos.UserReportDto;
import com.example.goldenticketnew.enums.ResponseCode;
import com.example.goldenticketnew.exception.InternalException;
import com.example.goldenticketnew.exception.ResourceNotFoundException;
import com.example.goldenticketnew.model.Category;
import com.example.goldenticketnew.model.Role;
import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.payload.UserProfile;
import com.example.goldenticketnew.payload.UserSummary;
import com.example.goldenticketnew.payload.resquest.UpdateCategoryRequest;
import com.example.goldenticketnew.payload.resquest.UpdateUserRequest;
import com.example.goldenticketnew.repository.ICategoryRepository;
import com.example.goldenticketnew.repository.UserRepository;
import com.example.goldenticketnew.security.UserPrincipal;
import com.example.goldenticketnew.utils.ModelMapperUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ICategoryRepository categoryRepository;


    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new InternalException(ResponseCode.USER_NOT_FOUND));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.saveAndFlush(user);
    }


    @Override
    public List<UserDto> getAllUser() {
        int check = 0;
        List<User> notAdmin = userRepository.findAll();
        for (int i = notAdmin.size() - 1; i >= 0; i--) {
            for (Role element : notAdmin.get(i).getRoles()) {
                if (element.getId() == 2) {
                    check = 1;
                }
            }
            if (check == 1) {
                notAdmin.remove(i);
                check = 0;
            }

        }

//        return ModelMapperUtils.mapList(notAdmin, UserDto.class);
        return ModelMapperUtils.mapListUser(notAdmin);

    }

    @Override
    public UserSummary getCurrentUser(UserPrincipal currentUser) {
        return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName(),currentUser.getEmail(), currentUser.getImage(), currentUser.getAuthorities().toString());
    }

    @Override
    public UserDto getUserProfile(String username) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        return new UserDto(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);

    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserDto updateInfoUser(UpdateUserRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow(() -> new InternalException(ResponseCode.USER_NOT_FOUND));
        if(request.getBio() != null) user.setName(request.getName());
        if(request.getBio() != null)  user.setImage(request.getImage());
        if(request.getBio() != null) user.setBio(request.getBio());
        return new UserDto(userRepository.save(user));
    }

    @Override
    public Boolean deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public List<UserReportDto> getUserReport() {
        userRepository.findAll();
        return null;
    }

    @Override
    public UserDto updateCate(UpdateCategoryRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new InternalException(ResponseCode.USER_NOT_FOUND));
        List<Category> categories = categoryRepository.findAllById(request.getCategories());
        user.setCategories(categories);
        return new UserDto(userRepository.saveAndFlush(user));
    }

}
