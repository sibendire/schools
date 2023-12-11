package com.schools.school.service.serviceImpl;

import com.schools.school.entity.SchoolExpenditure;
import com.schools.school.repository.SchoolExpenditureRepository;
import com.schools.school.service.SchoolExpenditureService;
import com.sun.mail.imap.protocol.Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class SchoolExpenditureServiceImpl implements SchoolExpenditureService {
    private final SchoolExpenditureRepository schoolExpenditureRepository;
    @Override
    public SchoolExpenditure saveExpenditure(SchoolExpenditure schoolExpenditure) {
        return schoolExpenditureRepository.save(schoolExpenditure);
    }

    @Override
    public List<SchoolExpenditure> getAllExpenses() {
        return schoolExpenditureRepository.findAll();
    }

    @Override
    public SchoolExpenditure updateExpensesById(Long id) {
        return schoolExpenditureRepository.save(updateExpensesById(id));
    }

    @Override
    public SchoolExpenditure getExpenseById(Long id) {
        return schoolExpenditureRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        schoolExpenditureRepository.deleteById(id);

    }

    @Override
    public SchoolExpenditure calculateUnitCoat(Item item) {
        return null;
    }

    @Override
    public SchoolExpenditure calculateTotalCost(SchoolExpenditure schoolExpenditure) {
        return null;
    }
}
