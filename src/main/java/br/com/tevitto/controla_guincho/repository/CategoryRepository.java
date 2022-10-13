package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryRepository extends
        JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
}