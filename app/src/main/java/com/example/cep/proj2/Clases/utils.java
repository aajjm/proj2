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

}
