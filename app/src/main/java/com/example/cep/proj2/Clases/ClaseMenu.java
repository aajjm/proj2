package com.example.cep.proj2.Clases;

import java.io.Serializable;

public class ClaseMenu implements Serializable {

    int foto;
    String nombre;



    public ClaseMenu(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public String getNombre() {
        return nombre;
    }


    @Override
    public String toString() {
        return "ClaseMenu{" +
                "foto='" + foto + '\'' +
                ", nombre='" + nombre + '\'' +

                '}';
    }
}
