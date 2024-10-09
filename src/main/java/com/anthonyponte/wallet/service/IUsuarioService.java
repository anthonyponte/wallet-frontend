package com.anthonyponte.wallet.service;

import org.springframework.stereotype.Service;

@Service
public interface IUsuarioService<T> {
  Iterable<T> getAll();

  T getById(Integer id);

  T create(T entity);

  void delete(Integer id);

  T getByUsername(String username);
}
