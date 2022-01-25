package br.com.tevitto.controla_guincho.data.dto;

import java.io.Serializable;
import java.util.Objects;

public class VehicleDto implements Serializable {
    private Long id;
    private String model;
    private String brand;
    private String license_plate;
    private String color;
    private JourneyDto journey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public JourneyDto getJourney() {
        return journey;
    }

    public void setJourney(JourneyDto journey) {
        this.journey = journey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleDto entity = (VehicleDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.model, entity.model) &&
                Objects.equals(this.brand, entity.brand) &&
                Objects.equals(this.license_plate, entity.license_plate) &&
                Objects.equals(this.color, entity.color) &&
                Objects.equals(this.journey, entity.journey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand, license_plate, color, journey);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "model = " + model + ", " +
                "brand = " + brand + ", " +
                "license_plate = " + license_plate + ", " +
                "color = " + color + ", " +
                "journey = " + journey + ")";
    }
}
