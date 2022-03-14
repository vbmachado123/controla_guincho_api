package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.VehicleDto;
import br.com.tevitto.controla_guincho.data.model.Expense;
import br.com.tevitto.controla_guincho.data.model.Vehicle;
import br.com.tevitto.controla_guincho.repository.VehicleRepository;
import br.com.tevitto.controla_guincho.util.ExpenseExporter;
import br.com.tevitto.controla_guincho.util.VehicleExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    private Vehicle vehicle;
    private VehicleDto vehicleDto;


    public VehicleDto create(VehicleDto dto) {

        vehicle = new Vehicle();

        vehicle.setLicense_plate(dto.getLicense_plate());
        vehicle.setModel(dto.getModel());
        vehicle.setBrand(dto.getBrand());
        vehicle.setColor(dto.getColor());

        Vehicle save = vehicleRepository.save(vehicle);
        dto.setId(save.getId());

        return dto;
    }

    public List<VehicleDto> findAll(boolean available) {
        List<Vehicle> models = vehicleRepository.findAll();
        List<VehicleDto> dtos = new ArrayList<>();
        for (Vehicle v : models) {

            VehicleDto dto = new VehicleDto();

            dto.setId(v.getId());
            dto.setLicense_plate(v.getLicense_plate());
            dto.setModel(v.getModel());
            dto.setBrand(v.getBrand());
            dto.setColor(v.getColor());
            dtos.add(dto);
//            if (available) {
//
//            } else {
//
//            }
        }

        return dtos;
    }

    public void exportar(HttpServletResponse response) {
        try {
            response.setContentType("application/octet-stream");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());

            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=veiculos_" + currentDateTime + ".xlsx";
            response.setHeader(headerKey, headerValue);

            List<Vehicle> models = vehicleRepository.findAll();

            VehicleExporter excelExporter = new VehicleExporter(models);
            excelExporter.export(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
