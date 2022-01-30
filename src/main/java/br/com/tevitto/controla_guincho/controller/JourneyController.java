package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.service.AttendanceService;
import br.com.tevitto.controla_guincho.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/journey")
public class JourneyController {
    @Autowired
    JourneyService service;


}
