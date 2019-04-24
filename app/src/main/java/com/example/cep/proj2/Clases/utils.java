package com.example.cep.proj2.Clases;

public class utils {


//region CLASE ENTIDAD
    public static ClaseEntidad entidad_conectada;
    public static ClaseEntidad getEntidad_conectada() {
        return entidad_conectada;
    }

    public static void setEntidad_conectada(ClaseEntidad entidad_conectada) {
        utils.entidad_conectada = entidad_conectada;
    }
    //endregion

//region CLASE ACTIVIDAD
    public static ClaseActividad actividad_conectada;
    public static ClaseActividad getActividad_conectada() {
        return actividad_conectada;
    }

    public static void actividad_conectada(ClaseActividad actividad_conectada) {
        utils.actividad_conectada = actividad_conectada;
    }
//endregion

//region CLASE INSTALACIONES
    public static ClaseInstalacion instalaciones_conectada;
    public static ClaseInstalacion getInstalaciones_conectada() {
        return instalaciones_conectada;
    }

    public static void instalaciones_conectada(ClaseInstalacion instalaciones_conectada) {
        utils.instalaciones_conectada = instalaciones_conectada;
    }
//endregion

//region CLASE ESPACIOS
    public static ClaseEspacio espacio_conectada;
    public static ClaseEspacio getespacio_conectadaa() {
        return espacio_conectada;
    }

    public static void espacio_conectada(ClaseEspacio espacio_conectada) {
        utils.espacio_conectada = espacio_conectada;
    }
//endregion

//region CLASE EQUIPOS
    public static ClaseEquipo equipo_conectada;
    public static ClaseEquipo getequipo_conectada() {
        return equipo_conectada;
    }

    public static void equipo_conectada(ClaseEquipo equipo_conectada) {
        utils.equipo_conectada = equipo_conectada;
    }
//endregion
}
