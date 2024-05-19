package com.anthonyponte.wallet.repository;

import com.anthonyponte.wallet.model.Categoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Categoria, Integer> {
    @Query("FROM Categoria c ORDER BY c.id")
    public List<Categoria> readAll();
}
