package com.example.demo.entity;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

    @GeneratedValue
    @Id
    @Column(name="id",unique = true)
    private long id;

    private String usuario;

    private String contrasena;

    private byte rol;

    private boolean activo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public byte getRol() {
        return rol;
    }

    public void setRol(byte rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
