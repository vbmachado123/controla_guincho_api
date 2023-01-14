package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.*;
import br.com.tevitto.controla_guincho.data.model.*;
import br.com.tevitto.controla_guincho.exception.FileStorageException;
import br.com.tevitto.controla_guincho.repository.*;
import br.com.tevitto.controla_guincho.util.AttendanceExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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
    JourneyService journeyService;

    @Autowired
    private OriginRepository originRepository;
    private Origin origin;

    @Autowired
    private PhotoRepository photoRepository;
    private Photo photo;

    @Autowired
    private WithdrawalRepository withdrawalRepository;
    private Withdrawal withdrawal;

    @Autowired
    private Receipt_TypeRepository receipt_typeRepository;

    @Autowired
    private FileStorageService fileStorageService;

    public AttendanceDto create_attendance(AttendanceDto dto) {
        attendance = new Attendance();
        attendance = convertAttendanceDto(dto);
        Attendance save = attendanceRepository.save(attendance);
        dto.setId(save.getId());
        return dto;
    }

    public String saveImage(MultipartFile file, Long id, String type) {
        Attendance attendance = attendanceRepository.getById(id);

        Photo photo;

        if (Objects.equals(type, "withdrawal")) photo = attendance.getWithdrawal().getPhoto();
        else if (Objects.equals(type, "delivery")) photo = attendance.getDelivery().getPhoto();
        else if (Objects.equals(type, "exit")) photo = attendance.getExit().getPhoto();
        else throw new FileStorageException("Type not found");

        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String filename = StringUtils.cleanPath(String.format("%s_%s.%s", attendance.getId(), type, extension));

        String path = fileStorageService.storeFile(file, filename);

        photo.setPath(path);
        photoRepository.save(photo);

        return path;
    }

    private Attendance convertAttendanceDto(AttendanceDto dto) {
        Attendance a = new Attendance();

        a.setCommission(dto.getCommission());
        a.setDateHour(dto.getDateHour());
        a.setNumber_of_tolls(dto.getNumber_of_tolls());
        a.setValue(dto.getValue());
        a.setDelivery(convertDeliveryDto(dto.getDelivery()));
        a.setExit(convertExitDto(dto.getExit()));
        a.setJourney(convertJourneyDto(dto.getJourney()));
        a.setOrigin(convertOriginDto(dto.getOrigin()));
        a.setReceipt_type(convertReceiptTypeDto(dto.getReceipt_type()));
        a.setObs(dto.getObs());
        a.setWithdrawal(convertWithdrawalDto(dto.getWithdrawal()));
        a.setClient(convertClientDto(dto.getClient()));

        return a;
    }

    private Withdrawal convertWithdrawalDto(WithdrawalDto dto) {

        withdrawal = new Withdrawal();

        withdrawal.setDateHour(dto.getDateHour());
        withdrawal.setAddress(dto.getAddress());
        withdrawal.setKm(dto.getKm());
        withdrawal.setLatitude(dto.getLatitude());
        withdrawal.setLongitude(dto.getLongitude());
        withdrawal.setPhoto(convertPhotoDto(dto.getPhoto()));

        return withdrawalRepository.save(withdrawal);
    }

    private Photo convertPhotoDto(PhotoDto dto) {

        photo = new Photo();
//        LocalDate date = LocalDate.parse(dto.getDateHour());
//            Date dateTime = date;
        photo.setDateHour(dto.getDateHour());

        photo.setLatitude(dto.getLatitude());
        photo.setLongitude(dto.getLongitude());
        photo.setDescription(dto.getDescription());
        photo.setPath(dto.getPath()); // A principio em base64

        return photoRepository.save(photo);
    }

    private Receipt_Type convertReceiptTypeDto(Receipt_TypeDto dto) {

        Optional<Receipt_Type> optional = receipt_typeRepository.findByDescription(dto.getDescription());
        Receipt_Type receipt_type = new Receipt_Type();
        receipt_type.setDescription(dto.getDescription());

        if (optional.isPresent()) return optional.get();
        else return receipt_typeRepository.save(receipt_type);

    }

    private Origin convertOriginDto(OriginDto dto) {

        origin = new Origin();
        origin.setDescription(dto.getDescription());

        Optional<Origin> optional = originRepository.findByDescription(dto.getDescription());
        if (optional.isPresent()) return optional.get();
        else return originRepository.save(origin);
    }

    private Journey convertJourneyDto(JourneyDto dto) {
        System.out.println("Jornada Inicio: " + dto.getDateHourInit());
        System.out.println("Jornada Fim: " + dto.getDateHourEnd());
        journey = new Journey();

        Optional<Journey> optional = journeyRepository.findById(dto.getId() | 1);

        if (optional.isPresent())
            return optional.get();
        else journey = journeyService.convertJourney(dto);
        return journey;
    }

    private Exit convertExitDto(ExitDto dto) {
        exit = new Exit();
        exit.setDateHour(dto.getDateHour());
        exit.setAddress(dto.getAddress());
        exit.setKm(dto.getKm());
        exit.setLatitude(dto.getLatitude());
        exit.setLongitude(dto.getLongitude());
        exit.setPhoto(convertPhotoDto(dto.getPhoto()));

        return exitRepository.save(exit);
    }

    private Delivery convertDeliveryDto(DeliveryDto dto) {
        delivery = new Delivery();
        delivery.setDateHour(dto.getDateHour());
        delivery.setAddress(dto.getAddress());
        delivery.setKm(dto.getKm());
        delivery.setLatitude(dto.getLatitude());
        delivery.setLongitude(dto.getLongitude());
        delivery.setPhoto(convertPhotoDto(dto.getPhoto()));

        return deliveryRepository.save(delivery);
    }

    private Client convertClientDto(ClientDto dto) {
        Client c = new Client();

        c.setBrand(dto.getBrand());
        c.setColor(dto.getColor());
        c.setLicense_plate(dto.getLicense_plate());
        c.setModel(dto.getModel());
        c.setName(dto.getName());
        c.setPhone(dto.getPhone());
//        c.setId(dto.getId());
        Client cli = clientRepository.save(c);
        dto.setId(cli.getId());
        return c;
    }

    public AttendanceDto update_attendance(AttendanceDto dto) {
        attendance = new Attendance();
        Optional<Attendance> optional = attendanceRepository.findById(dto.getId());
        if (optional.isPresent()) {
            attendance = optional.get();

            attendance.setClient(convertClientDto(dto.getClient()));
            attendanceRepository.save(attendance);
            return dto;
        }

        return null;
    }

    public List<AttendanceDto> create_list_attendance(List<AttendanceDto> dtos) {

        List<AttendanceDto> savedList = new ArrayList<>();

        for (AttendanceDto dto : dtos) {
            AttendanceDto saved = create_attendance(dto);
            savedList.add(saved);
        }

        return savedList;
    }

    public void exportar(HttpServletResponse response) {
        try {
            response.setContentType("application/octet-stream");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());

            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=atendimentos_" + currentDateTime + ".xlsx";
            response.setHeader(headerKey, headerValue);

            List<Attendance> models = attendanceRepository.findAll();

            AttendanceExporter excelExporter = new AttendanceExporter(models);
            excelExporter.export(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AttendanceDto find_one(Long id) {

        Optional<Attendance> optional = attendanceRepository.findById(id);

        if (optional.isPresent()) {
            attendance = new Attendance();
            attendance = optional.get();
            System.out.println("=============================================================================");
            System.out.println("> Jornada ID: " + attendance.getJourney().getId());
            System.out.println("> Saida ID: " + attendance.getExit().getId());
            System.out.println("> Cliente ID: " + attendance.getClient().getId());
            System.out.println("> Retirada ID: " + attendance.getWithdrawal().getId());
            System.out.println("> Entrega ID: " + attendance.getDelivery().getId());
            AttendanceDto dto = convertAttendance(attendance);

            return dto;
        }

        return null;
    }

    private AttendanceDto convertAttendance(Attendance model) {

        AttendanceDto a = new AttendanceDto();

        a.setCommission(model.getCommission());
        a.setDateHour(model.getDateHour());
        a.setNumber_of_tolls(model.getNumber_of_tolls());
        a.setValue(model.getValue());
        a.setClient(convertClient(model.getClient()));
        a.setDelivery(convertDelivery(model.getDelivery()));
        a.setExit(convertExit(model.getExit()));
        a.setJourney(convertJourney(model.getJourney()));
        a.setOrigin(convertOrigin(model.getOrigin()));
        a.setReceipt_type(convertReceiptType(model.getReceipt_type()));
        a.setWithdrawal(convertWithdrawal(model.getWithdrawal()));
        a.setId(model.getId());

        return a;
    }

    private WithdrawalDto convertWithdrawal(Withdrawal model) {

        WithdrawalDto withdrawal = new WithdrawalDto();

        withdrawal.setDateHour(model.getDateHour());
        withdrawal.setAddress(model.getAddress());
        withdrawal.setKm(model.getKm());
        withdrawal.setLatitude(model.getLatitude());
        withdrawal.setLongitude(model.getLongitude());
        withdrawal.setPhoto(convertPhoto(model.getPhoto()));
        withdrawal.setId(model.getId());

        return withdrawal;
    }

    private PhotoDto convertPhoto(Photo model) {

        PhotoDto photo = new PhotoDto();
        photo.setId(model.getId());

//            Date dateTime = date;
        photo.setDateHour(model.getDateHour());
        photo.setLatitude(model.getLatitude());
        photo.setLongitude(model.getLongitude());
        photo.setDescription(model.getDescription());
        photo.setPath(model.getPath());

        return photo;
    }

    private Receipt_TypeDto convertReceiptType(Receipt_Type model) {

        Receipt_TypeDto receipt_type = new Receipt_TypeDto();
        receipt_type.setId(model.getId());
        receipt_type.setDescription(model.getDescription());

        return receipt_type;
    }

    private OriginDto convertOrigin(Origin model) {

        OriginDto origin = new OriginDto();

        origin.setId(model.getId());
        origin.setDescription(model.getDescription());

        return origin;
    }

    private JourneyDto convertJourney(Journey model) {
        return journeyService.convertJourneyDto(model);
    }

    private ExitDto convertExit(Exit model) {
        ExitDto exit = new ExitDto();
        exit.setId(model.getId());
        exit.setDateHour(model.getDateHour());
        exit.setAddress(model.getAddress());
        exit.setKm(model.getKm());
        exit.setLatitude(model.getLatitude());
        exit.setLongitude(model.getLongitude());
        exit.setPhoto(convertPhoto(model.getPhoto()));

        return exit;
    }

    private DeliveryDto convertDelivery(Delivery model) {

        DeliveryDto dto = new DeliveryDto();

        dto.setId(model.getId());
        dto.setDateHour(model.getDateHour());
        dto.setAddress(model.getAddress());
        dto.setKm(model.getKm());
        dto.setLatitude(model.getLatitude());
        dto.setLongitude(model.getLongitude());
        dto.setPhoto(convertPhoto(model.getPhoto()));

        return dto;
    }

    private ClientDto convertClient(Client model) {

        ClientDto c = new ClientDto();

        c.setBrand(model.getBrand());
        c.setColor(model.getColor());
        c.setLicense_plate(model.getLicense_plate());
        c.setModel(model.getModel());
        c.setName(model.getName());
        c.setPhone(model.getPhone());
        c.setId(model.getId());

        return c;
    }

    public List<AttendanceDto> find_all() {
        List<Attendance> models = attendanceRepository.findAll();
        List<AttendanceDto> dtos = new ArrayList<>();

        for (Attendance a : models) {
            AttendanceDto dto = convertAttendance(a);
            dtos.add(dto);
        }

        return dtos;
    }
}
