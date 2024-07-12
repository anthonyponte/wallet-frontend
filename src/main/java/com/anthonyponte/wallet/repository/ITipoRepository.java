/** template created by jowsnunez --> https://www.github.com/JowsNunez * */
package com.anthonyponte.wallet.repository;

import com.anthonyponte.wallet.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Anthony Ponte <anthonyponte.com>
 */
@Repository
public interface ITipoRepository extends JpaRepository<Tipo, Integer> {}
