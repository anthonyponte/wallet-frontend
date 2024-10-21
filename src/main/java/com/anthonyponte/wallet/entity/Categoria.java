package com.anthonyponte.wallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categoria {
  public static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idCategoria;

  private String descripcion;

  public Categoria() {
  }

  public Categoria(Long idCategoria, String descripcion) {
    this.idCategoria = idCategoria;
    this.descripcion = descripcion;
  }

  public Categoria(String descripcion) {
    this.descripcion = descripcion;
  }

  public Long getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Long idCategoria) {
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
