package com.amit.sahay.ems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.sahay.ems.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	Optional<Expense> findByUserUserIdAndExpenseId(long userId, long expenseId);

	List<Expense> findByUserUserId(long userId);
}
