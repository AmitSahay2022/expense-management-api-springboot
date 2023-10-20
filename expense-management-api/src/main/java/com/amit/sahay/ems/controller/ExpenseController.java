package com.amit.sahay.ems.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@PostMapping()
	public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense) {
		return new ResponseEntity<Expense>(expenseService.saveExpenseRecord(expense), HttpStatus.CREATED);
	}

	@PutMapping("{expenseId}")
	public ResponseEntity<Expense> updateExpense(@PathVariable long expenseId,
			@RequestBody Expense expense) {
		return new ResponseEntity<Expense>(expenseService.updateExpenseRecord(expenseId, expense),
				HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{expenseId}")
	public ResponseEntity<String> deleteExpense(@PathVariable long expenseId) {
		return new ResponseEntity<String>(expenseService.deleteExpenseRecord(expenseId), HttpStatus.OK);
	}

	@GetMapping("{expenseId}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable long expenseId) {
		return new ResponseEntity<Expense>(expenseService.getExpenseById(expenseId), HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<Page<Expense>> getAllExpenses(Pageable pageable) {
		return new ResponseEntity<>(expenseService.getAllExpenses(pageable), HttpStatus.OK);
	}
}
