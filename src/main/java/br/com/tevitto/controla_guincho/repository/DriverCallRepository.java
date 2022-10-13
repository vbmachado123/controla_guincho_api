package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.DriverCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface DriverCallRepository extends JpaRepository<DriverCall, Long>, JpaSpecificationExecutor<DriverCall> {

    Optional<DriverCall> findByDescription(String description);
}