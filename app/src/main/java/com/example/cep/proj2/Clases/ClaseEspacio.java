package com.example.cep.proj2.Clases;

import java.util.ArrayList;

//id, nombre_espacios, precio(int), interior(bool), id_instalaciones
//PRECIO INT O FLOAT??
public class ClaseEspacio {

    private int id;
    private String nombre_espacios;
    private int precio;
    private boolean interior;
    private ArrayList<ClaseInstalacion> id_instalaciones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_espacios() {
        return nombre_espacios;
    }

    public void setNombre_espacios(String nombre_espacios) {
        this.nombre_espacios = nombre_espacios;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isInterior() {
        return interior;
    }

    public void setInterior(boolean interior) {
        this.interior = interior;
    }

    public ArrayList<ClaseInstalacion> getId_instalaciones() {
        return id_instalaciones;
    }

    public void setId_instalaciones(ArrayList<ClaseInstalacion> id_instalaciones) {
        this.id_instalaciones = id_instalaciones;
    }
}
