package com.anthonyponte.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.anthonyponte.wallet.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
  @Query("FROM Cuenta c ORDER BY c.idCuenta")
  public List<Cuenta> readAll();

  @Query("FROM Cuenta c WHERE c.idCuenta = ?1")
  public Cuenta read(int id);
}
