package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.Receipt_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Receipt_TypeRepository extends JpaRepository<Receipt_Type, Long>, JpaSpecificationExecutor<Receipt_Type> {
}