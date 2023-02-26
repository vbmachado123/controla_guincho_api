package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.JourneyDto;
import br.com.tevitto.controla_guincho.data.dto.UserDto;
import br.com.tevitto.controla_guincho.data.dto.UserSystemDto;
import br.com.tevitto.controla_guincho.data.dto.VehicleDto;
import br.com.tevitto.controla_guincho.data.model.Journey;
import br.com.tevitto.controla_guincho.data.model.User;
import br.com.tevitto.controla_guincho.data.model.Vehicle;
import br.com.tevitto.controla_guincho.repository.JourneyRepository;
import br.com.tevitto.controla_guincho.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<JourneyDto> findAll() {
        List<JourneyDto> dtos = new ArrayList<>();
        List<Journey> models = journeyRepository.findAll();
        for (Journey j : models) {
            JourneyDto dto = new JourneyDto();
            dto.setUser(userToDto(j.getUser()));
            dto.setDateHourInit(dto.getDateHourInit());
            journey.setDateHourEnd(dto.getDateHourEnd());
            journey.setVehicle(dtoToVehicle(dto.getVehicle()));

        }

        return dtos;
    }

    private UserDto userToDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserSystemDto(new UserSystemDto());

        dto.setId(user.getId());
        dto.getUserSystemDto().setEmail(user.getUserSystem().getUserName());
        dto.getUserSystemDto().setNome(user.getUserSystem().getFullName());
        dto.setPhone(user.getPhone());
        dto.setPath_img(user.getPath_img());
        return dto;
    }

    public boolean update_journey(JourneyDto dto, Long id) {

        journey = new Journey();
        journey = journeyRepository.getById(id);
        journey.setVehicle(vehicleRepository.getById(dto.getVehicle().getId()));
        journey.setDateHourEnd(dto.getDateHourEnd());

        journeyRepository.save(journey);

        return true;
    }

    public Journey convertJourney(JourneyDto dto) {

        Optional<Journey> optional = journeyRepository.findById(dto.getId());

        if (optional.isPresent()) return optional.get();

        else return null;
    }

    public JourneyDto convertJourneyDto(Journey model) {

        JourneyDto journey = new JourneyDto();

        journey.setId(model.getId());
        journey.setVehicle(convertVehicleToDto(model.getVehicle()));
        journey.setDateHourEnd(model.getDateHourEnd());
        journey.setDateHourInit(model.getDateHourInit());
        journey.setUser(userToDto(model.getUser()));

        return journey;
    }

    private VehicleDto convertVehicleToDto(Vehicle model) {

        VehicleDto vehicle = new VehicleDto();

        vehicle.setId(model.getId());
        vehicle.setBrand(model.getBrand());
        vehicle.setColor(model.getColor());
        vehicle.setModel(model.getModel());
        vehicle.setLicense_plate(model.getLicense_plate());

        return vehicle;
    }

    public boolean vehicle_journey(JourneyDto dto, Long id) {

        journey = new Journey();
        journey = journeyRepository.getById(id);
        journey.setVehicle(vehicleRepository.getById(dto.getVehicle().getId()));
//        journey.setDateHourEnd(dto.getDateHourEnd());

        journeyRepository.save(journey);

        return true;
    }
}
