package com.example.cep.proj2.Clases;

import java.util.ArrayList;

//id, nombre_equipo, id_deporte, id_competicion, id_catEdad, id_catNivel, id_sexo, id_entidad,
public class ClaseEquipo {
    private int id;
    private String nombre_equipo;
    private ArrayList<ClaseDeporte> id_deporte;
    private ArrayList<ClaseCompeticion> id_competicion;
    private ArrayList<ClaseCatEdad> id_catEdad;
    private ArrayList<ClaseCatNivel> id_catNivel;
    private ArrayList<ClaseSexo> id_sexo;
   // private ArrayList<>   FALTA ENTIDAD


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public ArrayList<ClaseDeporte> getId_deporte() {
        return id_deporte;
    }

    public void setId_deporte(ArrayList<ClaseDeporte> id_deporte) {
        this.id_deporte = id_deporte;
    }

    public ArrayList<ClaseCompeticion> getId_competicion() {
        return id_competicion;
    }

    public void setId_competicion(ArrayList<ClaseCompeticion> id_competicion) {
        this.id_competicion = id_competicion;
    }

    public ArrayList<ClaseCatEdad> getId_catEdad() {
        return id_catEdad;
    }

    public void setId_catEdad(ArrayList<ClaseCatEdad> id_catEdad) {
        this.id_catEdad = id_catEdad;
    }

    public ArrayList<ClaseCatNivel> getId_catNivel() {
        return id_catNivel;
    }

    public void setId_catNivel(ArrayList<ClaseCatNivel> id_catNivel) {
        this.id_catNivel = id_catNivel;
    }

    public ArrayList<ClaseSexo> getId_sexo() {
        return id_sexo;
    }

    public void setId_sexo(ArrayList<ClaseSexo> id_sexo) {
        this.id_sexo = id_sexo;
    }
}
