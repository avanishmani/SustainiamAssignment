package com.sustainium.Service;

import java.util.List;

import com.sustainium.Exception.ExpenseException;
import com.sustainium.Model.Expense;

public interface ExpenseService {
	Expense addExpense(Expense expense);

	Expense updateExpense(Expense expense, Integer id) throws ExpenseException;

	void DeleteExpense(Integer id) throws ExpenseException;

	List<Expense> getAllExpenses() throws ExpenseException;

	Expense getExpenseById(Integer id) throws ExpenseException;

	double calculateMonthlyExpense(Expense expense);

	double calculateYearlyExpense(List<Expense> expenses);
}
