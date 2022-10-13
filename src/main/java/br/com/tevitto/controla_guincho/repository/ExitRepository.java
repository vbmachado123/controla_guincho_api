package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.Exit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExitRepository extends JpaRepository<Exit, Long>, JpaSpecificationExecutor<Exit> {
}