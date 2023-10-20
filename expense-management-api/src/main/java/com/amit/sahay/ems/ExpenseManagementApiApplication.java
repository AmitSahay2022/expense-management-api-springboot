package com.amit.sahay.ems;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class ExpenseManagementApiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagementApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}
}
