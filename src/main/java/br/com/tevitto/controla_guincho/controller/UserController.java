package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.UserDto;
import br.com.tevitto.controla_guincho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService service;

    @CrossOrigin
    @PostMapping("/auth")
    public ResponseEntity auth(@RequestBody UserDto dto) {
        try {
            UserDto response = service.auth(dto);
            if (response.getName().isEmpty() || response.hashCode() <= 0)
                return ResponseEntity.badRequest().body("Usuário ou senha inválidos");
            else
                return ok(response);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível realizar a operação: " + e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody UserDto dto) {
        return ok(service.create(dto));
    }

    @GetMapping("/find_all")
    public ResponseEntity find_all() {

        List<UserDto> response = service.find_all();
        try {
            if (response.isEmpty()) return ResponseEntity.badRequest().body("Nenhum Usuário encontrado");
            else return ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Nenhum Usuário encontrado");
        }
    }
}
