package com.amit.sahay.ems.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.amit.sahay.ems.entity.Expense;
import com.amit.sahay.ems.entity.User;
import com.amit.sahay.ems.exception.ExpenseNotFoundException;
import com.amit.sahay.ems.repository.ExpenseRepository;
import com.amit.sahay.ems.service.ExpenseService;
import com.amit.sahay.ems.service.UserService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{
    private UserService userService;
    private ExpenseRepository expenseRepository;
	@Override
	public Expense saveExpenseRecord(Expense expense) {
		User user = userService.getUserDetails();
		expense.setUser(user);
		return expenseRepository.save(expense);
	}

	@Override
	public Expense updateExpenseRecord(long expenseId, Expense expense) {
		// TODO Auto-generated method stub
		Expense expenseById = getExpenseById(expenseId);
		expenseById.setAmount(expense.getAmount());
		expenseById.setCategory(expense.getCategory());
		expenseById.setDate(expense.getDate());
		expenseById.setName(expense.getName());
		expenseById.setDescription(expense.getDescription());
		return expenseRepository.save(expenseById);
	}

	@Override
	public String deleteExpenseRecord(long expenseId) {
		// TODO Auto-generated method stub
		Expense expenseById = getExpenseById(expenseId);
		expenseRepository.delete(expenseById);
		return "Expense with id: "+expenseId+" Deleted Successfully";
	}

	@Override
	public Expense getExpenseById(long expenseId) {
		// TODO Auto-generated method stub
		User user = userService.getUserDetails();
		Expense expense = expenseRepository
		       .findByUserUserIdAndExpenseId(user.getUserId(), expenseId)
		       .orElseThrow(()->new ExpenseNotFoundException("Expense not found with id: "+expenseId));
		return expense;
	}

	@Override
	public Page<Expense> getAllExpenses(Pageable pageable) {
		User user = userService.getUserDetails();
		return expenseRepository.findByUserUserId(user.getUserId(),pageable);
	}

}
