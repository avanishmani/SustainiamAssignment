package com.sustainium.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sustainium.Exception.ExpenseException;
import com.sustainium.Model.Expense;
import com.sustainium.Repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	private ExpenseRepository exr;

	@Override
	public double calculateMonthlyExpense(Expense expense) {
		return expense.getHouseholdExpenditure() + expense.getOfficeExpenditure() + expense.getCommutingExpenditure();
	}

	@Override
	public double calculateYearlyExpense(List<Expense> expenses) {
		double totalExpense = 0;
		for (Expense expense : expenses) {
			totalExpense += calculateMonthlyExpense(expense);
		}
		return totalExpense;
	}

	@Override
	public Expense addExpense(Expense expense) {

		return exr.save(expense);
	}

	@Override
	public Expense updateExpense(Expense expense, Integer id) throws ExpenseException {
		Optional<Expense> uexp = exr.findById(id);
		if (uexp.isEmpty()) {
			throw new ExpenseException("Data is not avilable for that particular id " + id);
		} else {
			Expense puex = uexp.get();
			puex.setCommutingExpenditure(expense.getCommutingExpenditure());
			puex.setHouseholdExpenditure(expense.getHouseholdExpenditure());
			puex.setMonth(expense.getMonth());
			puex.setName(expense.getName());
			puex.setOfficeExpenditure(expense.getOfficeExpenditure());
			puex.setYear(expense.getYear());
			return exr.save(puex);
		}

	}

	@Override
	public void DeleteExpense(Integer id) throws ExpenseException {
		// TODO Auto-generated method stub
		exr.deleteById(id);

	}

	@Override
	public List<Expense> getAllExpenses() throws ExpenseException {
		// TODO Auto-generated method stub
		List<Expense> AllExpenses = exr.findAll();
		if (AllExpenses.size() == 0) {
			throw new ExpenseException("No Data Is Avilable inside the data base ");
		} else {
			return AllExpenses;
		}
	}

	@Override
	public Expense getExpenseById(Integer id) throws ExpenseException {
		return exr.findById(id)
				.orElseThrow(() -> new ExpenseException("There is no data avilable related to this id " + id));
	}

}
