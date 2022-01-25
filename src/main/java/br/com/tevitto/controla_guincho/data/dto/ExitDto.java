package br.com.tevitto.controla_guincho.data.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ExitDto implements Serializable {
    private final Long id;
    private final String address;
    private final double latitude;
    private final double longitude;
    private final double km;
    private final Date dateHour;
    private final PhotoDto photo;

    public ExitDto(Long id, String address, double latitude, double longitude, double km, Date dateHour, PhotoDto photo) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.km = km;
        this.dateHour = dateHour;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getKm() {
        return km;
    }

    public Date getDateHour() {
        return dateHour;
    }

    public PhotoDto getPhoto() {
        return photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExitDto entity = (ExitDto) o;
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
