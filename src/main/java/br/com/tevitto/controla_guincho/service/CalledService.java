package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.*;
import br.com.tevitto.controla_guincho.data.model.*;
import br.com.tevitto.controla_guincho.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CalledService {

    @Autowired
    private CalledRepository calledRepository;
    private Called called;

    @Autowired
    private CallTypeRepository callTypeRepository;
    private CallType callType;

    @Autowired
    private CategoryRepository categoryRepository;
    private Category category;

    @Autowired
    private DriverCallRepository driverCallRepository;
    private DriverCall driverCall;

    @Autowired
    private OriginCallRepository originCallRepository;
    private OriginCall originCall;

    @Autowired
    private VehicleCallRepository vehicleCallRepository;
    private VehicleCall vehicleCall;

    /**
     * @param dtos
     * @return List<CalledDto>
     */
    public List<CalledDto> create(List<CalledDto> dtos) {

        List<CalledDto> newDtos = new ArrayList<>();

        for (CalledDto dto : dtos) {

            called = new Called();

            called.setDatehour(dto.getDatehour());
            called.setDescription(dto.getDescription());
            called.setDateHourInit(dto.getDateHourInit());
            called.setDateHourEnd(dto.getDateHourEnd());
            called.setKmInit(dto.getKmInit());
            called.setKmEnd(dto.getKmEnd());
            called.setWaiting_time(dto.getWaiting_time());
            called.setValue(dto.getValue());
            called.setLicense_plate(dto.getLicense_plate());
            called.setNumber_of_tolls(dto.getNumber_of_tolls());
            called.setWaiting_time(dto.getWaiting_time());
            called.setVehicle(dto.getVehicle());
            called.setOrigin(convertOriginDto(dto.getOrigin()));
            called.setDriver(convertDriverDto(dto.getDriver()));
            called.setTow_truck(convertTowTruckDto(dto.getTow_truck()));
            called.setCategory_id(convertCategoryDto(dto.getCategory_id()));
            called.setType(convertTypeDto(dto.getType()));

            Called save = calledRepository.save(called);
            dto.setId(save.getId());
            newDtos.add(dto);
        }

        return newDtos;
    }

    private Category convertCategoryDto(Category dto) {
        category = new Category();

        category = categoryRepository.getById(dto.getId());

        return category;
    }

    private List<VehicleCall> convertTowTruckDto(List<VehicleCallDto> tow_truck) {
        List<VehicleCall> vehicles = new ArrayList<>();

        for (VehicleCallDto dto : tow_truck) {
            vehicleCall = new VehicleCall();

            Optional<VehicleCall> optional = vehicleCallRepository.findByDescription(dto.getDescription());
            if (optional.isPresent()) vehicleCall = optional.get();

            vehicles.add(vehicleCall);
        }

        return vehicles;
    }

    private List<DriverCall> convertDriverDto(List<DriverCallDto> driver) {
        return null;
    }

    private List<OriginCall> convertOriginDto(List<OriginCallDto> origin) {
        return null;
    }

    private List<CallType> convertTypeDto(List<CallTypeDto> type) {
        return null;
    }
}
