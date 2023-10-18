package com.amit.sahay.ems.controller;

import java.util.List;

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

import com.amit.sahay.ems.entity.Expense;
import com.amit.sahay.ems.service.ExpenseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/expenses")
@AllArgsConstructor
public class ExpenseController {
	private ExpenseService expenseService;

	@PostMapping("{userId}")
	public ResponseEntity<Expense> saveExpense(@PathVariable long userId, @RequestBody Expense expense) {
		return new ResponseEntity<Expense>(expenseService.saveExpenseRecord(userId, expense), HttpStatus.CREATED);
	}

	@PutMapping("{userId}/{expenseId}")
	public ResponseEntity<Expense> updateExpense(@PathVariable long userId, @PathVariable long expenseId,
			@RequestBody Expense expense) {
		return new ResponseEntity<Expense>(expenseService.updateExpenseRecord(userId, expenseId, expense),
				HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{userId}/{expenseId}")
	public ResponseEntity<String> deleteExpense(@PathVariable long userId, @PathVariable long expenseId) {
		return new ResponseEntity<String>(expenseService.deleteExpenseRecord(userId, expenseId), HttpStatus.OK);
	}

	@GetMapping("{userId}/{expenseId}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable long userId, @PathVariable long expenseId) {
		return new ResponseEntity<Expense>(expenseService.getExpenseById(userId, expenseId), HttpStatus.OK);
	}

	@GetMapping("{userId}")
	public ResponseEntity<List<Expense>> getAllExpenses(@PathVariable long userId) {
		return new ResponseEntity<List<Expense>>(expenseService.getAllExpenses(userId), HttpStatus.OK);
	}
}
