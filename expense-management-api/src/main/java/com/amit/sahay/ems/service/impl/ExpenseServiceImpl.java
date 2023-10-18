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
	public Expense saveExpenseRecord(long userId,Expense expense) {
		User user = userService.getUserDetails(userId);
		expense.setUser(user);
		return expenseRepository.save(expense);
	}

	@Override
	public Expense updateExpenseRecord(long userId, long expenseId, Expense expense) {
		// TODO Auto-generated method stub
		Expense expenseById = getExpenseById(userId, expenseId);
		expenseById.setAmount(expense.getAmount());
		expenseById.setCategory(expense.getCategory());
		expenseById.setDate(expense.getDate());
		expenseById.setName(expense.getName());
		expenseById.setDescription(expense.getDescription());
		return expenseRepository.save(expenseById);
	}

	@Override
	public String deleteExpenseRecord(long userId, long expenseId) {
		// TODO Auto-generated method stub
		Expense expenseById = getExpenseById(userId, expenseId);
		expenseRepository.delete(expenseById);
		return "Expense with id: "+expenseId+" Deleted Successfully";
	}

	@Override
	public Expense getExpenseById(long userId, long expenseId) {
		// TODO Auto-generated method stub
		Expense expense = expenseRepository
		       .findByUserUserIdAndExpenseId(userId, expenseId)
		       .orElseThrow(()->new ExpenseNotFoundException("Expense not found with id: "+expenseId));
		return expense;
	}

	@Override
	public Page<Expense> getAllExpenses(long userId,Pageable pageable) {
		
		return expenseRepository.findByUserUserId(userId,pageable);
	}

}
