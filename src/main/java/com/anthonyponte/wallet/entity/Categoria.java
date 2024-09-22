package com.anthonyponte.wallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author Anthony Ponte <anthonyponte.com>
 */
@Entity
public class Categoria {

  public static long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCategoria;

  private String descripcion;

  public Categoria() {}

  public Categoria(String descripcion) {
    this.descripcion = descripcion;
  }

  public Integer getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Integer idCategoria) {
    this.idCategoria = idCategoria;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public String toString() {
    return "Categoria{" + "idCategoria=" + idCategoria + ", descripcion=" + descripcion + '}';
  }
}
