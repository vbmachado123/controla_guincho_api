package br.com.tevitto.controla_guincho.data.dto;

import java.io.Serializable;
import java.util.Objects;

public class Expense_TypeDto implements Serializable {
    private final Long id;
    private final String description;

    public Expense_TypeDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense_TypeDto entity = (Expense_TypeDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "description = " + description + ")";
    }
}
