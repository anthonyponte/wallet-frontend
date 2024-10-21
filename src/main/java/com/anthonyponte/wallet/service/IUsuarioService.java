package com.anthonyponte.wallet.service;

import org.springframework.stereotype.Service;

@Service
public interface IUsuarioService<T> {
  Iterable<T> getAll();

  T getById(Long id);

  T create(T entity);

  void delete(Long id);

  T getByUsername(String username);
}
