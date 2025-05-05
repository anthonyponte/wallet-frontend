package com.anthonyponte.wallet.repository;

import com.anthonyponte.wallet.entity.Transaccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
  @Query("FROM Transaccion t WHERE t.cuenta.idCuenta = ?1 ORDER BY t.fecha")
  public Iterable<Transaccion> findAll(Long id);
}
