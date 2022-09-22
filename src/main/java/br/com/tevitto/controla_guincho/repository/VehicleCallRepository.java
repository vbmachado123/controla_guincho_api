package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.VehicleCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface VehicleCallRepository extends JpaRepository<VehicleCall, Long>, JpaSpecificationExecutor<VehicleCall> {

    Optional<VehicleCall> findByDescription(String description);
}