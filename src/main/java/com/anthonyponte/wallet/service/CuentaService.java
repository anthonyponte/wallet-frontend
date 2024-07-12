/** template created by jowsnunez --> https://www.github.com/JowsNunez * */
package com.anthonyponte.wallet.service;

import com.anthonyponte.wallet.entity.Cuenta;
import com.anthonyponte.wallet.repository.ICuentaRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Anthony Ponte <anthonyponte.com>
 */
@Component
public class CuentaService implements ICuentaService<Cuenta> {

  @Autowired private ICuentaRepository _cuentaRepository;

  @Override
  public Iterable<Cuenta> getAll() {
    return _cuentaRepository.findAll();
  }

  @Override
  public Cuenta getById(Integer id) {
    Optional<Cuenta> opt = _cuentaRepository.findById(id);
    return opt.get();
  }

  @Override
  public Cuenta create(Cuenta entity) {
    return _cuentaRepository.save(entity);
  }

  @Override
  public void delete(Integer id) {
    _cuentaRepository.deleteById(id);
  }
}
