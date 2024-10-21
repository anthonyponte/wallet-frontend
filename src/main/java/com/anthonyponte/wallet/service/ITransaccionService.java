package com.anthonyponte.wallet.service;

import org.springframework.stereotype.Service;

@Service
public interface ITransaccionService<T> {
  Iterable<T> getAll();

  T getById(Long id);

  T create(T entity);

  void delete(Long id);

  Iterable<T> getAll(Long id);
}
