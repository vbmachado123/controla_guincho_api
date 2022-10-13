package br.com.tevitto.controla_guincho.controller;


import br.com.tevitto.controla_guincho.data.dto.FeedbackDto;
import br.com.tevitto.controla_guincho.data.dto.JourneyDto;
import br.com.tevitto.controla_guincho.service.FeedbackService;
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
@RequestMapping("/api/v1/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService service;

    @ApiOperation(value = "Create an Feedback")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Return a created feedback", response = FeedbackDto.class),
            @ApiResponse(code = 500, message = "Return an error", response = FeedbackDto.class),
    })
    @PostMapping
    public ResponseEntity create_feedback(@RequestBody FeedbackDto dto) {
        return ok(service.saveFeedback(dto));
    }

    @ApiOperation(value = "Find all journeys")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Return a list of journey", response = FeedbackDto.class),
            @ApiResponse(code = 500, message = "Return an error", response = FeedbackDto.class),
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

