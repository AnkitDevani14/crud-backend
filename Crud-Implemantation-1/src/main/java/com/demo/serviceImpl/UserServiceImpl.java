package com.demo.serviceImpl;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repo.UserRepo;
import com.demo.service.UserService;



@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;

	@Override
	public User saveUser(String firstName, String lastName, long mobileNo, java.util.Date dateOfBirth) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setMobileNo(mobileNo);
		user.setDateOfBirth(dateOfBirth);
		
		User newUser = userRepo.save(user);
		
		
		return newUser;
	}

	@Override
	public User UpdateUser(String firstName, String lastName, long mobileNo, java.util.Date dob) {
		User user  = userRepo.findUserByFirstname(firstName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setMobileNo(mobileNo);
		user.setDateOfBirth(dob);
		
		User newUser = userRepo.save(user);
		return newUser;
	}

}
