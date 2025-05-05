package com.anthonyponte.wallet.service;

import com.anthonyponte.wallet.entity.Tipo;
import com.anthonyponte.wallet.repository.TipoRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Component
public class TipoServiceImpl implements TipoService<Tipo> {
  @Autowired
  private TipoRepository repository;

  @Override
  public Iterable<Tipo> getAll() {
    return repository.findAll();
  }

  @Override
  public Tipo getById(Long id) {
    Optional<Tipo> opt = repository.findById(id);
    if (opt.isPresent()) {
      return opt.get();
    }
    return null;
  }

  @Override
  public Tipo create(Tipo entity) {
    return repository.save(entity);
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Override
  public Page<Tipo> getAll(Pageable pageable) {
    return repository.findAll(pageable);
  }
}
