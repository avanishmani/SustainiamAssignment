package com.sustainium.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sustainium.Model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}
