package com.anthonyponte.wallet.repository;

import com.anthonyponte.wallet.model.Tipo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {
  @Query("FROM Tipo c ORDER BY c.idTipo")
  public List<Tipo> readAll();

  @Query("FROM Tipo c WHERE c.idTipo = ?1")
  public Tipo read(int id);
}
