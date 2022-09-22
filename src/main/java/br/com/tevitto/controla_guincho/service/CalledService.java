package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.CalledDto;
import br.com.tevitto.controla_guincho.data.model.*;
import br.com.tevitto.controla_guincho.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<CalledDto> create(List<CalledDto> dtos) {

        return null;
    }
}
