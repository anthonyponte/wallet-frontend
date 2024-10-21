package com.anthonyponte.wallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cuenta {
  public static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idCuenta;

  private String nombre;
  private double inicial;
  private double ingresos;
  private double gastos;
  private double total;

  @OneToOne
  @JoinColumn(name = "idUsuario")
  private Usuario usuario;

  public Cuenta() {
  }

  public Cuenta(Long idCuenta, String nombre, double inicial, double ingresos, double gastos, double total,
      Usuario usuario) {
    this.idCuenta = idCuenta;
    this.nombre = nombre;
    this.inicial = inicial;
    this.ingresos = ingresos;
    this.gastos = gastos;
    this.total = total;
    this.usuario = usuario;
  }

  public Cuenta(String nombre, double inicial, double ingresos, double gastos, double total, Usuario usuario) {
    this.nombre = nombre;
    this.inicial = inicial;
    this.ingresos = ingresos;
    this.gastos = gastos;
    this.total = total;
    this.usuario = usuario;
  }

  public Long getIdCuenta() {
    return idCuenta;
  }

  public void setIdCuenta(Long idCuenta) {
    this.idCuenta = idCuenta;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getInicial() {
    return inicial;
  }

  public void setInicial(double inicial) {
    this.inicial = inicial;
  }

  public double getIngresos() {
    return ingresos;
  }

  public void setIngresos(double ingresos) {
    this.ingresos = ingresos;
  }

  public double getGastos() {
    return gastos;
  }

  public void setGastos(double gastos) {
    this.gastos = gastos;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  @Override
  public String toString() {
    return "Cuenta [idCuenta=" + idCuenta + ", nombre=" + nombre + ", inicial=" + inicial + ", ingresos=" + ingresos
        + ", gastos=" + gastos + ", total=" + total + ", usuario=" + usuario + "]";
  }
}
