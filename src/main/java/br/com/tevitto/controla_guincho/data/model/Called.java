package br.com.tevitto.controla_guincho.data.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "called")
public class Called {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String datehour;

    @OneToOne
    private Category category;

    private String description;

    @OneToOne
    private OriginCall origin;

    @OneToOne
    private CallType type;

    @OneToOne
    private DriverCall driver;

    @OneToOne
    private VehicleCall tow_truck;

    private String dateHourInit;

    private String dateHourEnd;

    private Integer kmInit;

    private Integer kmEnd;

    private Double value;

    private String vehicle;

    private String license_plate;

    private Integer number_of_tolls;

    private Double waiting_time;

    public Called() {
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OriginCall getOrigin() {
        return origin;
    }

    public void setOrigin(OriginCall origin) {
        this.origin = origin;
    }

    public CallType getType() {
        return type;
    }

    public void setType(CallType type) {
        this.type = type;
    }

    public DriverCall getDriver() {
        return driver;
    }

    public void setDriver(DriverCall driver) {
        this.driver = driver;
    }

    public VehicleCall getTow_truck() {
        return tow_truck;
    }

    public void setTow_truck(VehicleCall tow_truck) {
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
