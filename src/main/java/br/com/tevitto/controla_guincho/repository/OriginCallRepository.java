package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.Origin;
import br.com.tevitto.controla_guincho.data.model.OriginCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface OriginCallRepository extends JpaRepository<OriginCall, Long>, JpaSpecificationExecutor<OriginCall> {

    Optional<OriginCall> findByDescription(String description);
}