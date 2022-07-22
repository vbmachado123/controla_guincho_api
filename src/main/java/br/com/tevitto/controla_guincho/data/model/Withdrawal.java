package br.com.tevitto.controla_guincho.data.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "withdrawal")
public class Withdrawal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String address;
    private double latitude, longitude;
    private double km;
    private LocalDate dateHour;

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

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

    public LocalDate getDateHour() {
        return dateHour;
    }

    public void setDateHour(LocalDate dateHour) {
        this.dateHour = dateHour;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Withdrawal)) return false;
        Withdrawal that = (Withdrawal) o;
        return Double.compare(that.getLatitude(), getLatitude()) == 0 && Double.compare(that.getLongitude(), getLongitude()) == 0 && Double.compare(that.getKm(), getKm()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getDateHour(), that.getDateHour()) && Objects.equals(getPhoto(), that.getPhoto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress(), getLatitude(), getLongitude(), getKm(), getDateHour(), getPhoto());
    }
}