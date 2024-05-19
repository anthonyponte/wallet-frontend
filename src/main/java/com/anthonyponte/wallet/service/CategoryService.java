package com.anthonyponte.wallet.service;

import com.anthonyponte.wallet.model.Categoria;
import com.anthonyponte.wallet.repository.CategoryRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  private final CategoryRepository repository;

  public CategoryService(CategoryRepository repository) {
    this.repository = repository;
  }

  public List<Categoria> readAll() {
    return repository.readAll();
  }

  public Categoria save(Categoria categoria) {
    return repository.save(categoria);
  }
}
