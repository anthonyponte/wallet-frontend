package com.anthonyponte.wallet.service;

import com.anthonyponte.wallet.model.Categoria;
import java.util.List;

import org.springframework.stereotype.Service;

import com.anthonyponte.wallet.model.Transaccion;
import com.anthonyponte.wallet.repository.TransactionRepository;

@Service
public class TransactionService {

  private final TransactionRepository repository;

  public TransactionService(TransactionRepository repository) {
    this.repository = repository;
  }

  public List<Transaccion> readAll(int cuentaId) {
    return repository.readAll(cuentaId);
  }

  public Transaccion save(Transaccion transaccion) {
    return repository.save(transaccion);
  }

  public List<Categoria> readCategories() {
    return repository.readCategories();
  }
}
