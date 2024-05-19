package com.anthonyponte.wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cuenta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nombre;
  private double inicial;
  private double ingresos;
  private double gastos;
  private double total;

  public Cuenta() {}

  public Cuenta(
      Integer id, String nombre, double inicial, double ingresos, double gastos, double total) {
    this.id = id;
    this.nombre = nombre;
    this.inicial = inicial;
    this.ingresos = ingresos;
    this.gastos = gastos;
    this.total = total;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getInicial() {
    return this.inicial;
  }

  public void setInicial(double inicial) {
    this.inicial = inicial;
  }

  public double getIngresos() {
    return this.ingresos;
  }

  public void setIngresos(double ingresos) {
    this.ingresos = ingresos;
  }

  public double getGastos() {
    return this.gastos;
  }

  public void setGastos(double gastos) {
    this.gastos = gastos;
  }

  public double getTotal() {
    return this.total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  @Override
  public String toString() {
    return "{"
        + " id='"
        + getId()
        + "'"
        + ", nombre='"
        + getNombre()
        + "'"
        + ", inicial='"
        + getInicial()
        + "'"
        + ", ingresos='"
        + getIngresos()
        + "'"
        + ", gastos='"
        + getGastos()
        + "'"
        + ", total='"
        + getTotal()
        + "'"
        + "}";
  }
}
