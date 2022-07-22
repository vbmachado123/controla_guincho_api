package br.com.tevitto.controla_guincho.data.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class WithdrawalDto implements Serializable {
    private Long id;
    private String address;
    private double latitude;
    private double longitude;
    private double km;
    private LocalDate dateHour;
    private PhotoDto photo;

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

    public LocalDate getDateHour() {
        return dateHour;
    }

    public void setDateHour(LocalDate dateHour) {
        this.dateHour = dateHour;
    }

    public PhotoDto getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoDto photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WithdrawalDto entity = (WithdrawalDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.latitude, entity.latitude) &&
                Objects.equals(this.longitude, entity.longitude) &&
                Objects.equals(this.km, entity.km) &&
                Objects.equals(this.dateHour, entity.dateHour) &&
                Objects.equals(this.photo, entity.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, latitude, longitude, km, dateHour, photo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "address = " + address + ", " +
                "latitude = " + latitude + ", " +
                "longitude = " + longitude + ", " +
                "km = " + km + ", " +
                "dateHour = " + dateHour + ", " +
                "photo = " + photo + ")";
    }
}
