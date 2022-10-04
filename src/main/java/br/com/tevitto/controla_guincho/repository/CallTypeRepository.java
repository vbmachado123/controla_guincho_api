package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.CallType;
import br.com.tevitto.controla_guincho.data.model.DriverCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CallTypeRepository extends
        JpaRepository<CallType, Long>, JpaSpecificationExecutor<CallType> {

    Optional<CallType> findByDescription(String description);
}