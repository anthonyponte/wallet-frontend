package com.anthonyponte.wallet.repository;

import com.anthonyponte.wallet.model.Categoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
  @Query("FROM Categoria c ORDER BY c.idCategoria")
  public List<Categoria> readAll();

  @Query("FROM Categoria c WHERE c.idCategoria = ?1")
  public Categoria read(int idCategoria);
}
