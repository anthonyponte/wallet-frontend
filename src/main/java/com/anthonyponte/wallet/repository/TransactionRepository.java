package com.anthonyponte.wallet.repository;

import com.anthonyponte.wallet.model.Categoria;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.anthonyponte.wallet.model.Transaccion;

public interface TransactionRepository extends JpaRepository<Transaccion, Integer> {

  @Query("FROM Transaccion t WHERE t.cuenta.id = ?1 ORDER BY t.fecha")
  public List<Transaccion> readAll(int cuentaId);

  @Query("FROM Categoria c ORDER BY c.descripcion")
  public List<Categoria> readCategories();
}