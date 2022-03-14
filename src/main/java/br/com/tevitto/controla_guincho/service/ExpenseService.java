package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.ExpenseDto;
import br.com.tevitto.controla_guincho.data.dto.Expense_TypeDto;
import br.com.tevitto.controla_guincho.data.dto.UserDto;
import br.com.tevitto.controla_guincho.data.model.Expense;
import br.com.tevitto.controla_guincho.data.model.Expense_Type;
import br.com.tevitto.controla_guincho.data.model.User;
import br.com.tevitto.controla_guincho.repository.ExpenseRepository;
import br.com.tevitto.controla_guincho.repository.Expense_TypeRepository;
import br.com.tevitto.controla_guincho.repository.UserRepository;
import br.com.tevitto.controla_guincho.util.ExpenseExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    private Expense expense;

    @Autowired
    private Expense_TypeRepository expense_typeRepository;
    private Expense_Type expense_type;

    @Autowired
    private UserRepository userRepository;
    private User user;

    public List<ExpenseDto> findAll() {
        List<ExpenseDto> dtos = new ArrayList<>();
        List<Expense> models = expenseRepository.findAll();

        for (Expense m : models) {
            ExpenseDto dto = new ExpenseDto();
            dto.setDescription(m.getDescription());
            dto.setExpense_type(new Expense_TypeDto(m.getExpense_type().getId(), m.getExpense_type().getDescription()));
            dto.setUser(convertUserToDto(m.getUser()));

            dtos.add(dto);
        }

        return dtos;
    }

    private UserDto convertUserToDto(User model) {
        UserDto dto = new UserDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setPath_img(model.getPath_img());
        dto.setEmail(model.getEmail());
        return dto;
    }

    public ExpenseDto create(ExpenseDto dto) {
        expense = new Expense();
        expense.setValue(dto.getValue());
        expense.setDescription(dto.getDescription());
        expense.setUser(userRepository.getById(dto.getUser().getId()));
        expense.setExpense_type(expense_typeRepository
                .findByDescription(dto.getDescription()).get());

        Expense save = expenseRepository.save(expense);
        dto.setId(save.getId());
        return dto;
    }
    
    public void exportar(HttpServletResponse response) {
        try {
            response.setContentType("application/octet-stream");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());

            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=despesas_" + currentDateTime + ".xlsx";
            response.setHeader(headerKey, headerValue);

            List<Expense> models = expenseRepository.findAll();

            ExpenseExporter excelExporter = new ExpenseExporter(models);
            excelExporter.export(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
