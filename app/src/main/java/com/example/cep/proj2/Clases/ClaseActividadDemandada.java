package com.example.cep.proj2.Clases;

import java.sql.Time;
import java.util.ArrayList;

//id, nombre_actividades_demandadas, tipo_entrenamiento, id_espacio, id_equipo, duracion(float), dias_semanales(int), asignada(bool) -->
// --> intervalo_horario(time), dias_favorables, partes_pista_demandada
public class ClaseActividadDemandada {
    private int id;
    private String nombre_actividades_demandadas;
    private boolean tipo_entrenamiento;
    private ArrayList<ClaseEspacio> id_espacio;
    private ArrayList<ClaseEquipo> id_equipo;
    private float duracion;
    private int dias_semanales;
    private boolean asignada;
    private Time intervalo_horario;
    private String dias_favorables;
    private int partes_pista_demandada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_actividades_demandadas() {
        return nombre_actividades_demandadas;
    }

    public void setNombre_actividades_demandadas(String nombre_actividades_demandadas) {
        this.nombre_actividades_demandadas = nombre_actividades_demandadas;
    }

    public boolean isTipo_entrenamiento() {
        return tipo_entrenamiento;
    }

    public void setTipo_entrenamiento(boolean tipo_entrenamiento) {
        this.tipo_entrenamiento = tipo_entrenamiento;
    }

    public ArrayList<ClaseEspacio> getId_espacio() {
        return id_espacio;
    }

    public void setId_espacio(ArrayList<ClaseEspacio> id_espacio) {
        this.id_espacio = id_espacio;
    }

    public ArrayList<ClaseEquipo> getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(ArrayList<ClaseEquipo> id_equipo) {
        this.id_equipo = id_equipo;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public int getDias_semanales() {
        return dias_semanales;
    }

    public void setDias_semanales(int dias_semanales) {
        this.dias_semanales = dias_semanales;
    }

    public boolean isAsignada() {
        return asignada;
    }

    public void setAsignada(boolean asignada) {
        this.asignada = asignada;
    }

    public Time getIntervalo_horario() {
        return intervalo_horario;
    }

    public void setIntervalo_horario(Time intervalo_horario) {
        this.intervalo_horario = intervalo_horario;
    }

    public String getDias_favorables() {
        return dias_favorables;
    }

    public void setDias_favorables(String dias_favorables) {
        this.dias_favorables = dias_favorables;
    }

    public int getPartes_pista_demandada() {
        return partes_pista_demandada;
    }

    public void setPartes_pista_demandada(int partes_pista_demandada) {
        this.partes_pista_demandada = partes_pista_demandada;
    }
}
