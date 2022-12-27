package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.CalledDto;
import br.com.tevitto.controla_guincho.data.dto.ExpenseDto;
import br.com.tevitto.controla_guincho.service.CalledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/called")
public class CalledController {

    @Autowired
    private CalledService service;

    @PostMapping
    public ResponseEntity create(@RequestBody List<CalledDto> dtos) {
        System.out.println(dtos.get(0));
        return ok(service.create(dtos));
    }

    @PostMapping("/create_one")
    public ResponseEntity create_one(@RequestBody CalledDto dto) {
        System.out.println(dto);
        return ok(service.create_one(dto));
    }

    @GetMapping("/last_supply/{id_vehicle}")
    public ResponseEntity getLastSupply(@PathVariable Long id_vehicle) {
        return ok(service.getLastSupply(id_vehicle));
    }

    @GetMapping("/find_all")
    public ResponseEntity find_all() {
        return ok(service.findAll());
    }

    @GetMapping("/find_types")
    public ResponseEntity find_types() {
        return ok(service.findTypes());
    }

    @GetMapping("/find_one/{id}")
    public ResponseEntity find_one(@PathVariable Long id) {
        return ok(service.findOne(id));
    }
}
