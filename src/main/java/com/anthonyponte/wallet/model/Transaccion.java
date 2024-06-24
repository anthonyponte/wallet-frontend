package com.anthonyponte.wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.Date;

@Entity
public class Transaccion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idTransaccion;

  @OneToOne
  @JoinColumn(name = "idCategoria")
  private Categoria categoria;

  private Date fecha;
  private String descripcion;

  @OneToOne
  @JoinColumn(name = "idTipo")
  private Tipo tipo;

  private double importe;

  @OneToOne
  @JoinColumn(name = "idCuenta")
  private Cuenta cuenta;

  public Transaccion() {}

  public Transaccion(
      Categoria categoria,
      Date fecha,
      String descripcion,
      Tipo tipo,
      double importe,
      Cuenta cuenta) {
    this.categoria = categoria;
    this.fecha = fecha;
    this.descripcion = descripcion;
    this.tipo = tipo;
    this.importe = importe;
    this.cuenta = cuenta;
  }

  public Integer getIdTransaccion() {
    return idTransaccion;
  }

  public void setIdTransaccion(Integer idTransaccion) {
    this.idTransaccion = idTransaccion;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public double getImporte() {
    return importe;
  }

  public void setImporte(double importe) {
    this.importe = importe;
  }

  public Cuenta getCuenta() {
    return cuenta;
  }

  public void setCuenta(Cuenta cuenta) {
    this.cuenta = cuenta;
  }

  @Override
  public String toString() {
    return "Transaccion{"
        + "idTransaccion="
        + idTransaccion
        + ", categoria="
        + categoria
        + ", fecha="
        + fecha
        + ", descripcion="
        + descripcion
        + ", tipo="
        + tipo
        + ", importe="
        + importe
        + ", cuenta="
        + cuenta
        + '}';
  }
}
