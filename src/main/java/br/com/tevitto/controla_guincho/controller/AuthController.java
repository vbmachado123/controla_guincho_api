package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.config.jwt.JwtTokenProvider;
import br.com.tevitto.controla_guincho.config.security.AccountCredentialsVO;
import br.com.tevitto.controla_guincho.repository.UserSystemRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserSystemRepository repository;

    @ApiOperation(value = "Autentica um Usuario e retorna um token")
    @SuppressWarnings("rawtypes")
    @PostMapping(value = "/user", produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity signin(@RequestBody AccountCredentialsVO data) {
        var username = data.getEmail();
        var pasword = data.getPassword();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, pasword));

        var user = repository.findByUsername(username);
        String name = user.getFullName();

        var token = "";

        if (user != null) {
            token = tokenProvider.createToken(username, user.getRoles());
        } else {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }

        Map<Object, Object> model = new HashMap<>();
        model.put("username", username);
//        model.put("passowrd", user.getPassword());
        model.put("token", token);
        model.put("user_id", user.getId());
        model.put("user", name);
        return ok(model);
    }
}