package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.ExpenseDto;
import br.com.tevitto.controla_guincho.exception.ExceptionResponse;
import br.com.tevitto.controla_guincho.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @Operation(summary = "find all expenses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "found the expenses", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExpenseDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            })
    })
    @GetMapping("find_all")
    public ResponseEntity find_all() {
        return ok(service.findAll());
    }

    @Operation(summary = "create a new expense")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "expense created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExpenseDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            })
    })
    @PostMapping
    public ResponseEntity create(@RequestBody ExpenseDto dto) {
        return ok(service.create(dto));
    }

    @Operation(summary = "update a image of expense")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "image updated", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "500", description = "return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            })
    })
    @PostMapping("/upload/{id}")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
        return ok(service.uploadPhoto(file, id));
    }

    @Operation(summary = "export all expenses to excel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "exported to excel", content = {
                    @Content(mediaType = "application/octet-stream")
            }),
            @ApiResponse(responseCode = "500", description = "return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            })
    })
    @CrossOrigin
    @GetMapping("/export")
    public void exportar(HttpServletResponse response) throws IOException {
        service.exportar(response);
    }
}
