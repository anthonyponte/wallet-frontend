/** template created by jowsnunez --> https://www.github.com/JowsNunez * */
package com.anthonyponte.wallet.service;

import com.anthonyponte.wallet.entity.Tipo;
import com.anthonyponte.wallet.repository.ITipoRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Component
public class TipoService implements ITipoService<Tipo> {
  @Autowired
  private ITipoRepository _tipoRepository;

  @Override
  public Iterable<Tipo> getAll() {
    return _tipoRepository.findAll();
  }

  @Override
  public Tipo getById(Integer id) {
    Optional<Tipo> opt = _tipoRepository.findById(id);
    return opt.get();
  }

  @Override
  public Tipo create(Tipo entity) {
    return _tipoRepository.save(entity);
  }

  @Override
  public void delete(Integer id) {
    _tipoRepository.deleteById(id);
  }

  @Override
  public Page<Tipo> getAll(Pageable pageable) {
    return _tipoRepository.findAll(pageable);
  }
}
