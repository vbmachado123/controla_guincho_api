package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserSystemRepository extends JpaRepository<UserSystem, Long>, JpaSpecificationExecutor<UserSystem> {

    // Para o login, procura pelo nome(email) do Usuario
    @Query("SELECT u FROM UserSystem u WHERE u.userName =:userName")
    UserSystem findByUsername(String userName);
}