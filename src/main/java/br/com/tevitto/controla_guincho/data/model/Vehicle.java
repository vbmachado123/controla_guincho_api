package br.com.tevitto.controla_guincho.data.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String model;
    private String brand; // marca
    private String license_plate;
    private String color;
//    @OneToOne
//    @JoinColumn(name = "journey_id")
//    private Journey journey;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(getId(), vehicle.getId()) && Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getBrand(), vehicle.getBrand()) && Objects.equals(getLicense_plate(), vehicle.getLicense_plate()) && Objects.equals(getColor(), vehicle.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getBrand(), getLicense_plate(), getColor());
    }
}