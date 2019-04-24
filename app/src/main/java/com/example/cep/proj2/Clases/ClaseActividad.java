package com.example.cep.proj2.Clases;

import java.util.ArrayList;

//id, nombre_actividad, tipo_entrenament, id_espacios, id_equipos, id_actividades_demandadas, id_administradores, parte_pista
public class ClaseActividad {
    private int id;
    private String nombre_actividad;
    private boolean tipo_entrenament;
    private ArrayList<ClaseEspacio> id_espacios;
    private ArrayList<ClaseEquipo> id_equipos;
    private ArrayList<ClaseActividadDemandada> id_actividad_demandada;
    private ArrayList<ClaseAdministrador> id_administrador;
    private int parte_pista;

    public ClaseActividad() {
    }

    public ClaseActividad(int id, String nombre_actividad, boolean tipo_entrenament, ArrayList<ClaseEspacio> id_espacios, ArrayList<ClaseEquipo> id_equipos, ArrayList<ClaseActividadDemandada> id_actividad_demandada, ArrayList<ClaseAdministrador> id_administrador, int parte_pista) {
        this.id = id;
        this.nombre_actividad = nombre_actividad;
        this.tipo_entrenament = tipo_entrenament;
        this.id_espacios = id_espacios;
        this.id_equipos = id_equipos;
        this.id_actividad_demandada = id_actividad_demandada;
        this.id_administrador = id_administrador;
        this.parte_pista = parte_pista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public void setNombre_actividad(String nombre_actividad) {
        this.nombre_actividad = nombre_actividad;
    }

    public boolean isTipo_entrenament() {
        return tipo_entrenament;
    }

    public void setTipo_entrenament(boolean tipo_entrenament) {
        this.tipo_entrenament = tipo_entrenament;
    }

    public ArrayList<ClaseEspacio> getId_espacios() {
        return id_espacios;
    }

    public void setId_espacios(ArrayList<ClaseEspacio> id_espacios) {
        this.id_espacios = id_espacios;
    }

    public ArrayList<ClaseEquipo> getId_equipos() {
        return id_equipos;
    }

    public void setId_equipos(ArrayList<ClaseEquipo> id_equipos) {
        this.id_equipos = id_equipos;
    }

    public ArrayList<ClaseActividadDemandada> getId_actividad_demandada() {
        return id_actividad_demandada;
    }

    public void setId_actividad_demandada(ArrayList<ClaseActividadDemandada> id_actividad_demandada) {
        this.id_actividad_demandada = id_actividad_demandada;
    }

    public ArrayList<ClaseAdministrador> getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(ArrayList<ClaseAdministrador> id_administrador) {
        this.id_administrador = id_administrador;
    }

    public int getParte_pista() {
        return parte_pista;
    }

    public void setParte_pista(int parte_pista) {
        this.parte_pista = parte_pista;
    }
}
