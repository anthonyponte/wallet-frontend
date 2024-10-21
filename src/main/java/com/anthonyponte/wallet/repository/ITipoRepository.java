package com.anthonyponte.wallet.repository;

import com.anthonyponte.wallet.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoRepository extends JpaRepository<Tipo, Long> {
}
