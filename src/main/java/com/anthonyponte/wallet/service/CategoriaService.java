/** template created by jowsnunez --> https://www.github.com/JowsNunez * */
package com.anthonyponte.wallet.service;

import com.anthonyponte.wallet.entity.Categoria;
import com.anthonyponte.wallet.repository.ICategoriaRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Anthony Ponte <anthonyponte.com>
 */
@Component
public class CategoriaService implements ICategoriaService<Categoria> {

  @Autowired private ICategoriaRepository _categoriaRepository;

  @Override
  public Iterable<Categoria> getAll() {
    return _categoriaRepository.findAll();
  }

  @Override
  public Categoria getById(Integer id) {
    Optional<Categoria> opt = _categoriaRepository.findById(id);
    return opt.get();
  }

  @Override
  public Categoria create(Categoria entity) {
    return _categoriaRepository.save(entity);
  }

  @Override
  public void delete(Integer id) {
    _categoriaRepository.deleteById(id);
  }
}
