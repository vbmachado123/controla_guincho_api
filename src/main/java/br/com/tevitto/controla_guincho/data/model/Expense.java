package br.com.tevitto.controla_guincho.data.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "expense_type_id")
    private Expense_Type expense_type;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String description;
    private double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Expense_Type getExpense_type() {
        return expense_type;
    }

    public void setExpense_type(Expense_Type expense_type) {
        this.expense_type = expense_type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense)) return false;
        Expense expense = (Expense) o;
        return Double.compare(expense.getValue(), getValue()) == 0 && Objects.equals(getId(), expense.getId()) && Objects.equals(getExpense_type(), expense.getExpense_type()) && Objects.equals(getUser(), expense.getUser()) && Objects.equals(getDescription(), expense.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getExpense_type(), getUser(), getDescription(), getValue());
    }
}