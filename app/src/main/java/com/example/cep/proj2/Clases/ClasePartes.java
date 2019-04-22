package com.example.cep.proj2.Clases;

public class ClasePartes {
    private int id;
    private int id_espacio;
    private String nombre;
    private boolean ocupada;

    public ClasePartes(int id, int id_espacio, String nombre, boolean ocupada) {
        this.id = id;
        this.id_espacio = id_espacio;
        this.nombre = nombre;
        this.ocupada = ocupada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_espacio() {
        return id_espacio;
    }

    public void setId_espacio(int id_espacio) {
        this.id_espacio = id_espacio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
}
