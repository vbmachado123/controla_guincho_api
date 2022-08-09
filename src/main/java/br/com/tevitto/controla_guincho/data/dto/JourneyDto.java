package br.com.tevitto.controla_guincho.data.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class JourneyDto implements Serializable {
    private Long id;
    private String dateHourInit;
    private UserDto user;
    private String dateHourEnd;
    private VehicleDto vehicle;

    public JourneyDto() {
    }

    public JourneyDto(Long id, String dateHourInit, UserDto user, String dateHourEnd) {
        this.id = id;
        this.dateHourInit = dateHourInit;
        this.user = user;
        this.dateHourEnd = dateHourEnd;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public String getDateHourInit() {
        return dateHourInit;
    }

    public String getDateHourEnd() {
        return dateHourEnd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateHourInit(String dateHourInit) {
        this.dateHourInit = dateHourInit;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public void setDateHourEnd(String dateHourEnd) {
        this.dateHourEnd = dateHourEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JourneyDto)) return false;
        JourneyDto that = (JourneyDto) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDateHourInit(), that.getDateHourInit()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getDateHourEnd(), that.getDateHourEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateHourInit(), getUser(), getDateHourEnd());
    }
}
