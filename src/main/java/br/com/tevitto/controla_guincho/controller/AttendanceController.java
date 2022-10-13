package br.com.tevitto.controla_guincho.controller;

import br.com.tevitto.controla_guincho.data.dto.AttendanceDto;
import br.com.tevitto.controla_guincho.service.AttendanceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService service;

    @ApiOperation(value = "Create a Attendance for a User")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Return a created attendance", response = AttendanceDto.class),
            @ApiResponse(code = 500, message = "Return an error", response = AttendanceDto.class),
    })
    @PostMapping
    public ResponseEntity create_attendance(@RequestBody AttendanceDto dto) {
//        service.createAttendance(dto);
        return ok(service.create_attendance(dto));
    }

    @ApiOperation(value = "Find all Attendances")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Return an attendance", response = AttendanceDto.class),
            @ApiResponse(code = 500, message = "Return an error", response = AttendanceDto.class),
    })
    @GetMapping("/find_all")
    public ResponseEntity find_all() {
        return ok(service.find_all());
    }

    @ApiOperation(value = "Find one Attendance")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Return an attendance", response = AttendanceDto.class),
            @ApiResponse(code = 500, message = "Return an error", response = AttendanceDto.class),
    })
    @GetMapping("/find_one/{id}")
    public ResponseEntity find_one(@PathVariable Long id) {
        return ok(service.find_one(id));
    }

    @PostMapping("/save_list")
    public ResponseEntity create_list(List<AttendanceDto> dtos) {
        return ok(service.create_list_attendance(dtos));
    }

    @ApiOperation(value = "Create a Attendance for a User")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Return a created attendance", response = AttendanceDto.class),
            @ApiResponse(code = 500, message = "Return an error", response = AttendanceDto.class),
    })
    @PutMapping("/update")
    public ResponseEntity update_attendance(@RequestBody AttendanceDto dto) {
        return ok(service.update_attendance(dto));
    }

    @CrossOrigin
    @GetMapping("/export")
    public void exportar(HttpServletResponse response) throws IOException {
        service.exportar(response);
    }

}
