package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.JourneyDto;
import br.com.tevitto.controla_guincho.data.dto.VehicleDto;
import br.com.tevitto.controla_guincho.data.model.Journey;
import br.com.tevitto.controla_guincho.data.model.User;
import br.com.tevitto.controla_guincho.data.model.Vehicle;
import br.com.tevitto.controla_guincho.repository.JourneyRepository;
import br.com.tevitto.controla_guincho.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JourneyService {

    @Autowired
    private JourneyRepository journeyRepository;
    private Journey journey;

    @Autowired
    private UserService userService;
    private User user;

    @Autowired
    private VehicleRepository vehicleRepository;
    private Vehicle vehicle;

    public JourneyDto saveJourney(JourneyDto dto) {

        user = new User();
        user = userService.dtoToUser(dto.getUser().getId());

        journey = new Journey();
        journey.setUser(user);
        journey.setDateHourInit(dto.getDateHourInit());
        journey.setDateHourEnd(dto.getDateHourEnd());
        journey.setVehicle(dtoToVehicle(dto.getVehicle()));
        Journey save = journeyRepository.save(journey);

        dto.setId(save.getId());

        return dto;
    }

    private Vehicle dtoToVehicle(VehicleDto dto) {

        vehicle = new Vehicle();

        Optional<Vehicle> optional = vehicleRepository.findById(dto.getId());

        if (optional.isEmpty()) {
            vehicle.setBrand(dto.getBrand());
            vehicle.setColor(dto.getColor());
            vehicle.setModel(dto.getModel());
            vehicle.setLicense_plate(dto.getLicense_plate());
            return vehicleRepository.save(vehicle);
        } else
            return vehicle = optional.get();

    }

}
