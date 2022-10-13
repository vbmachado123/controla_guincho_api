package br.com.tevitto.controla_guincho.data.dto;

import java.io.Serializable;
import java.util.Objects;

public class ClientDto implements Serializable {

    private Long id;
    private String name;
    private String phone;
    private String model;
    private String brand;
    private String license_plate;
    private String color;

    public ClientDto() {
    }

    public ClientDto(Long id, String name, String phone, String model, String brand, String license_plate, String color) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.model = model;
        this.brand = brand;
        this.license_plate = license_plate;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public String getColor() {
        return color;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto entity = (ClientDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.model, entity.model) &&
                Objects.equals(this.brand, entity.brand) &&
                Objects.equals(this.license_plate, entity.license_plate) &&
                Objects.equals(this.color, entity.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, model, brand, license_plate, color);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "phone = " + phone + ", " +
                "model = " + model + ", " +
                "brand = " + brand + ", " +
                "license_plate = " + license_plate + ", " +
                "color = " + color + ")";
    }
}
