package com.example.goldenmovieticketnew.secutiry.config;


import com.example.goldenmovieticketnew.models.RoleName;
import com.example.goldenmovieticketnew.secutiry.UserDetailsServiceImpl;
import com.example.goldenmovieticketnew.secutiry.jwt.AuthEntryPointJwt;
import com.example.goldenmovieticketnew.secutiry.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		securedEnabled = true,
		jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

//	@Bean
//  public DaoAuthenticationProvider authenticationProvider() {
//      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//      authProvider.setUserDetailsService(userDetailsService);
//      authProvider.setPasswordEncoder(passwordEncoder());
//
//      return authProvider;
//  }

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

//	@Bean
//  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//    return authConfig.getAuthenticationManager();
//  }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests()
			.antMatchers("/api/user/**","api/movie/**").hasAnyAuthority(RoleName.ROLE_USER.name(),RoleName.ROLE_STAFF.name(),RoleName.ROLE_ADMIN.name())
			.antMatchers("/api/auth/**").permitAll()

			.anyRequest().permitAll();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}

//	@Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.cors().and().csrf().disable()
//        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//        .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//
//		.antMatchers("/error").permitAll()
//       // .antMatchers("/api/test/**","/v2/api-docs","/swagger-resources/**","/swagger-ui/**","/swagger-ui.html/**").permitAll()
////			.antMatchers("/swagger-resources/**","/swagger-ui/**","/swagger-ui.html").permitAll()
//
//        .anyRequest().authenticated();
//
//    http.authenticationProvider(authenticationProvider());
//
//    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//
//    return http.build();
//  }
}
