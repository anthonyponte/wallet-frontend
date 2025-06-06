package com.anthonyponte.wallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tipo {
  public static long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idTipo;

  private String descripcion;

  public Tipo() {
  }

  public Tipo(Long idTipo, String descripcion) {
    this.idTipo = idTipo;
    this.descripcion = descripcion;
  }

  public Tipo(String descripcion) {
    this.descripcion = descripcion;
  }

  public Long getIdTipo() {
    return idTipo;
  }

  public void setIdTipo(Long idTipo) {
    this.idTipo = idTipo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public String toString() {
    return "Tipo{" + "idTipo=" + idTipo + ", descripcion=" + descripcion + '}';
  }
}
