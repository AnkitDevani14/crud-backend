package com.demo.service;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.demo.model.User;



public interface UserService {
	
	public User saveUser(String firstName, String lastName,long mobileNo, java.util.Date dob);

	
	public User UpdateUser(String firstName, String lastName,long mobileNo, java.util.Date dob);
}
