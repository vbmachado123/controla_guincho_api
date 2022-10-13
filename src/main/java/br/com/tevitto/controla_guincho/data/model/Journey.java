package br.com.tevitto.controla_guincho.data.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "journey")
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String dateHourInit;
    private String dateHourEnd;
    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDateHourInit() {
        return dateHourInit;
    }

    public void setDateHourInit(String dateHourInit) {
        this.dateHourInit = dateHourInit;
    }

    public String getDateHourEnd() {
        return dateHourEnd;
    }

    public void setDateHourEnd(String dateHourEnd) {
        this.dateHourEnd = dateHourEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journey)) return false;
        Journey journey = (Journey) o;
        return Objects.equals(getId(), journey.getId()) && Objects.equals(getUser(), journey.getUser()) && Objects.equals(getDateHourInit(), journey.getDateHourInit()) && Objects.equals(getDateHourEnd(), journey.getDateHourEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getDateHourInit(), getDateHourEnd());
    }
}