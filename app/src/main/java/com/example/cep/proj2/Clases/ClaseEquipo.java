package com.example.cep.proj2.Clases;

import java.util.ArrayList;

//id, nombre_equipo, id_deporte, id_competicion, id_catEdad, id_catNivel, id_sexo, id_entidad,
public class ClaseEquipo {
    private int id;
    private int id_entidad;
    private String nombre_equipo;
    private int id_deporte;
    private int id_competicion;
    private int id_catEdad;
    private int id_catNivel;
    private int id_sexo;
   // private ArrayList<>   FALTA ENTIDAD


    public int getId() {
        return id;
    }

    public int getId_entidad() {
        return id_entidad;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public int getId_deporte() {
        return id_deporte;
    }

    public int getId_competicion() {
        return id_competicion;
    }

    public int getId_catEdad() {
        return id_catEdad;
    }

    public int getId_catNivel() {
        return id_catNivel;
    }

    public int getId_sexo() {
        return id_sexo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_entidad(int id_entidad) {
        this.id_entidad = id_entidad;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public void setId_deporte(int id_deporte) {
        this.id_deporte = id_deporte;
    }

    public void setId_competicion(int id_competicion) {
        this.id_competicion = id_competicion;
    }

    public void setId_catEdad(int id_catEdad) {
        this.id_catEdad = id_catEdad;
    }

    public void setId_catNivel(int id_catNivel) {
        this.id_catNivel = id_catNivel;
    }

    public void setId_sexo(int id_sexo) {
        this.id_sexo = id_sexo;
    }
}
