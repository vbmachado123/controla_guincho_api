package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.VehicleDto;
import br.com.tevitto.controla_guincho.service.VehicleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
public class VehicleController {

    @Autowired
    private VehicleService service;

    @ApiOperation(value = "Create a Vehicle")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Return a created vehicle", response = VehicleDto.class),
            @ApiResponse(code = 500, message = "Return an error", response = VehicleDto.class),
    })
    @PostMapping
    public ResponseEntity create(@RequestBody VehicleDto vehicleDto) {
        return ok(service.create(vehicleDto));
    }

    @ApiOperation(value = "Find all vehicles")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Return a list of vehicles", response = VehicleDto.class),
            @ApiResponse(code = 500, message = "Return an error", response = VehicleDto.class),
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
