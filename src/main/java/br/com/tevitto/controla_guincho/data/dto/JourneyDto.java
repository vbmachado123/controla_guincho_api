package br.com.tevitto.controla_guincho.data.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class JourneyDto implements Serializable {
    private Long id;
    private Date dateHourInit;
    private UserDto user;
    private Date dateHourEnd;

    public JourneyDto() {
    }

    public JourneyDto(Long id, Date dateHourInit, UserDto user, Date dateHourEnd) {
        this.id = id;
        this.dateHourInit = dateHourInit;
        this.user = user;
        this.dateHourEnd = dateHourEnd;
    }

    public Long getId() {
        return id;
    }

    public Date getDateHourInit() {
        return dateHourInit;
    }

    public Date getDateHourEnd() {
        return dateHourEnd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateHourInit(Date dateHourInit) {
        this.dateHourInit = dateHourInit;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public void setDateHourEnd(Date dateHourEnd) {
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
