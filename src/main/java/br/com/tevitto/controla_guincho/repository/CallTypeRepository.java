package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.CallType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CallTypeRepository extends
        JpaRepository<CallType, Long>, JpaSpecificationExecutor<CallType> {
}