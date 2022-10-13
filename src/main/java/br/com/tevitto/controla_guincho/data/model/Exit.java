package br.com.tevitto.controla_guincho.data.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "exit_entity")
public class Exit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String address;
    private double latitude, longitude;
    private double km;
    private String dateHour;

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public String getDateHour() {
        return dateHour;
    }

    public void setDateHour(String dateHour) {
        this.dateHour = dateHour;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exit)) return false;
        Exit exit = (Exit) o;
        return Double.compare(exit.getLatitude(), getLatitude()) == 0 && Double.compare(exit.getLongitude(), getLongitude()) == 0 && Double.compare(exit.getKm(), getKm()) == 0 && Objects.equals(getId(), exit.getId()) && Objects.equals(getAddress(), exit.getAddress()) && Objects.equals(getDateHour(), exit.getDateHour()) && Objects.equals(getPhoto(), exit.getPhoto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getLatitude(), getLongitude(), getKm(), getDateHour(), getPhoto());
    }
}