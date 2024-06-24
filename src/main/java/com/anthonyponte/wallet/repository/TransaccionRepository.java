package com.anthonyponte.wallet.repository;

import com.anthonyponte.wallet.model.Categoria;
import com.anthonyponte.wallet.model.Tipo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.anthonyponte.wallet.model.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {
  @Query("FROM Transaccion t WHERE t.cuenta.idCuenta = ?1 ORDER BY t.fecha")
  public List<Transaccion> readAll(int idCuenta);

  @Query("FROM Tipo c ORDER BY c.idTipo")
  public List<Tipo> readTypes();

  @Query("FROM Categoria c ORDER BY c.idCategoria")
  public List<Categoria> readCategories();
}