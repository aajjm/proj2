package com.example.cep.proj2.Clases;

import java.util.ArrayList;
import java.util.List;

public class ClaseTelefono {
    private int id;
    private int telefono1;
    private int id_entidad;
    private String propietario;
    private String temporada_entidad;
    private ArrayList<ClaseEntidad> entidad;
    public ClaseTelefono(){}
    public ClaseTelefono(int id, int telefono1, int id_entidad, String propietario, String temporada_entidad, ArrayList<ClaseEntidad> entidad) {
        this.id = id;
        this.telefono1 = telefono1;
        this.id_entidad = id_entidad;
        this.propietario = propietario;
        this.temporada_entidad = temporada_entidad;
        this.entidad = entidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    public int getId_entidad() {
        return id_entidad;
    }

    public void setId_entidad(int id_entidad) {
        this.id_entidad = id_entidad;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getTemporada_entidad() {
        return temporada_entidad;
    }

    public void setTemporada_entidad(String temporada_entidad) {
        this.temporada_entidad = temporada_entidad;
    }

    public ArrayList<ClaseEntidad> getEntidad() {
        return entidad;
    }

    public void setEntidad(ArrayList<ClaseEntidad> entidad) {
        this.entidad = entidad;
    }
}
