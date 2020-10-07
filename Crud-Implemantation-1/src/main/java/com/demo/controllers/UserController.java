package com.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.repo.UserRepo;
import com.demo.service.UserService;



@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins ="http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepo userRepo;

	@PostMapping("/save-user")
	public ResponseEntity<?> getUser(@RequestBody HashMap<String, String> request){
		
		String firstname = request.get("firstname");
		String lastname = request.get("lastname");
		String mobileno = request.get("mobileno");
		long mobile = Long.parseLong(mobileno);
		
		
		try {
			String dateOfBirth = request.get("dateOfBirth");
			 Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);  
			User user = userService.saveUser(firstname, lastname, mobile, dob);
			return new ResponseEntity<>(user,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
		}
		
	}

	@PostMapping("/update-user")
	public ResponseEntity<?> updateUser(@RequestBody HashMap<String, String> request){
		
		String firstname = request.get("firstname");
		String lastname = request.get("lastname");
		String mobileno = request.get("mobileno");
		long mobile = Long.parseLong(mobileno);
		
		
		try {
			String dateOfBirth = request.get("dateOfBirth");
			 Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);  
			User user = userService.UpdateUser(firstname, lastname, mobile, dob);
			return new ResponseEntity<>(user,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("list-user")
	public ResponseEntity<?> listUser(){
		
		try {
			List<User> listUser = userRepo.findAll();	
			return new ResponseEntity<>(listUser,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("getUser/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") long id){
		
		try {
			User user = userRepo.findUserById(id);	
			return new ResponseEntity<>(user,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("delete-user/{id}")
	public ResponseEntity<?> listUser(@PathVariable("id") long id){
		
		try {
			userRepo.deleteById(id);	
			return new ResponseEntity<>("Record Deleted Successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
		}
	}

}
