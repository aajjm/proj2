package com.example.cep.proj2.Clases;

//id, nombre_instalaciones, diraccion, gestion_publica, altitud, latitut
public class ClaseInstalacion {
    private int id;
    private String nombre_instalaciones;
    private String direccion;
    private boolean gestion_publica;
    private float altitud;
    private float latitud;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_instalaciones() {
        return nombre_instalaciones;
    }

    public void setNombre_instalaciones(String nombre_instalaciones) {
        this.nombre_instalaciones = nombre_instalaciones;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isGestion_publica() {
        return gestion_publica;
    }

    public void setGestion_publica(boolean gestion_publica) {
        this.gestion_publica = gestion_publica;
    }

    public float getAltitud() {
        return altitud;
    }

    public void setAltitud(float altitud) {
        this.altitud = altitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }
}
