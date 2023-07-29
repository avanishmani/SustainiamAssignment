package com.sustainium.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sustainium.Exception.ExpenseException;
import com.sustainium.Model.Expense;
import com.sustainium.Service.ExpenseService;

@RestController
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;

	// POST: Create a new expense
	@PostMapping("/expenses")
	public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
		Expense createdExpense = expenseService.addExpense(expense);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
	}

	@GetMapping("/expenses")
	public List<Expense> getAllExpenses() throws ExpenseException {
		return expenseService.getAllExpenses();
	}

	@GetMapping("/expenses/{id}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable Integer id) throws ExpenseException {
		Expense expense = expenseService.getExpenseById(id);
		if (expense != null) {
			return ResponseEntity.ok(expense);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Expense> updateExpense(@PathVariable Integer id, @RequestBody Expense expense)
			throws ExpenseException {
		Expense updatedExpense = expenseService.updateExpense(expense, id);
		if (updatedExpense != null) {
			return ResponseEntity.ok(updatedExpense);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// DELETE: Delete an expense by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExpense(@PathVariable Integer id) throws ExpenseException {
		expenseService.DeleteExpense(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}/monthly")
	public ResponseEntity<Double> calculateMonthlyExpense(@PathVariable Integer id) throws ExpenseException {
		Expense expense = expenseService.getExpenseById(id);
		if (expense != null) {
			double monthlyExpense = expenseService.calculateMonthlyExpense(expense);
			return ResponseEntity.ok(monthlyExpense);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// GET: Calculate yearly expense for all expenses
	@GetMapping("/yearly")
	public ResponseEntity<Double> calculateYearlyExpense() throws ExpenseException {
		List<Expense> allExpenses = expenseService.getAllExpenses();
		double yearlyExpense = expenseService.calculateYearlyExpense(allExpenses);
		return ResponseEntity.ok(yearlyExpense);
	}

}
