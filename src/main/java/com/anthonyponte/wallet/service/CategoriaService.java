package com.anthonyponte.wallet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CategoriaService<T> {
  Iterable<T> getAll();

  T getById(Long id);

  T create(T entity);

  void delete(Long id);

  Page<T> getAll(Pageable pageable);
}
