package br.com.tevitto.controla_guincho.data.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AttendanceDto implements Serializable {
    private Long id;
    private String dateHour;
    private double value;
    private ClientDto client;
    private JourneyDto journey;
    private OriginDto origin;
    private ExitDto exit;
    private DeliveryDto delivery;
    private WithdrawalDto withdrawal;
    private double commission;
    private int number_of_tolls;

    private String obs;

    private Receipt_TypeDto receipt_type;

    public AttendanceDto() {
    }

    public AttendanceDto(Long id, String dateHour, double value, ClientDto client, JourneyDto journey, OriginDto origin, ExitDto exit, DeliveryDto delivery, WithdrawalDto withdrawal, double commission, int number_of_tolls, String obs, Receipt_TypeDto receipt_type) {
        this.id = id;
        this.dateHour = dateHour;
        this.value = value;
        this.client = client;
        this.journey = journey;
        this.origin = origin;
        this.exit = exit;
        this.delivery = delivery;
        this.withdrawal = withdrawal;
        this.commission = commission;
        this.number_of_tolls = number_of_tolls;
        this.obs = obs;
        this.receipt_type = receipt_type;
    }

    public Long getId() {
        return id;
    }

    public String getDateHour() {
        return dateHour;
    }

    public double getValue() {
        return value;
    }

    public ClientDto getClient() {
        return client;
    }

    public JourneyDto getJourney() {
        return journey;
    }

    public OriginDto getOrigin() {
        return origin;
    }

    public ExitDto getExit() {
        return exit;
    }

    public DeliveryDto getDelivery() {
        return delivery;
    }

    public WithdrawalDto getWithdrawal() {
        return withdrawal;
    }

    public double getCommission() {
        return commission;
    }

    public int getNumber_of_tolls() {
        return number_of_tolls;
    }

    public Receipt_TypeDto getReceipt_type() {
        return receipt_type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateHour(String dateHour) {
        this.dateHour = dateHour;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public void setJourney(JourneyDto journey) {
        this.journey = journey;
    }

    public void setOrigin(OriginDto origin) {
        this.origin = origin;
    }

    public void setExit(ExitDto exit) {
        this.exit = exit;
    }

    public void setDelivery(DeliveryDto delivery) {
        this.delivery = delivery;
    }

    public void setWithdrawal(WithdrawalDto withdrawal) {
        this.withdrawal = withdrawal;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void setNumber_of_tolls(int number_of_tolls) {
        this.number_of_tolls = number_of_tolls;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setReceipt_type(Receipt_TypeDto receipt_type) {
        this.receipt_type = receipt_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceDto entity = (AttendanceDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.dateHour, entity.dateHour) &&
                Objects.equals(this.value, entity.value) &&
                Objects.equals(this.client, entity.client) &&
                Objects.equals(this.journey, entity.journey) &&
                Objects.equals(this.origin, entity.origin) &&
                Objects.equals(this.exit, entity.exit) &&
                Objects.equals(this.delivery, entity.delivery) &&
                Objects.equals(this.withdrawal, entity.withdrawal) &&
                Objects.equals(this.commission, entity.commission) &&
                Objects.equals(this.number_of_tolls, entity.number_of_tolls) &&
                Objects.equals(this.receipt_type, entity.receipt_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateHour, value, client, journey, origin, exit, delivery, withdrawal, commission, number_of_tolls, receipt_type);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "dateHour = " + dateHour + ", " +
                "value = " + value + ", " +
                "client = " + client + ", " +
                "journey = " + journey + ", " +
                "origin = " + origin + ", " +
                "exit = " + exit + ", " +
                "delivery = " + delivery + ", " +
                "withdrawal = " + withdrawal + ", " +
                "commission = " + commission + ", " +
                "number_of_tolls = " + number_of_tolls + ", " +
                "receipt_type = " + receipt_type + ")";
    }
}
