package com.anthonyponte.wallet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * @author Anthony Ponte <anthonyponte.com>
 */
@Entity
public class Cuenta {

  public static long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCuenta;

  private String nombre;
  private double inicial;
  private double ingresos;
  private double gastos;
  private double total;

  public Cuenta() {}

  public Cuenta(String nombre, double inicial, double ingresos, double gastos, double total) {
    this.nombre = nombre;
    this.inicial = inicial;
    this.ingresos = ingresos;
    this.gastos = gastos;
    this.total = total;
  }

  public Integer getIdCuenta() {
    return idCuenta;
  }

  public void setIdCuenta(Integer idCuenta) {
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

  @Override
  public String toString() {
    return "Cuenta{"
        + "idCuenta="
        + idCuenta
        + ", nombre="
        + nombre
        + ", inicial="
        + inicial
        + ", ingresos="
        + ingresos
        + ", gastos="
        + gastos
        + ", total="
        + total
        + '}';
  }
}
