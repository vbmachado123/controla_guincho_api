package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JourneyRepository extends JpaRepository<Journey, Long>, JpaSpecificationExecutor<Journey> {
}