package com.schools.school.service;

import com.schools.school.entity.SchoolExpenditure;
import com.sun.mail.imap.protocol.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolExpenditureService {
    SchoolExpenditure saveExpenditure(SchoolExpenditure schoolExpenditure);
    List< SchoolExpenditure> getAllExpenses();
    SchoolExpenditure updateExpensesById(Long id);
    SchoolExpenditure getExpenseById(Long id);
    void deleteById(Long id);
    SchoolExpenditure calculateUnitCoat(Item item);
    SchoolExpenditure calculateTotalCost(SchoolExpenditure schoolExpenditure);

}
