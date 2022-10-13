package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.Feedback_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface Feedback_TypeRepository
        extends JpaRepository<Feedback_Type, Long>, JpaSpecificationExecutor<Feedback_Type> {

    Optional<Feedback_Type> findByDescription(String description);
}
