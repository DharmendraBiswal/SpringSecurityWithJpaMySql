package com.spring.securitywithdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.securitywithdb.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByFirstName(String firstName);

}
