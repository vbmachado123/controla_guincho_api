package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.ExpenseDto;
import br.com.tevitto.controla_guincho.data.dto.Expense_TypeDto;
import br.com.tevitto.controla_guincho.data.dto.UserDto;
import br.com.tevitto.controla_guincho.data.model.Expense;
import br.com.tevitto.controla_guincho.data.model.Expense_Type;
import br.com.tevitto.controla_guincho.data.model.User;
import br.com.tevitto.controla_guincho.data.model.Vehicle;
import br.com.tevitto.controla_guincho.repository.ExpenseRepository;
import br.com.tevitto.controla_guincho.repository.Expense_TypeRepository;
import br.com.tevitto.controla_guincho.repository.UserRepository;
import br.com.tevitto.controla_guincho.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private User user;
    @Autowired
    private UserSystemService userSystemService;

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

    private boolean passwordDecoder(String dto, String model) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        boolean matches = encoder.matches(dto, model);
        return matches;
    }

    public UserDto auth(UserDto dto) throws Exception {
        user = new User();
        try {
            if (!dto.getUserSystemDto().getEmail().isEmpty()) {
                Optional<User> optional = userRepository.findByEmail(dto.getUserSystemDto().getEmail());
                if (optional.isPresent()) {

                    user = optional.get();
                    if (passwordDecoder(dto.getUserSystemDto().getSenha(), user.getUserSystem().getPassword()))
                        return dto;
                    else throw new Exception("E-mail ou senha inválidos!");
                } else return null;
            } else throw new Exception("E-mail ou senha inválidos!");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    private String passwordEncoder(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode(password);
        return result;
    }

    public UserDto create(UserDto dto) {
        user = new User();
//        user.setName(dto.getName());
        user.setPhone(dto.getPhone());
//        user.setEmail(dto.getEmail());
//        user.setPassword(passwordEncoder(dto.getPassword()));

        userSystemService.createUser(dto.getUserSystemDto());
        user.setPath_img(dto.getPath_img());
        return dto;
    }

    public List<UserDto> find_all() {
        List<UserDto> dtos = new ArrayList<>();
        List<User> models = userRepository.findAll();

        for (User u : models) {
            UserDto dto = new UserDto();

//            dto.setName(u.getName());
            dto.setId(u.getId());
//            dto.setEmail(u.getEmail());
            dto.setPath_img(u.getPath_img());
            dto.setPhone(u.getPhone());
            dto.setUserSystemDto(userSystemService.convertUserSystem(u.getUserSystem()));

            dtos.add(dto);
        }

        return dtos;
    }
}
