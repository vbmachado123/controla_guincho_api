package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OriginRepository extends JpaRepository<Origin, Long>, JpaSpecificationExecutor<Origin> {
}