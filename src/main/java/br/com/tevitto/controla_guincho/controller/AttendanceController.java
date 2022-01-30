package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService service;

//    @GetMapping
//    public ResponseEntity teste() {
//        return ok("API Attendance Check");
//    }





}
