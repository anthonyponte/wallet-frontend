package com.anthonyponte.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anthonyponte.wallet.entity.Estado;
import com.anthonyponte.wallet.repository.EstadoRepository;

@Component
public class EstadoServiceImpl implements EstadoService<Estado> {
    @Autowired
    private EstadoRepository repository;

    @Override
    public Iterable<Estado> getAll() {
        return repository.findAll();
    }
}
