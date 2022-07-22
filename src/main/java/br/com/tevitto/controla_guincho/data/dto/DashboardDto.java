package br.com.tevitto.controla_guincho.data.dto;

public class DashboardDto {

    private double attendances;

    private double professionals;

    private double earnings;

    private double spending;

    private double vehicles;

    private double total;

    private int month;

    private int year;

    public DashboardDto() {

    }

    public double getAttendances() {
        return attendances;
    }

    public void setAttendances(double attendances) {
        this.attendances = attendances;
    }

    public double getProfessionals() {
        return professionals;
    }

    public void setProfessionals(double professionals) {
        this.professionals = professionals;
    }

    public double getVehicles() {
        return vehicles;
    }

    public void setVehicles(double vehicles) {
        this.vehicles = vehicles;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public double getSpending() {
        return spending;
    }

    public void setSpending(double spending) {
        this.spending = spending;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
