package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.Origin;
import br.com.tevitto.controla_guincho.data.model.Receipt_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface OriginRepository extends JpaRepository<Origin, Long>, JpaSpecificationExecutor<Origin> {

    Optional<Origin> findByDescription(String description);
}