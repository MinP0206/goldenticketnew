package com.example.goldenmovieticketnew.controllers;


import com.example.goldenmovieticketnew.models.Role;
import com.example.goldenmovieticketnew.models.RoleName;
import com.example.goldenmovieticketnew.models.User;
import com.example.goldenmovieticketnew.payload.ApiResponse;
import com.example.goldenmovieticketnew.payload.JwtResponse;
import com.example.goldenmovieticketnew.payload.LoginRequest;
import com.example.goldenmovieticketnew.payload.SignUpRequest;
import com.example.goldenmovieticketnew.repositories.RoleRepository;
import com.example.goldenmovieticketnew.repositories.UserRepository;
import com.example.goldenmovieticketnew.secutiry.UserDetailsImpl;
import com.example.goldenmovieticketnew.secutiry.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok("alo");
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new ApiResponse(false,"Username is in Use!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new ApiResponse(false,"Email is in Use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getEmail(), signUpRequest.getUsername(),signUpRequest.getImage(),
							 encoder.encode(signUpRequest.getPassword()),signUpRequest.getFullname());

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByRole(RoleName.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
//		} else {
//			strRoles.forEach(role -> {
//				switch (role) {
//				case "admin":
//					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(adminRole);
//
//					break;
//				case "mod":
//					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(modRole);
//
//					break;
//				default:
//					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(userRole);
//				}
//			});
//		}
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new ApiResponse(true,"User registered successfully!"));
	}
}
