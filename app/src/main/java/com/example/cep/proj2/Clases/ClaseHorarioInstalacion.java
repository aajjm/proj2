package com.example.cep.proj2.Clases;

import java.util.ArrayList;

//id_dia, hora_inicio(string), hora_Final(string), id_instalaciones
public class ClaseHorarioInstalacion {

    private ArrayList<ClaseDia> id_dia;
    private String hora_inicio;
    private String hora_Final;
    private  ArrayList<ClaseInstalacion> id_instalaciones;

    public ArrayList<ClaseDia> getId_dia() {
        return id_dia;
    }

    public void setId_dia(ArrayList<ClaseDia> id_dia) {
        this.id_dia = id_dia;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_Final() {
        return hora_Final;
    }

    public void setHora_Final(String hora_Final) {
        this.hora_Final = hora_Final;
    }

    public ArrayList<ClaseInstalacion> getId_instalaciones() {
        return id_instalaciones;
    }

    public void setId_instalaciones(ArrayList<ClaseInstalacion> id_instalaciones) {
        this.id_instalaciones = id_instalaciones;
    }
}
