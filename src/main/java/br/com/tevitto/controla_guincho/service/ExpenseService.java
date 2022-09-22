package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.*;
import br.com.tevitto.controla_guincho.data.model.Expense;
import br.com.tevitto.controla_guincho.data.model.Expense_Type;
import br.com.tevitto.controla_guincho.data.model.Photo;
import br.com.tevitto.controla_guincho.data.model.User;
import br.com.tevitto.controla_guincho.repository.ExpenseRepository;
import br.com.tevitto.controla_guincho.repository.Expense_TypeRepository;
import br.com.tevitto.controla_guincho.repository.PhotoRepository;
import br.com.tevitto.controla_guincho.repository.UserRepository;
import br.com.tevitto.controla_guincho.util.ExpenseExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
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

    @Autowired
    private PhotoRepository photoRepository;
    private Photo photo;

    public List<ExpenseDto> findAll() {
        List<ExpenseDto> dtos = new ArrayList<>();
        List<Expense> models = expenseRepository.findAll();

        for (Expense m : models) {
            ExpenseDto dto = new ExpenseDto();
            dto.setDescription(m.getDescription());
            dto.setPhoto(convertPhotoToDto(m.getPhoto()));
            dto.setExpense_type(new Expense_TypeDto(m.getExpense_type().getId(), m.getExpense_type().getDescription()));
            dto.setValue(m.getValue());
            dto.setUser(convertUserToDto(userRepository.getById(m.getUser().getId())));

            dtos.add(dto);
        }

        return dtos;
    }

    private PhotoDto convertPhotoToDto(Photo model) {

        PhotoDto dto = new PhotoDto();
        String preffix = "data:image/png;base64," + model.getPath();
        dto.setId(model.getId());
        dto.setDescription(model.getDescription());
        dto.setLatitude(model.getLatitude());
        dto.setLongitude(model.getLongitude());
        dto.setPath(preffix.getBytes());
        dto.setDateHour(model.getDateHour());

        return dto;
    }

    private UserDto convertUserToDto(User model) {
        UserDto dto = new UserDto();
        dto.setId(model.getId());
//        System.out.println(model.getUserSystem().getUserName());
        UserSystemDto systemDto = new UserSystemDto();
        systemDto.setEmail(model.getUserSystem().getUserName());
        systemDto.setNome(model.getUserSystem().getFullName());
//        dto.getUserSystemDto().setEmail(model.getUserSystem().getUserName());
//        dto.getUserSystemDto().setNome();
        dto.setPath_img(model.getPath_img());

        return dto;
    }

    public ExpenseDto create(ExpenseDto dto) {

        expense = new Expense();
        expense.setValue(dto.getValue());
        expense.setDescription(dto.getDescription());
        expense.setUser(userRepository.getById(dto.getUser().getId()));

        expense.setExpense_type(expense_typeRepository
                .findByDescription(dto.getExpense_type().getDescription()).get());
        expense.setPhoto(convertDtoToPhoto(dto.getPhoto()));

        Expense save = expenseRepository.save(expense);
        dto.setId(save.getId());
        return dto;
    }

    private Photo convertDtoToPhoto(PhotoDto dto) {
        Photo photo = new Photo();

        photo.setPath(dto.getPath());
        photo.setLatitude(dto.getLatitude());
        photo.setLongitude(dto.getLongitude());
        System.out.println("> Base64========================================================");
//        Base64.getEncoder().encodeToString(dto.getPath());
        System.out.println(Base64.getEncoder().encodeToString(dto.getPath()));
        try {
//            String replaced = dto.getDateHour().toString().replace("'T'", "");
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//            Date d = output.parse(String.valueOf(dto.getDateHour()));
//            String formattedTime = output.format(d);
//            LocalDate date = LocalDate.parse(dto.getDateHour());
            photo.setDateHour(LocalDateTime.now().toString());
//            Date dateTime = date;
//            photo.setDateHour(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }

//        photo.setDateHour(new Date());
        return photoRepository.save(photo);
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
