package br.com.tevitto.controla_guincho.data.dto;

import br.com.tevitto.controla_guincho.data.model.*;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class CalledDto {
    private Long id;

    private String datehour;

    private CategoryDto category;

    private String description;

    private OriginCallDto origin;

    private CallTypeDto type;

    private DriverCallDto driver;

    private VehicleCallDto tow_truck;

    private String dateHourInit;

    private String dateHourEnd;

    private int kmInit;

    private int kmEnd;

    private double value;

    private String vehicle;

    private String license_plate;

    private int number_of_tolls;

    private double waiting_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatehour() {
        return datehour;
    }

    public void setDatehour(String datehour) {
        this.datehour = datehour;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OriginCallDto getOrigin() {
        return origin;
    }

    public void setOrigin(OriginCallDto origin) {
        this.origin = origin;
    }

    public CallTypeDto getType() {
        return type;
    }

    public void setType(CallTypeDto type) {
        this.type = type;
    }

    public DriverCallDto getDriver() {
        return driver;
    }

    public void setDriver(DriverCallDto driver) {
        this.driver = driver;
    }

    public VehicleCallDto getTow_truck() {
        return tow_truck;
    }

    public void setTow_truck(VehicleCallDto tow_truck) {
        this.tow_truck = tow_truck;
    }

    public String getDateHourInit() {
        return dateHourInit;
    }

    public void setDateHourInit(String dateHourInit) {
        this.dateHourInit = dateHourInit;
    }

    public String getDateHourEnd() {
        return dateHourEnd;
    }

    public void setDateHourEnd(String dateHourEnd) {
        this.dateHourEnd = dateHourEnd;
    }

    public int getKmInit() {
        return kmInit;
    }

    public void setKmInit(int kmInit) {
        this.kmInit = kmInit;
    }

    public int getKmEnd() {
        return kmEnd;
    }

    public void setKmEnd(int kmEnd) {
        this.kmEnd = kmEnd;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public int getNumber_of_tolls() {
        return number_of_tolls;
    }

    public void setNumber_of_tolls(int number_of_tolls) {
        this.number_of_tolls = number_of_tolls;
    }

    public double getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(double waiting_time) {
        this.waiting_time = waiting_time;
    }
}
