package br.com.tevitto.controla_guincho.data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String address;
    private double latitude, longitude;
    private double km;
    private Date dateHour;

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

    public Date getDateHour() {
        return dateHour;
    }

    public void setDateHour(Date dateHour) {
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
        if (!(o instanceof Delivery)) return false;
        Delivery delivery = (Delivery) o;
        return Double.compare(delivery.getLatitude(), getLatitude()) == 0 && Double.compare(delivery.getLongitude(), getLongitude()) == 0 && Double.compare(delivery.getKm(), getKm()) == 0 && Objects.equals(getId(), delivery.getId()) && Objects.equals(getAddress(), delivery.getAddress()) && Objects.equals(getDateHour(), delivery.getDateHour()) && Objects.equals(getPhoto(), delivery.getPhoto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getLatitude(), getLongitude(), getKm(), getDateHour(), getPhoto());
    }
}