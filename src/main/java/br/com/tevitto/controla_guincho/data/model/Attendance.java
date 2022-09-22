package br.com.tevitto.controla_guincho.data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String dateHour;
    private double value;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "journey_id")
    private Journey journey;

    @OneToOne
    @JoinColumn(name = "origin_id")
    private Origin origin;

    @OneToOne
    @JoinColumn(name = "exit_id")
    private Exit exit;

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @OneToOne
    @JoinColumn(name = "withdrawal_id")
    private Withdrawal withdrawal;
    private double commission;

    private int number_of_tolls;
    @OneToOne
    @JoinColumn(name = "receipt_type_id")
    private Receipt_Type receipt_type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateHour() {
        return dateHour;
    }

    public void setDateHour(String dateHour) {
        this.dateHour = dateHour;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Exit getExit() {
        return exit;
    }

    public void setExit(Exit exit) {
        this.exit = exit;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Withdrawal getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(Withdrawal withdrawal) {
        this.withdrawal = withdrawal;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public int getNumber_of_tolls() {
        return number_of_tolls;
    }

    public void setNumber_of_tolls(int number_of_tolls) {
        this.number_of_tolls = number_of_tolls;
    }

    public Receipt_Type getReceipt_type() {
        return receipt_type;
    }

    public void setReceipt_type(Receipt_Type receipt_type) {
        this.receipt_type = receipt_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attendance)) return false;
        Attendance that = (Attendance) o;
        return Double.compare(that.getValue(), getValue()) == 0 && Double.compare(that.getCommission(), getCommission()) == 0 && getNumber_of_tolls() == that.getNumber_of_tolls() && Objects.equals(getId(), that.getId()) && Objects.equals(getDateHour(), that.getDateHour()) && Objects.equals(getClient(), that.getClient()) && Objects.equals(getJourney(), that.getJourney()) && Objects.equals(getOrigin(), that.getOrigin()) && Objects.equals(getExit(), that.getExit()) && Objects.equals(getDelivery(), that.getDelivery()) && Objects.equals(getWithdrawal(), that.getWithdrawal()) && Objects.equals(getReceipt_type(), that.getReceipt_type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateHour(), getValue(), getClient(), getJourney(), getOrigin(), getExit(), getDelivery(), getWithdrawal(), getCommission(), getNumber_of_tolls(), getReceipt_type());
    }
}