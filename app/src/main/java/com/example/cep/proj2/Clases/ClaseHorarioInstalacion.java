package com.example.cep.proj2.Clases;

import java.util.ArrayList;

//id_dia, hora_inicio(string), hora_Final(string), id_instalaciones
public class ClaseHorarioInstalacion {

    private int id_dia;
    private String hora_inicio;
    private String hora_Final;
    private int id_instalaciones;

    public int getId_dia() {
        return id_dia;
    }

    public void setId_dia(int id_dia) {
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

    public int getId_instalaciones() {
        return id_instalaciones;
    }

    public void setId_instalaciones(int id_instalaciones) {
        this.id_instalaciones = id_instalaciones;
    }
}
