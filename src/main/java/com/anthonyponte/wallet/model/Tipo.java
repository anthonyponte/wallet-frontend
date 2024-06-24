package com.anthonyponte.wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tipo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idTipo;

  private String descripcion;

  public Tipo() {}

  public Tipo(Integer idTipo, String descripcion) {
    this.idTipo = idTipo;
    this.descripcion = descripcion;
  }

  public Tipo(String descripcion) {
    this.descripcion = descripcion;
  }

  public Integer getIdTipo() {
    return idTipo;
  }

  public void setIdTipo(Integer idTipo) {
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
