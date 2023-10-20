package com.amit.sahay.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.sahay.ems.entity.User;
import com.amit.sahay.ems.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
	private UserService userService;
    @PostMapping("/register")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
	}
    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user){
    	return new ResponseEntity<User>(userService.updateUser( user),HttpStatus.ACCEPTED);
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteUser(){
    	return new ResponseEntity<String>(userService.deleteUser(),HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<User> getUserDetails(){
    	return new ResponseEntity<User>(userService.getUserDetails(),HttpStatus.OK);
    }
}
