package com.anthonyponte.wallet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anthonyponte.wallet.model.Cuenta;
import com.anthonyponte.wallet.repository.CuentaRepository;

@Service
public class CuentaService {
  private final CuentaRepository repository;

  public CuentaService(CuentaRepository repository) {
    this.repository = repository;
  }

  public List<Cuenta> readAll() {
    return repository.readAll();
  }

  public Cuenta read(int id) {
    return repository.read(id);
  }

  public Cuenta save(Cuenta cuenta) {
    return repository.save(cuenta);
  }

  public void delete(int id) {
    repository.deleteById(id);
  }
}
