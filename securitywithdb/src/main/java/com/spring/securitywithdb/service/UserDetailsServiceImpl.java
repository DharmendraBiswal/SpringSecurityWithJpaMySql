package com.spring.securitywithdb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.securitywithdb.model.User;
import com.spring.securitywithdb.model.UserDetailsImpl;
import com.spring.securitywithdb.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
		
		Optional<User> optionalUser = userRepository.findByFirstName(firstName);
		
		System.out.println("Optional Value:"+optionalUser.toString());
		
		Optional.ofNullable(optionalUser).orElseThrow(() -> new UsernameNotFoundException("firstName not present"));
		
		return optionalUser.map(user -> new UserDetailsImpl(user)).get();
				
	}

}
