package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.ExpenseDto;
import br.com.tevitto.controla_guincho.data.dto.Expense_TypeDto;
import br.com.tevitto.controla_guincho.data.model.Expense;
import br.com.tevitto.controla_guincho.data.model.Expense_Type;
import br.com.tevitto.controla_guincho.data.model.User;
import br.com.tevitto.controla_guincho.data.model.Vehicle;
import br.com.tevitto.controla_guincho.repository.ExpenseRepository;
import br.com.tevitto.controla_guincho.repository.Expense_TypeRepository;
import br.com.tevitto.controla_guincho.repository.UserRepository;
import br.com.tevitto.controla_guincho.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private User user;

    @Autowired
    private VehicleRepository vehicleRepository;
    private Vehicle vehicle;

    @Autowired
    private ExpenseRepository expenseRepository;
    private Expense expense;

    @Autowired
    private Expense_TypeRepository expense_typeRepository;
    private Expense_Type expense_type;

    public ExpenseDto create_expense(ExpenseDto dto) {

        dtoToUser(dto.getUser().getId());
        expense = new Expense();
        expense.setUser(user);
        expense.setDescription(dto.getDescription());
        expense.setValue(dto.getValue());
        expense.setExpense_type(dtoToExpenseType(dto.getExpense_type()));

        Expense save = expenseRepository.save(expense);

        dto.setId(save.getId());

        return dto;
    }

    private Expense_Type dtoToExpenseType(Expense_TypeDto dto) {
        expense_type = new Expense_Type();

        Optional<Expense_Type> optional =
                expense_typeRepository
                        .findByDescription(dto.getDescription());

        if (optional.isPresent()) expense_type = optional.get();

        return expense_type;
    }

    protected User dtoToUser(Long id) {
        user = new User();
        user = userRepository.getById(id);
//        user.setId(dto.getUser().getId());
//        user.setEmail(dto.getUser().getEmail());
//        user.setName(dto.getUser().getName());
//        user.setPhone(dto.getUser().getPhone());
        return user;
    }


}
