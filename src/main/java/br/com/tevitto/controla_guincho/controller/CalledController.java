package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.CallTypeDto;
import br.com.tevitto.controla_guincho.data.dto.CalledDto;
import br.com.tevitto.controla_guincho.data.dto.ExpenseDto;
import br.com.tevitto.controla_guincho.exception.ExceptionResponse;
import br.com.tevitto.controla_guincho.service.CalledService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/called")
@Tag(name = "Called", description = "Called Routes")
public class CalledController {

    @Autowired
    private CalledService service;

    @Operation(summary = "Create a list of Called")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a created called", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CalledDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @PostMapping
    public ResponseEntity create(@RequestBody List<CalledDto> dtos) {
        System.out.println(dtos.get(0));
        return ok(service.create(dtos));
    }

    @Operation(summary = "Create a called")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a created called", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CalledDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @PostMapping("/create_one")
    public ResponseEntity create_one(@RequestBody CalledDto dto) {
        System.out.println(dto);
        return ok(service.create_one(dto));
    }

    @Operation(summary = "Get the last supply of a vehicle")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return the last supply of a vehicle", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))
            }),
            @ApiResponse(responseCode = "500", description = "Return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @GetMapping("/last_supply/{id_vehicle}")
    public ResponseEntity getLastSupply(@PathVariable Long id_vehicle) {
        return ok(service.getLastSupply(id_vehicle));
    }

    @Operation(summary = "find all called")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a list of called", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CalledDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @GetMapping("/find_all")
    public ResponseEntity find_all() {
        return ok(service.findAll());
    }

    @Operation(summary = "find call types")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a list of call types", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CallTypeDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @GetMapping("/find_types")
    public ResponseEntity find_types() {
        return ok(service.findTypes());
    }

    @Operation(summary = "find called by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a called", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CalledDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @GetMapping("/find_one/{id}")
    public ResponseEntity find_one(@PathVariable Long id) {
        return ok(service.findOne(id));
    }
}
