package com.BlogApp.Configuration;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.BlogApp.Repository.UserRepo;
import com.BlogApp.Entities.*;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepo userRepository; 
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user=this.userRepository.findUserByEmail(email);
		user.orElseThrow(()-> new UsernameNotFoundException("User Not Found!"));
		return user.map(CustomUserDetail::new ).get();
	}

}
