/** template created by jowsnunez --> https://www.github.com/JowsNunez * */
package com.anthonyponte.wallet.repository;

import com.anthonyponte.wallet.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransaccionRepository extends JpaRepository<Transaccion, Integer> {
  @Query("FROM Transaccion t WHERE t.cuenta.idCuenta = ?1 ORDER BY t.fecha")
  public Iterable<Transaccion> findAll(Integer id);
}
