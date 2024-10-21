package com.anthonyponte.wallet.service;

import com.anthonyponte.wallet.entity.Categoria;
import com.anthonyponte.wallet.repository.ICategoriaRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Component
public class CategoriaService implements ICategoriaService<Categoria> {
  @Autowired
  private ICategoriaRepository repository;

  @Override
  public Iterable<Categoria> getAll() {
    return repository.findAll();
  }

  @Override
  public Categoria getById(Long id) {
    Optional<Categoria> opt = repository.findById(id);
    if (opt.isPresent()) {
      return opt.get();
    }
    return null;
  }

  @Override
  public Categoria create(Categoria entity) {
    return repository.save(entity);
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Override
  public Page<Categoria> getAll(Pageable pageable) {
    return repository.findAll(pageable);
  }
}
