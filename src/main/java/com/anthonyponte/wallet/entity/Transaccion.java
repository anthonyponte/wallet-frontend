package com.anthonyponte.wallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Transaccion {
  public static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idTransaccion;

  @OneToOne
  @JoinColumn(name = "idCategoria")
  private Categoria categoria;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate fecha;
  private String descripcion;

  @OneToOne
  @JoinColumn(name = "idTipo")
  private Tipo tipo;

  private double importe;

  @OneToOne
  @JoinColumn(name = "idCuenta")
  private Cuenta cuenta;

  public Transaccion() {
  }

  public Transaccion(Long idTransaccion, Categoria categoria, LocalDate fecha, String descripcion, Tipo tipo,
      double importe, Cuenta cuenta) {
    this.idTransaccion = idTransaccion;
    this.categoria = categoria;
    this.fecha = fecha;
    this.descripcion = descripcion;
    this.tipo = tipo;
    this.importe = importe;
    this.cuenta = cuenta;
  }

  public Transaccion(Categoria categoria, LocalDate fecha, String descripcion, Tipo tipo, double importe, Cuenta cuenta) {
    this.categoria = categoria;
    this.fecha = fecha;
    this.descripcion = descripcion;
    this.tipo = tipo;
    this.importe = importe;
    this.cuenta = cuenta;
  }

  public Long getIdTransaccion() {
    return idTransaccion;
  }

  public void setIdTransaccion(Long idTransaccion) {
    this.idTransaccion = idTransaccion;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
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
