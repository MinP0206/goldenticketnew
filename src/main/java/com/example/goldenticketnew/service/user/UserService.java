package com.example.goldenticketnew.service.user;


import com.example.goldenticketnew.exception.ResourceNotFoundException;
import com.example.goldenticketnew.model.Role;
import com.example.goldenticketnew.model.User;
import com.example.goldenticketnew.payload.UserProfile;
import com.example.goldenticketnew.payload.UserSummary;
import com.example.goldenticketnew.repository.IRoleRepository;
import com.example.goldenticketnew.repository.UserRepository;
import com.example.goldenticketnew.security.UserPrincipal;
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
    public List<User> getAllUser() {
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

        return notAdmin;
    }

    @Override
    public UserSummary getCurrentUser(UserPrincipal currentUser) {
        return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName(),currentUser.getEmail(),currentUser.getAuthorities().toString());
    }

    @Override
    public UserProfile getUserProfile(String username) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getEmail(), user.getImage(),user.getRoles().stream().collect(Collectors.toList()).get(0).getName().name());
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
    public URI updateInfoUser(UserProfile userProfile) {

        User oldUser = userRepository.findByUsername(userProfile.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Please login to continue  "));


        oldUser.setName(userProfile.getName());
        oldUser.setImage(userProfile.getImage());
        try {
            userRepository.save(oldUser);
        }
        catch (Exception e){
            log.debug(e);
        }

        //return URI
        return ServletUriComponentsBuilder
            .fromCurrentContextPath().path("/users/{username}")
            .buildAndExpand(oldUser.getUsername()).toUri();

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
