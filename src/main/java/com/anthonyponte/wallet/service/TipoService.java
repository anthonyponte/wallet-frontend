package com.anthonyponte.wallet.service;

import com.anthonyponte.wallet.model.Tipo;
import java.util.List;
import org.springframework.stereotype.Service;
import com.anthonyponte.wallet.repository.TipoRepository;

@Service
public class TipoService {
  private final TipoRepository repository;

  public TipoService(TipoRepository repository) {
    this.repository = repository;
  }

  public List<Tipo> readAll() {
    return repository.readAll();
  }

  public Tipo read(int id) {
    return repository.read(id);
  }

  public Tipo save(Tipo tipo) {
    return repository.save(tipo);
  }

  public void delete(int id) {
    repository.deleteById(id);
  }
}
