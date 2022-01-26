package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.model.*;
import br.com.tevitto.controla_guincho.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;
    private Attendance attendance;

    @Autowired
    private ClientRepository clientRepository;
    private Client client;

    @Autowired
    private DeliveryRepository deliveryRepository;
    private Delivery delivery;

    @Autowired
    private ExitRepository exitRepository;
    private Exit exit;

    @Autowired
    private JourneyRepository journeyRepository;
    private Journey journey;

    @Autowired
    private OriginRepository originRepository;
    private Origin origin;

    @Autowired
    private PhotoRepository photoRepository;
    private Photo photo;

    @Autowired
    private WithdrawalRepository withdrawalRepository;
    private Withdrawal withdrawal;


}
