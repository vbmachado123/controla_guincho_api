package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.Called;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CalledRepository extends
        JpaRepository<Called, Long>, JpaSpecificationExecutor<Called> {
}