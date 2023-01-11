package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.JourneyDto;
import br.com.tevitto.controla_guincho.service.JourneyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/journey")
public class JourneyController {

    @Autowired
    JourneyService service;

    @Operation(summary = "Create a Journey for a User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a created journey"),
            @ApiResponse(responseCode = "500", description = "Return an error"),
    })
    @PostMapping
    public ResponseEntity create_journey(@RequestBody JourneyDto dto) {
        return ok(service.saveJourney(dto));
    }

    @Operation(summary = "Find all journeys")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a list of journey"),
            @ApiResponse(responseCode = "500", description = "Return an error"),
    })
    @GetMapping("/findAll")
    public ResponseEntity findAll() {
        List<JourneyDto> results = service.findAll();
        if (!results.isEmpty())
            return ok(results);
        else
            return ResponseEntity.badRequest().body("Nenhuma Jornada encontrada");
    }

    @Operation(summary = "Update a Journey")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a updated journey"),
            @ApiResponse(responseCode = "500", description = "Return an error"),
    })
    @PutMapping("/update/{id}")
    public ResponseEntity update_journey(@RequestBody JourneyDto dto, @PathVariable Long id) {
        boolean updated = service.update_journey(dto, id);

        if (updated)
            return ok(dto);
        else
            return ResponseEntity.badRequest().body("Não foi possível atualizar a jornada");
    }

    @Operation(summary = "Update a Journey - set vehicle")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a updated journey"),
            @ApiResponse(responseCode = "500", description = "Return an error"),
    })
    @PutMapping("/{id}/update_vehicle")
    public ResponseEntity vehicle_journey(@RequestBody JourneyDto dto, @PathVariable Long id) {
        boolean updated = service.vehicle_journey(dto, id);

        if (updated)
            return ok(dto);
        else
            return ResponseEntity.badRequest().body("Não foi possível atualizar a jornada");
    }
}

