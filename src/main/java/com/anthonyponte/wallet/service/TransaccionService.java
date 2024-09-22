/** template created by jowsnunez --> https://www.github.com/JowsNunez * */
package com.anthonyponte.wallet.service;

import com.anthonyponte.wallet.entity.Transaccion;
import com.anthonyponte.wallet.repository.ITransaccionRepository;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Anthony Ponte <anthonyponte.com>
 */
@Component
public class TransaccionService implements ITransaccionService<Transaccion> {

  @Autowired private ITransaccionRepository _transaccionRepository;

  @Override
  public Iterable<Transaccion> getAll() {
    return _transaccionRepository.findAll();
  }

  @Override
  public Transaccion getById(Integer id) {
    Optional<Transaccion> opt = _transaccionRepository.findById(id);
    return opt.get();
  }

  @Override
  public Transaccion create(Transaccion entity) {
    return _transaccionRepository.save(entity);
  }

  @Override
  public void delete(Integer id) {
    _transaccionRepository.deleteById(id);
  }

  @Override
  public Iterable<Transaccion> getAll(Integer id) {
    return _transaccionRepository.findAll(id);
  }
}
