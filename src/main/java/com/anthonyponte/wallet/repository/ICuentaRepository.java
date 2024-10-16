/** template created by jowsnunez --> https://www.github.com/JowsNunez * */
package com.anthonyponte.wallet.repository;

import com.anthonyponte.wallet.entity.Cuenta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta, Integer> {
        public Iterable<Cuenta> findAllByIdUsuario(Integer idUsuario);
}
