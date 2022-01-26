package br.com.tevitto.controla_guincho.data.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "expense_type")
public class Expense_Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;

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
        if (!(o instanceof Expense_Type)) return false;
        Expense_Type that = (Expense_Type) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription());
    }
}