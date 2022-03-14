package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.ExpenseDto;
import br.com.tevitto.controla_guincho.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @GetMapping("find_all")
    public ResponseEntity find_all() {
        return ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ExpenseDto dto) {
        return ok(service.create(dto));
    }

    @CrossOrigin
    @GetMapping("/export")
    public void exportar(HttpServletResponse response) throws IOException {
        service.exportar(response);
    }
}
