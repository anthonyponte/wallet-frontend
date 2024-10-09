package com.anthonyponte.wallet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anthonyponte.wallet.entity.Usuario;
import com.anthonyponte.wallet.repository.IUsuarioRepository;

@Component
public class UsuarioService implements IUsuarioService<Usuario> {

    @Autowired
    private IUsuarioRepository repository;

    @Override
    public Iterable<Usuario> getAll() {
        return repository.findAll();
    }

    @Override
    public Usuario getById(Integer id) {
        Optional<Usuario> opt = repository.findById(id);
        return opt.get();
    }

    @Override
    public Usuario create(Usuario entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Usuario getByUsername(String username) {
        return repository.findByUsername(username);
    }
}
