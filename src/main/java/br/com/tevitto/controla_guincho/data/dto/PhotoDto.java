package br.com.tevitto.controla_guincho.data.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class PhotoDto implements Serializable {
    private Long id;
    private double latitude;
    private double longitude;
    private byte[] path;

    private String dateHour;
    private String description;

    public PhotoDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public byte[] getPath() {
        return path;
    }

    public void setPath(byte[] path) {
        this.path = path;
    }

    public String getDateHour() {
        return dateHour;
    }

    public void setDateHour(String dateHour) {
        this.dateHour = dateHour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoDto entity = (PhotoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.latitude, entity.latitude) &&
                Objects.equals(this.longitude, entity.longitude) &&
                Objects.equals(this.path, entity.path) &&
                Objects.equals(this.dateHour, entity.dateHour) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, latitude, longitude, path, dateHour, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "latitude = " + latitude + ", " +
                "longitude = " + longitude + ", " +
                "path = " + path + ", " +
                "dateHour = " + dateHour + ", " +
                "description = " + description + ")";
    }
}
