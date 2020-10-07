package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	@Query("SELECT p FROM User p WHERE p.id =?1")
	User findUserById(Long id);
	
	@Query("SELECT p FROM User p WHERE p.firstname =?1")
	User findUserByFirstname(String id);
}
