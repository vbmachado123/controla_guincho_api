package br.com.tevitto.controla_guincho.repository;

import br.com.tevitto.controla_guincho.data.model.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long>, JpaSpecificationExecutor<Withdrawal> {
}