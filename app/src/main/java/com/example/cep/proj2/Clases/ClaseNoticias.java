package com.example.cep.proj2.Clases;

import java.io.Serializable;

public class ClaseNoticias implements Serializable {

    int foto;
    String nombre;

    String descripcion;

    public ClaseNoticias(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "ClaseNoticias{" +
                "foto='" + foto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
