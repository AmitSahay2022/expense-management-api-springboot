package com.amit.sahay.ems.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {
    @ExceptionHandler(ExpenseNotFoundException.class)
	public ResponseEntity<Map<String, Object>> expenseNotFoundException(ExpenseNotFoundException e) {
		Map<String, Object> map=new HashMap<>();
		map.put("message", e.getMessage());
		map.put("status", HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
	}
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,Object>> userNotFound(UserNotFoundException e){
    	Map<String,Object> map=new HashMap<>();
    	map.put("message", e.getMessage());
    	map.put("status", HttpStatus.NOT_FOUND.value());
    	return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserAllReadyExistException.class)
    public ResponseEntity<Map<String,Object>> userAllreadyExist(UserAllReadyExistException e){
    	Map<String,Object> map=new HashMap<>();
    	map.put("message", e.getMessage());
    	map.put("status", HttpStatus.CONFLICT.value());
    	return new ResponseEntity<Map<String,Object>>(map,HttpStatus.CONFLICT);
    }
    
}
