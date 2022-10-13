package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.DashboardDto;
import br.com.tevitto.controla_guincho.service.DashboardService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @ApiOperation(value = "Get a Dashboard Data")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Return dashboard data", response = DashboardDto.class),
            @ApiResponse(code = 500, message = "Return an error", response = DashboardDto.class),
    })
    @GetMapping("/load_data")
    public ResponseEntity load_data() {
        return ok(service.load_data());
    }

}
