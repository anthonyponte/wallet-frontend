package com.anthonyponte.wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Transaccion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne private Categoria categoria;
  private Date fecha;
  private String descripcion;
  @ManyToOne private Tipo tipo;
  private double importe;
  @ManyToOne private Cuenta cuenta;

  public Transaccion() {}

  public Transaccion(
      Integer id,
      Categoria categoria,
      Date fecha,
      String descripcion,
      Tipo tipo,
      double importe,
      Cuenta cuenta) {
    this.id = id;
    this.categoria = categoria;
    this.fecha = fecha;
    this.descripcion = descripcion;
    this.tipo = tipo;
    this.importe = importe;
    this.cuenta = cuenta;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Categoria getCategoria() {
    return this.categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public Date getFecha() {
    return this.fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Tipo getTipo() {
    return this.tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public double getImporte() {
    return this.importe;
  }

  public void setImporte(double importe) {
    this.importe = importe;
  }

  public Cuenta getCuenta() {
    return this.cuenta;
  }

  public void setCuenta(Cuenta cuenta) {
    this.cuenta = cuenta;
  }

  @Override
  public String toString() {
    return "{"
        + " id='"
        + getId()
        + "'"
        + ", categoria='"
        + getCategoria()
        + "'"
        + ", fecha='"
        + getFecha()
        + "'"
        + ", descripcion='"
        + getDescripcion()
        + "'"
        + ", tipo='"
        + getTipo()
        + "'"
        + ", importe='"
        + getImporte()
        + "'"
        + ", cuenta='"
        + getCuenta()
        + "'"
        + "}";
  }
}
