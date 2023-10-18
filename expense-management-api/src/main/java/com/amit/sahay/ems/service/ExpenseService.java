package com.amit.sahay.ems.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.amit.sahay.ems.entity.Expense;

public interface ExpenseService {
	Expense saveExpenseRecord(long userId, Expense expense);

	Expense updateExpenseRecord(long userId, long expenseId, Expense expense);

	String deleteExpenseRecord(long userId, long expenseId);

	Expense getExpenseById(long userId, long expenseId);

	Page<Expense> getAllExpenses(long userId,Pageable pageable);
}
