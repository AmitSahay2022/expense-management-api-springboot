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
    @PutMapping("{userId}")
    public ResponseEntity<User> updateUser(@PathVariable long userId,@RequestBody User user){
    	return new ResponseEntity<User>(userService.updateUser(userId, user),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId){
    	return new ResponseEntity<String>(userService.deleteUser(userId),HttpStatus.OK);
    }
    @GetMapping("{userId}")
    public ResponseEntity<User> getUserDetails(@PathVariable long userId){
    	return new ResponseEntity<User>(userService.getUserDetails(userId),HttpStatus.OK);
    }
}
