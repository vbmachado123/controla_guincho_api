package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.service.CheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/checking_account")
public class CheckingAccountController {

    @Autowired
    CheckingAccountService service;

    @GetMapping("/find_all")
    public ResponseEntity find_all() {
        return ok(service.findAll());
    }

}
