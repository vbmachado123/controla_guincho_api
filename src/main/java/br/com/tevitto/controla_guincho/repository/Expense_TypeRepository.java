package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.Expense_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Expense_TypeRepository extends JpaRepository<Expense_Type, Long>, JpaSpecificationExecutor<Expense_Type> {
}