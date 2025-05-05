package com.anthonyponte.wallet.service;

import com.anthonyponte.wallet.entity.Cuenta;
import com.anthonyponte.wallet.repository.CuentaRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Component
public class CuentaServiceImpl implements CuentaService<Cuenta> {
  @Autowired
  private CuentaRepository repository;

  @Override
  public Iterable<Cuenta> getAll() {
    return repository.findAll();
  }

  @Override
  public Cuenta getById(Long id) {
    Optional<Cuenta> opt = repository.findById(id);
    if (opt.isPresent()) {
      return opt.get();
    }
    return null;
  }

  @Override
  public Cuenta create(Cuenta entity) {
    return repository.save(entity);
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Override
  public Page<Cuenta> getAll(Pageable pageable) {
    return repository.findAll(pageable);
  }
}
