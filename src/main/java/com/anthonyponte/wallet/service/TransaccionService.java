package com.anthonyponte.wallet.service;

import com.anthonyponte.wallet.model.Categoria;
import com.anthonyponte.wallet.model.Tipo;
import java.util.List;

import org.springframework.stereotype.Service;

import com.anthonyponte.wallet.model.Transaccion;
import com.anthonyponte.wallet.repository.TransaccionRepository;

@Service
public class TransaccionService {
  private final TransaccionRepository repository;

  public TransaccionService(TransaccionRepository repository) {
    this.repository = repository;
  }

  public List<Transaccion> readAll(int idCuenta) {
    return repository.readAll(idCuenta);
  }

  public Transaccion save(Transaccion transaccion) {
    return repository.save(transaccion);
  }

  public List<Tipo> readTypes() {
    return repository.readTypes();
  }

  public List<Categoria> readCategories() {
    return repository.readCategories();
  }
}
