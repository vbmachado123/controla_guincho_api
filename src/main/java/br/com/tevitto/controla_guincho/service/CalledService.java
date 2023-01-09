package br.com.tevitto.controla_guincho.service;

import br.com.tevitto.controla_guincho.data.dto.*;
import br.com.tevitto.controla_guincho.data.model.*;
import br.com.tevitto.controla_guincho.repository.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
            newDtos.add(create_one(dto));
        }

        return newDtos;
    }

    private Category convertCategoryDto(CategoryDto dto) {
        category = new Category();

        List<Category> categories = new ArrayList<>();
        Optional<Category> optional = categoryRepository.findById(dto.getId());

        System.out.println("Categoria Recebido: " + dto.getId());

        if (optional.isPresent()) categories.add(optional.get());
//        for (CategoryDto d : dto) {
////            category = new Category();
//            System.out.println("Categoria" + d.getId());
//            Optional<Category> optional = categoryRepository.findById(1L);
//
//            if (optional.isPresent()) categories.add(optional.get());
//        }
//        category = categoryRepository.getById(dto.get(0).getId());
//        categories.add(category);

        return optional.get();
    }

    private VehicleCall convertTowTruckDto(VehicleCallDto tow_truck) {
        List<VehicleCall> vehicles = new ArrayList<>();

        vehicleCall = new VehicleCall();

        System.out.println("Veiculo Recebido: " + tow_truck.getId());

        vehicleCall = vehicleCallRepository.getById(tow_truck.getId());
//        for (VehicleCallDto dto : tow_truck) {
//            vehicleCall = new VehicleCall();
//
//            vehicleCall = vehicleCallRepository.getById(dto.getId());
////            Optional<VehicleCall> optional = vehicleCallRepository.findByDescription(dto.getDescription());
////            if (optional.isPresent()) vehicleCall = optional.get();
//
//            vehicles.add(vehicleCall);
//        }

        return vehicleCall;
    }

    private DriverCall convertDriverDto(DriverCallDto dto) {

        List<DriverCall> drivers = new ArrayList<>();

        DriverCall driver = new DriverCall();


        System.out.println("Motorista Recebido: " + dto.getId());

        driver = driverCallRepository.getById(dto.getId());
//        for (DriverCallDto dc : dto) {
//
//            DriverCall driver = new DriverCall();
//
//            driver = driverCallRepository.getById(dc.getId());
////            Optional<DriverCall> optional = driverCallRepository.findByDescription(dc.getDescription());
////
////            if (optional.isPresent()) driver = optional.get();
//
//            drivers.add(driver);
//
//        }

        return driver;
    }

    private OriginCall convertOriginDto(OriginCallDto dto) {

        List<OriginCall> origins = new ArrayList<>();
        OriginCall origin = new OriginCall();

        System.out.println("Origem Recebida: " + dto.getId());
        origin = originCallRepository.getById(dto.getId());
//        for (OriginCallDto oc : dto) {


//            Optional<OriginCall> optional = originCallRepository.findByDescription(oc.getDescription());
//
//            if (optional.isPresent()) origin = optional.get();

//            origins.add(origin);
//
//        }

        return origin;
    }

    private CallType convertTypeDto(CallTypeDto dto) {
//        List<CallType> calltypes = new ArrayList<>();

        CallType call = callTypeRepository.getById(dto.getId());

        System.out.println("CallType Recebido: " + dto.getId());

//        for (CallTypeDto ct : dto) {
//
//            CallType call = new CallType();
//
//            call = callTypeRepository.getById(ct.getId());
////            Optional<CallType> optional =
////                    callTypeRepository.findByDescription(ct.getDescription());
////
////            if (optional.isPresent()) call = optional.get();
//
//            calltypes.add(call);
//        }

        return call;
    }

    public List<CalledDto> findAll() {

        List<CalledDto> dtos = new ArrayList<>();

        List<Called> models = calledRepository.findAll();
        Collections.reverse(models);

        for (Called model : models) {

            try {
                CalledDto dto = new CalledDto();

                dto.setId(model.getId());
                //dto.setDatehour(model.getDatehour().toString());
                dto.setDescription(model.getDescription());

                CallType type = model.getType();
                CallTypeDto callTypeDto = new CallTypeDto();
                callTypeDto.setDescription((type.getDescription().isEmpty() ? "" : type.getDescription()));
                callTypeDto.setId(type.getId());
                dto.setType(callTypeDto);

                try {
                    dto.setKmInit(Math.max(model.getKmInit(), 0));
                    dto.setKmEnd(Math.max(model.getKmEnd(), 0));

                } catch (Exception e) {

                }

                VehicleCallDto tow_truck = new VehicleCallDto();
                tow_truck.setId(model.getTow_truck().getId());
                tow_truck.setDescription(model.getTow_truck().getDescription());
                dto.setTow_truck(tow_truck);
                dto.setValue((model.getValue() <= 0) ? 0 : model.getValue());
//            dto.setNumber_of_tolls(model.getNumber_of_tolls());
                //    dto.setDateHourInit(model.getDateHourInit());
                //    dto.setDateHourEnd(model.getDateHourEnd());

                List<CategoryDto> categoryDtos = new ArrayList<>();
                CategoryDto cdto = new CategoryDto();

                if (model.getCategory() != null) {
                    cdto.setId(model.getCategory().getId());
                    cdto.setDescription(model.getCategory().getDescription());
                    dto.setCategory(cdto);
                } else {
                    dto.setCategory(new CategoryDto());
                }

//            cdto.setId(model.getCategory_id().get(0).getId());
//            cdto.setDescription(model.getCategory_id().get(0).getDescription());
//            categoryDtos.add(cdto);

                List<OriginCallDto> origins = new ArrayList<>();

                OriginCallDto odto = new OriginCallDto();
                odto.setDescription(
                        model.getOrigin().getDescription());
                odto.setId(model.getOrigin().getId());
                origins.add(odto);

                dto.setOrigin(odto);

//            dto.setCategory_id(categoryDtos);

                dtos.add(dto);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return dtos;
    }

    public CallTypesDto findTypes() {

        CallTypesDto callTypesDto = new CallTypesDto();

        List<CallTypeDto> callTypesDtos = new ArrayList<>();
        List<CallType> callTypeModel = callTypeRepository.findAll();

        for (CallType ct : callTypeModel) {
            CallTypeDto dto = new CallTypeDto();
            dto.setId(ct.getId());
            dto.setDescription(ct.getDescription());
            callTypesDtos.add(dto);
        }
        callTypesDto.setCall_types(callTypesDtos);

        List<Category> categoriesModel = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();

        for (Category c : categoriesModel) {
            CategoryDto dto = new CategoryDto();

            dto.setId(c.getId());
            dto.setDescription(c.getDescription());
            categoryDtos.add(dto);
        }

        callTypesDto.setCategories(categoryDtos);

        List<DriverCall> driverModels = driverCallRepository.findAll();
        List<DriverCallDto> driverDtos = new ArrayList<>();

        for (DriverCall dc : driverModels) {
            DriverCallDto dto = new DriverCallDto();

            dto.setId(dc.getId());
            dto.setDescription(dc.getDescription());

            driverDtos.add(dto);
        }

        callTypesDto.setDrivers(driverDtos);

        List<OriginCallDto> originDtos = new ArrayList<>();
        List<OriginCall> originModels = originCallRepository.findAll();

        for (OriginCall oc : originModels) {
            OriginCallDto dto = new OriginCallDto();

            dto.setId(oc.getId());
            dto.setDescription(oc.getDescription());

            originDtos.add(dto);
        }

        callTypesDto.setOrigins(originDtos);

        List<VehicleCallDto> vehicleCallDtos = new ArrayList<>();
        List<VehicleCall> vehicleModels = vehicleCallRepository.findAll();

        for (VehicleCall vc : vehicleModels) {
            VehicleCallDto dto = new VehicleCallDto();

            dto.setId(vc.getId());
            dto.setDescription(vc.getDescription());

            vehicleCallDtos.add(dto);
        }

        callTypesDto.setVehicles(vehicleCallDtos);

        return callTypesDto;
    }

    public CalledDto create_one(CalledDto dto) {
        called = new Called();

        try {
            called.setDatehour(dto.getDatehour());
            called.setDescription(dto.getDescription());
            called.setDateHourInit(dto.getDateHourInit());
            called.setDateHourEnd(dto.getDateHourEnd());
            called.setKmInit((dto.getKmInit() <= 0 ? 0 : dto.getKmInit()));
            called.setKmEnd((dto.getKmEnd()) <= 0 ? 0 : dto.getKmEnd());
            called.setWaiting_time(dto.getWaiting_time());
            called.setValue(dto.getValue());
            called.setLicense_plate(dto.getLicense_plate());
            called.setNumber_of_tolls(dto.getNumber_of_tolls());
            called.setWaiting_time(dto.getWaiting_time());
            called.setVehicle(dto.getVehicle());
            called.setOrigin(convertOriginDto(dto.getOrigin()));
            called.setDriver(convertDriverDto(dto.getDriver()));
            called.setTow_truck(convertTowTruckDto(dto.getTow_truck()));
            called.setCategory(convertCategoryDto(dto.getCategory()));
            called.setType(convertTypeDto(dto.getType()));

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }

        Called save = calledRepository.save(called);
        dto.setId(save.getId());

        return dto;
    }

    public CalledDto findOne(Long id) {
        CalledDto dto = new CalledDto();
        Optional<Called> optional = calledRepository.findById(id);
        if (optional.isPresent()) {
            Called model = optional.get();
            try {
                //CalledDto dto = new CalledDto();

                dto.setId(model.getId());
                dto.setDatehour(model.getDatehour());
//                dto.setDateHourEnd(model.getDateHourEnd());
//                dto.setDateHourInit(model.getDateHourInit());
                dto.setVehicle((model.getVehicle().isEmpty() ? "" : model.getVehicle()));
                dto.setLicense_plate((model.getLicense_plate().isEmpty() ? "" : model.getLicense_plate()));
                dto.setDescription(model.getDescription());

                CallType type = model.getType();
                CallTypeDto callTypeDto = new CallTypeDto();
                callTypeDto.setDescription(type.getDescription());
                callTypeDto.setId(type.getId());
                dto.setType(callTypeDto);

                dto.setValue((model.getValue() <= 0) ? 0 : model.getValue());
//            dto.setNumber_of_tolls(model.getNumber_of_tolls());
//            dto.setDateHourInit(model.getDateHourInit());
//            dto.setDateHourEnd(model.getDateHourEnd());

                List<CategoryDto> categoryDtos = new ArrayList<>();
                CategoryDto cdto = new CategoryDto();

                if (model.getCategory() != null) {
                    cdto.setId(model.getCategory().getId());
                    cdto.setDescription(model.getCategory().getDescription());
                    dto.setCategory(cdto);
                } else {
                    dto.setCategory(new CategoryDto());
                }

//            cdto.setId(model.getCategory_id().get(0).getId());
//            cdto.setDescription(model.getCategory_id().get(0).getDescription());
//            categoryDtos.add(cdto);

                List<OriginCallDto> origins = new ArrayList<>();

                OriginCallDto odto = new OriginCallDto();
                odto.setDescription(
                        model.getOrigin().getDescription());
                odto.setId(model.getOrigin().getId());
                origins.add(odto);

                dto.setOrigin(odto);

//            dto.setCategory_id(categoryDtos);
                //0dtos.add(dto);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dto;

        }

        return new CalledDto();
    }

    public double getLastSupply(Long id_vehicle) {
        List<CalledDto> dtos = findAll();

        originCall = originCallRepository.getById(1L);
        Optional<VehicleCall> optional = vehicleCallRepository.findById(id_vehicle);
        if (optional.isPresent()) vehicleCall = optional.get();
//        expense_typeRepository
        double lastSupply = 0;
        for (CalledDto dto : dtos) {
//            System.out.println("> LastSupply 1: " + dto.getKmEnd());
            if (Objects.equals(dto.getOrigin().getDescription(), originCall.getDescription())) {
                System.out.println("> LastSupply 1: " + dto.getKmEnd());

                if (Objects.equals(dto.getTow_truck().getId(), id_vehicle)) {
                    return dto.getKmEnd();
//                    break;/**/
                }

            }
        }

        return lastSupply;
    }

}
