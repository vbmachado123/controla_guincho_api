package br.com.tevitto.controla_guincho.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class ExpenseDto implements Serializable {
    private Long id;
    private String description;
    private double value;

    private UserDto user;
    @JsonProperty("expense_type")
    private Expense_TypeDto expense_type;
    private PhotoDto photo;

    public ExpenseDto() {
    }

    public ExpenseDto(Long id, String description, double value, UserDto user, Expense_TypeDto expense_type) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.user = user;
        this.expense_type = expense_type;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Expense_TypeDto getExpense_type() {
        return expense_type;
    }

    public void setExpense_type(Expense_TypeDto expense_type) {
        this.expense_type = expense_type;
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
        if (!(o instanceof ExpenseDto)) return false;
        ExpenseDto that = (ExpenseDto) o;
        return Double.compare(that.getValue(), getValue()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getExpense_type(), that.getExpense_type()) && Objects.equals(getPhoto(), that.getPhoto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getValue(), getUser(), getExpense_type(), getPhoto());
    }
}
