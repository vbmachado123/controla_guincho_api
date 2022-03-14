package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.DashboardDto;
import br.com.tevitto.controla_guincho.data.model.Attendance;
import br.com.tevitto.controla_guincho.data.model.Expense;
import br.com.tevitto.controla_guincho.repository.AttendanceRepository;
import br.com.tevitto.controla_guincho.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private AttendanceService attendanceService;

    public DashboardDto load_data() {

        DashboardDto dto = new DashboardDto();

        double spending = 0, earning = 0, total = 0;

        List<Expense> spendings = expenseRepository.findAll();
        List<Attendance> earnings = attendanceRepository.findAll();

        // Filtrar por período

        for (Expense e : spendings) {
            spending += e.getValue();
            total++;
        }

        for (Attendance a : earnings) {
            earning += a.getValue();
            total++;
        }

        dto.setEarnings(earning);
        dto.setSpending(spending);
        dto.setTotal(total);

        return dto;
    }
}
