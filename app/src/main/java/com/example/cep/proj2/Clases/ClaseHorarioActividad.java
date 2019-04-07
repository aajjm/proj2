package com.example.cep.proj2.Clases;

import java.sql.Time;
import java.util.ArrayList;

//id_dia, hora_inicio(time), hora_final(time), id_actividades
public class ClaseHorarioActividad {

    private ArrayList<ClaseDia> id_dia;
    private Time hora_Inicio;
    private Time hora_Final;
    private ArrayList<ClaseActividad> id_actividades;

    public ArrayList<ClaseDia> getId_dia() {
        return id_dia;
    }

    public void setId_dia(ArrayList<ClaseDia> id_dia) {
        this.id_dia = id_dia;
    }

    public Time getHora_Inicio() {
        return hora_Inicio;
    }

    public void setHora_Inicio(Time hora_Inicio) {
        this.hora_Inicio = hora_Inicio;
    }

    public Time getHora_Final() {
        return hora_Final;
    }

    public void setHora_Final(Time hora_Final) {
        this.hora_Final = hora_Final;
    }

    public ArrayList<ClaseActividad> getId_actividades() {
        return id_actividades;
    }

    public void setId_actividades(ArrayList<ClaseActividad> id_actividades) {
        this.id_actividades = id_actividades;
    }
}
