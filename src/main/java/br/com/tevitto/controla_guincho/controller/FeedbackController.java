package br.com.tevitto.controla_guincho.controller;


import br.com.tevitto.controla_guincho.data.dto.FeedbackDto;
import br.com.tevitto.controla_guincho.service.FeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService service;

    @Operation(summary = "Create an Feedback")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a created feedback"),
            @ApiResponse(responseCode = "500", description = "Return an error"),
    })
    @PostMapping
    public ResponseEntity create_feedback(@RequestBody FeedbackDto dto) {
        return ok(service.saveFeedback(dto));
    }

    @Operation(summary = "Find all journeys")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description= "Return a list of journey"),
            @ApiResponse(responseCode = "500", description = "Return an error"),
    })
    @GetMapping("/findAll")
    public ResponseEntity findAll() {
        List<FeedbackDto> results = service.findAll();
        if (!results.isEmpty())
            return ok(results);
        else
            return ResponseEntity.badRequest().body("Nenhum Feedback encontrada");
    }

}

