package br.com.tevitto.controla_guincho.data.dto;

import java.util.Objects;

public class Feedback_TypeDto {
    private Long id;
    private String description;

    public Feedback_TypeDto() {
    }

    public Feedback_TypeDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(o instanceof Expense_TypeDto)) return false;
        Expense_TypeDto that = (Expense_TypeDto) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription());
    }
}
