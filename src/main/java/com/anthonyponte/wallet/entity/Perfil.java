package com.anthonyponte.wallet.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Perfil {
    public static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerfil;

    private String descripcion;

    @ManyToMany(mappedBy = "perfiles")
    Set<Usuario> usuarios = new HashSet<>();

    public Perfil() {
    }

    public Perfil(Long idPerfil, String descripcion) {
        this.idPerfil = idPerfil;
        this.descripcion = descripcion;
    }

    public Perfil(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    @Override
    public String toString() {
        return "Perfil [idPerfil=" + idPerfil + ", descripcion=" + descripcion + ", usuarios=" + usuarios + "]";
    }
}
