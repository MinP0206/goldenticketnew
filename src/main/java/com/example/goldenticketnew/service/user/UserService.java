package com.example.goldenticketnew.service.user;


import com.example.goldenticketnew.dtos.UserDto;
import com.example.goldenticketnew.enums.ResponseCode;
import com.example.goldenticketnew.exception.InternalException;
import com.example.goldenticketnew.exception.ResourceNotFoundException;
import com.example.goldenticketnew.model.Role;
import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.payload.UserProfile;
import com.example.goldenticketnew.payload.UserSummary;
import com.example.goldenticketnew.payload.resquest.UpdateUserRequest;
import com.example.goldenticketnew.repository.IRoleRepository;
import com.example.goldenticketnew.repository.UserRepository;
import com.example.goldenticketnew.security.UserPrincipal;
import com.example.goldenticketnew.utils.ModelMapperUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

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

        return ModelMapperUtils.mapList(notAdmin, UserDto.class);
    }

    @Override
    public UserSummary getCurrentUser(UserPrincipal currentUser) {
        return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName(),currentUser.getEmail(),currentUser.getAuthorities().toString());
    }

    @Override
    public UserProfile getUserProfile(String username) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getEmail(), user.getImage());
        return userProfile;
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
    public UserProfile updateInfoUser(UpdateUserRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow(() -> new InternalException(ResponseCode.USER_NOT_FOUND));
        if(!request.getName().isBlank()) user.setName(request.getName());
        if(!request.getImage().isBlank())  user.setImage(request.getImage());
        return ModelMapperUtils.mapper(userRepository.save(user), UserProfile.class);
    }

    @Override
    public Boolean deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);

            return true;
        }
        return false;

    }

}
