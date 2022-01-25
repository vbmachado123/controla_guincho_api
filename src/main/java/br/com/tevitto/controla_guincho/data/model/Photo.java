package br.com.tevitto.controla_guincho.data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private double latitude, longitude;
    private String path;
    private Date dateHour;
    private String description;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDateHour() {
        return dateHour;
    }

    public void setDateHour(Date dateHour) {
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
        if (!(o instanceof Photo)) return false;
        Photo photo = (Photo) o;
        return Double.compare(photo.getLatitude(), getLatitude()) == 0 && Double.compare(photo.getLongitude(), getLongitude()) == 0 && Objects.equals(getId(), photo.getId()) && Objects.equals(getPath(), photo.getPath()) && Objects.equals(getDateHour(), photo.getDateHour()) && Objects.equals(getDescription(), photo.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLatitude(), getLongitude(), getPath(), getDateHour(), getDescription());
    }
}