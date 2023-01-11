package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.VehicleDto;
import br.com.tevitto.controla_guincho.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/vehicle")
@Tag(name = "Vehicle", description = "Vehicle API")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @Operation(summary = "Create a Vehicle")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a created vehicle"),
            @ApiResponse(responseCode = "500", description = "Return an error"),
    })
    @PostMapping
    public ResponseEntity create(@RequestBody VehicleDto vehicleDto) {
        return ok(service.create(vehicleDto));
    }

    @Operation(summary = "Find all vehicles")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a list of vehicles"),
            @ApiResponse(responseCode = "500", description = "Return an error"),
    })
    @GetMapping("/findAll/{available}")
    public ResponseEntity findAll(@PathVariable(required = false) boolean available) {
        List<VehicleDto> response = service.findAll(available);
        if (!response.isEmpty())
            return ok(response);
        else
            return badRequest().body("Nenhum Veículo foi encontrado");
    }

    @CrossOrigin
    @GetMapping("/export")
    public void exportar(HttpServletResponse response) throws IOException {
        service.exportar(response);
    }
}
