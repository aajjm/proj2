package com.example.cep.proj2.Clases;

import java.util.ArrayList;
import java.util.List;

public class ClaseEntidad {
    private int id;
    private String nombre;
    private String temporada;
    private  String direccion;
    private String NIF;
    private String correo;
    private String video;
    private String altitud;
    private String latitud;
    private String contraseña;
    private ArrayList<ClaseTelefono> telefono;


   private ArrayList<ClaseEquipo> equipo;
    public ClaseEntidad(){

    }
    public ClaseEntidad(int id, String nombre, String temporada, String direccion, String NIF, String correo, String video, String altitud, String latitud, String contraseña, ArrayList<ClaseTelefono> telefono, ArrayList<ClaseEquipo> equipo) {
        this.id = id;
        this.nombre = nombre;
        this.temporada = temporada;
        this.direccion = direccion;
        this.NIF = NIF;
        this.correo = correo;
        this.video = video;
        this.altitud = altitud;
        this.latitud = latitud;
        this.contraseña = contraseña;
        this.telefono = telefono;
       this.equipo = equipo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTemporada() {
        return temporada;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNIF() {
        return NIF;
    }

    public String getCorreo() {
        return correo;
    }

    public String getVideo() {
        return video;
    }

    public String getAltitud() {
        return altitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getContraseña() {
        return contraseña;
    }

    public ArrayList<ClaseTelefono> getTelefono() {
        return telefono;
    }

  public ArrayList<ClaseEquipo> getEquipo() {
       return equipo;
   }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setAltitud(String altitud) {
        this.altitud = altitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTelefono(ArrayList<ClaseTelefono> telefono) {
        this.telefono = telefono;
    }

    public void setEquipo(ArrayList<ClaseEquipo> equipo) {
        this.equipo = equipo;
    }
}
