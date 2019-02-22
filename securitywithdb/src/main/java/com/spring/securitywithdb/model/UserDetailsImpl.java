package com.spring.securitywithdb.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl extends User implements UserDetails{
	
	User user;

	public UserDetailsImpl(User user) {
		super(user);
		//this.user = user;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		System.out.println("Roles Set:"+getRoles());
		
		 List<SimpleGrantedAuthority> list = getRoles().stream()
					.map(role -> new SimpleGrantedAuthority("ROLE_"+ role.getRoleName())).collect(Collectors.toList());
		 
		 System.out.println("List :"+list.toString());
		 
		 return list;
		
		 
	}

	@Override
	public String getPassword() {		
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		
		return super.getFirstName();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
