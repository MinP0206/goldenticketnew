package com.example.goldenmovieticketnew.secutiry;




import com.example.goldenmovieticketnew.models.User;
import com.example.goldenmovieticketnew.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username or Email: " + usernameOrEmail));

		return UserDetailsImpl.build(user);
	}

}

