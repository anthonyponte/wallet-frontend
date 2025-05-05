package com.anthonyponte.wallet.service;

import com.anthonyponte.wallet.entity.Transaccion;
import com.anthonyponte.wallet.repository.TransaccionRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class TransaccionServiceImpl implements TransaccionService<Transaccion> {
  @Autowired
  private TransaccionRepository repository;

  @Override
  public Iterable<Transaccion> getAll() {
    return repository.findAll();
  }

  @Override
  public Transaccion getById(Long id) {
    Optional<Transaccion> opt = repository.findById(id);
    if (opt.isPresent()) {
      return opt.get();
    }
    return null;
  }

  @Override
  public Transaccion create(Transaccion entity) {
    return repository.save(entity);
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Override
  public Iterable<Transaccion> getAll(Long id) {
    return repository.findAll(id);
  }
}
