package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.DashboardDto;
import br.com.tevitto.controla_guincho.data.model.Attendance;
import br.com.tevitto.controla_guincho.data.model.Expense;
import br.com.tevitto.controla_guincho.data.model.User;
import br.com.tevitto.controla_guincho.data.model.Vehicle;
import br.com.tevitto.controla_guincho.repository.AttendanceRepository;
import br.com.tevitto.controla_guincho.repository.ExpenseRepository;
import br.com.tevitto.controla_guincho.repository.UserRepository;
import br.com.tevitto.controla_guincho.repository.VehicleRepository;
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
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private UserRepository userRepository;

    public DashboardDto load_data() {

        DashboardDto dto = new DashboardDto();

        double spending = 0, earning = 0, total = 0, totalVehicle = 0, attendances = 0, professionals = 0;

        List<Expense> spendings = expenseRepository.findAll();
        List<Attendance> earnings = attendanceRepository.findAll();

        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<User> users = userRepository.findAll();

        for (User u : users)
            professionals++;

        for (Vehicle v : vehicles)
            totalVehicle++;

        // Filtrar por período
        for (Expense e : spendings) {
            spending += e.getValue();
            total++;
        }

        for (Attendance a : earnings) {
            attendances++;
            earning += a.getValue();
            total++;
        }

        dto.setProfessionals(professionals);
        dto.setAttendances(attendances);
        dto.setVehicles(totalVehicle);
        dto.setSpending(spending);
        dto.setEarnings(earning);
        dto.setTotal(total);

        return dto;
    }
}
