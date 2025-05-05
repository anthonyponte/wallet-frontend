package com.anthonyponte.wallet.service;

import org.springframework.stereotype.Service;

@Service
public interface EstadoService<T> {
    Iterable<T> getAll();
}
