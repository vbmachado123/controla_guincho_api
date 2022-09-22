package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.AttendanceDto;
import br.com.tevitto.controla_guincho.data.dto.CheckingAccountDto;
import br.com.tevitto.controla_guincho.data.dto.ExpenseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckingAccountService {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private ExpenseService expenseService;


    public List<CheckingAccountDto> findAll() {

        List<CheckingAccountDto> caDto = new ArrayList<>();

        List<AttendanceDto> attendances = attendanceService.find_all();
        List<ExpenseDto> expenses = expenseService.findAll();

        int size = attendances.size() + expenses.size();

        try {
            for (AttendanceDto a : attendances) {
                CheckingAccountDto dto = new CheckingAccountDto();

                dto.setLabel(a.getClient().getName());
                dto.setDateHour(a.getDateHour());
                dto.setAttendance(a);
                dto.setType(1);

                caDto.add(dto);
            }

            for (ExpenseDto e : expenses) {
                CheckingAccountDto dto = new CheckingAccountDto();

                dto.setLabel(e.getDescription());


                dto.setDateHour(e.getPhoto().getDateHour());
                dto.setExpense(e);

                caDto.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return caDto;
    }
}
