package com.anthonyponte.wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String descripcion;

  public Categoria() {}

  public Categoria(Integer id, String descripcion) {
    this.id = id;
    this.descripcion = descripcion;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", descripcion='" + getDescripcion() + "'" + "}";
  }
}
