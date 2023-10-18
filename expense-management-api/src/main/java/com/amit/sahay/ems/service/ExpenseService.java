package com.amit.sahay.ems.service;

import java.util.List;

import com.amit.sahay.ems.entity.Expense;

public interface ExpenseService {
	Expense saveExpenseRecord(long userId, Expense expense);

	Expense updateExpenseRecord(long userId, long expenseId, Expense expense);

	String deleteExpenseRecord(long userId, long expenseId);

	Expense getExpenseById(long userId, long expenseId);

	List<Expense> getAllExpenses(long userId);
}
