package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.JourneyDto;
import br.com.tevitto.controla_guincho.service.JourneyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Create a Journey for a User")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Return a created journey", response = JourneyDto.class),
            @ApiResponse(code = 500, message = "Return an error", response = JourneyDto.class),
    })
    @PostMapping
    public ResponseEntity create_journey(@RequestBody JourneyDto dto) {
        return ok(service.saveJourney(dto));
    }

    @ApiOperation(value = "Find all journeys")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Return a list of journey", response = JourneyDto.class),
            @ApiResponse(code = 500, message = "Return an error", response = JourneyDto.class),
    })
    @GetMapping("/findAll")
    public ResponseEntity findAll() {
        List<JourneyDto> results = service.findAll();
        if (!results.isEmpty())
            return ok(results);
        else
            return ResponseEntity.badRequest().body("Nenhuma Jornada encontrada");
    }

    @ApiOperation(value = "Update a Journey")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Return a updated journey", response = JourneyDto.class),
            @ApiResponse(code = 500, message = "Return an error", response = JourneyDto.class),
    })
    @PutMapping("/update/{id}")
    public ResponseEntity update_journey(@RequestBody JourneyDto dto, @PathVariable Long id) {
        boolean updated = service.update_journey(dto, id);

        if (updated)
            return ok(dto);
        else
            return ResponseEntity.badRequest().body("Não foi possível atualizar a jornada");
    }

    @ApiOperation(value = "Update a Journey - set vehicle")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Return a updated journey", response = JourneyDto.class),
            @ApiResponse(code = 500, message = "Return an error", response = JourneyDto.class),
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

