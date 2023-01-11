package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.service.CheckingAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(summary = "get all checking account")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a list of checking account"),
            @ApiResponse(responseCode = "500", description = "Return an error"),
    })
    @GetMapping("/find_all")
    public ResponseEntity find_all() {
        return ok(service.findAll());
    }

}
