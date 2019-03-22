package com.example.cep.proj2.Clases;

import java.sql.Time;
import java.util.ArrayList;

//id_dia, hora_Inicio(time), hora_Final(time), id_actividades_demandadas
public class ClaseHorarioActividadDemandada {

    private ArrayList<ClaseDia> id_dia;
    private Time hora_Inicio;
    private Time hora_Final;
    private ArrayList<ClaseHorarioActividadDemandada> id_actividades_demandadas;

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

    public ArrayList<ClaseHorarioActividadDemandada> getId_actividades_demandadas() {
        return id_actividades_demandadas;
    }

    public void setId_actividades_demandadas(ArrayList<ClaseHorarioActividadDemandada> id_actividades_demandadas) {
        this.id_actividades_demandadas = id_actividades_demandadas;
    }
}
