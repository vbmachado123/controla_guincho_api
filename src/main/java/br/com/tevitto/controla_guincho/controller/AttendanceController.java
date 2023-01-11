package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.AttendanceDto;
import br.com.tevitto.controla_guincho.exception.ExceptionResponse;
import br.com.tevitto.controla_guincho.service.AttendanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/attendance")
@Tag(name = "Attendance", description = "Attendance Routes")
public class AttendanceController {

    @Autowired
    AttendanceService service;

    @Operation(summary = "Create a Attendance for a User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a created attendance", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AttendanceDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @PostMapping
    public ResponseEntity create_attendance(@RequestBody AttendanceDto dto) {
//        service.createAttendance(dto);
        return ok(service.create_attendance(dto));
    }

    @Operation(summary = "Find all Attendances")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return an attendance", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AttendanceDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @GetMapping("/find_all")
    public ResponseEntity find_all() {
        return ok(service.find_all());
    }

    @Operation(summary = "Find one Attendance")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return an attendance", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AttendanceDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @Parameter(name = "id", description = "Attendance id", required = true)
    @GetMapping("/find_one/{id}")
    public ResponseEntity find_one(@PathVariable Long id) {
        return ok(service.find_one(id));
    }

    @Operation(summary = "Save a list of Attendances")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a list of attendances", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AttendanceDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @PostMapping("/save_list")
    public ResponseEntity create_list(List<AttendanceDto> dtos) {
        return ok(service.create_list_attendance(dtos));
    }

    @Operation(summary = "Create a Attendance for a User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a created attendance", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AttendanceDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "Return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @PutMapping("/update")
    public ResponseEntity update_attendance(@RequestBody AttendanceDto dto) {
        return ok(service.update_attendance(dto));
    }

    @Operation(summary = "export a attendance in excel")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Return a created attendance", content = {
                    @Content(mediaType = "application/octet-stream")
            }),
            @ApiResponse(responseCode = "500", description = "Return an error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class))
            }),
    })
    @CrossOrigin
    @GetMapping("/export")
    public void exportar(HttpServletResponse response) throws IOException {
        service.exportar(response);
    }

}
