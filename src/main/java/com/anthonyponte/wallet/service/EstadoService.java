package com.anthonyponte.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anthonyponte.wallet.entity.Estado;
import com.anthonyponte.wallet.repository.IEstadoRepository;

@Component
public class EstadoService implements IEstadoService<Estado> {
    @Autowired
    private IEstadoRepository repository;

    @Override
    public Iterable<Estado> getAll() {
        return repository.findAll();
    }
}
