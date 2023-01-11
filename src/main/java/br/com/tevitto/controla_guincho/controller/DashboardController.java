package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.DashboardDto;
import br.com.tevitto.controla_guincho.service.DashboardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get a Dashboard Data")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return dashboard data", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DashboardDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Return an error"),
    })
    @GetMapping("/load_data")
    public ResponseEntity load_data() {
        return ok(service.load_data());
    }

}
