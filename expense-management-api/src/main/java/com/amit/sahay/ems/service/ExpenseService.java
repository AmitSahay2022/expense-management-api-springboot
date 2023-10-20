package com.amit.sahay.ems.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.amit.sahay.ems.entity.Expense;

public interface ExpenseService {
	Expense saveExpenseRecord(Expense expense);

	Expense updateExpenseRecord(long expenseId, Expense expense);

	String deleteExpenseRecord(long expenseId);

	Expense getExpenseById(long expenseId);

	Page<Expense> getAllExpenses(Pageable pageable);
}
