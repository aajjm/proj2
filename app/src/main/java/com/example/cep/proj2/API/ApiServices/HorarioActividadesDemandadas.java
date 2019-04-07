package com.example.cep.proj2.API.ApiServices;



import com.example.cep.proj2.Clases.ClaseHorarioActividadDemandada;

import java.sql.Time;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface HorarioActividadesDemandadas {

    @GET("api/HORARIO_ACTIVIDADES_DEMANDADAS")
    Call<ArrayList<ClaseHorarioActividadDemandada>> getHorarioActividadDemandada();


    @GET("api/HORARIO_ACTIVIDADES_DEMANDADAS/{id_dia}/{hora_inicio}/{id_actividades_demandas}")
    Call <ClaseHorarioActividadDemandada>getHorarioActividadDemandadaID(@Path("id_dia")int id_dia, @Path("hora_inicio")Time hora_inicio, @Path("id_actividades_demandas")int id_actividades_demandadas);




    @POST("api/HORARIO_ACTIVIDADES_DEMANDADAS")
    Call <ClaseHorarioActividadDemandada> InsertarHorarioActividadDemandada(@Body ClaseHorarioActividadDemandada HorarioActividadDemandada);


    @DELETE("api/HORARIO_ACTIVIDADES_DEMANDADAS")
    Call<ResponseBody> deleteEntidad(@Path("id") int id);
}
