package com.anthonyponte.wallet.service;

import org.springframework.stereotype.Service;

@Service
public interface IEstadoService<T> {
    Iterable<T> getAll();
}
