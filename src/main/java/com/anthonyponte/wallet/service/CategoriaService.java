package com.anthonyponte.wallet.service;

import com.anthonyponte.wallet.model.Categoria;

import java.util.List;

import org.springframework.stereotype.Service;
import com.anthonyponte.wallet.repository.CategoriaRepository;

@Service
public class CategoriaService {
  private final CategoriaRepository repository;

  public CategoriaService(CategoriaRepository repository) {
    this.repository = repository;
  }

  public List<Categoria> readAll() {
    return repository.readAll();
  }

  public Categoria read(int idCategoria) {
    return repository.read(idCategoria);
  }

  public Categoria save(Categoria categoria) {
    return repository.save(categoria);
  }

  public void delete(int idCategoria) {
    repository.deleteById(idCategoria);
  }
}
