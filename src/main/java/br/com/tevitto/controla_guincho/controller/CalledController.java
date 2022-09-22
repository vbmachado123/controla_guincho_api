package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.CalledDto;
import br.com.tevitto.controla_guincho.data.dto.ExpenseDto;
import br.com.tevitto.controla_guincho.service.CalledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/called")
public class CalledController {

    @Autowired
    private CalledService service;

    @PostMapping
    public ResponseEntity create(@RequestBody List<CalledDto> dtos) {
        return ok(service.create(dtos));
    }

}
