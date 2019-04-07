package com.example.cep.proj2.API.ApiServices;



import com.example.cep.proj2.Clases.ClaseHorarioActividad;

import java.sql.Time;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface HorarioActividadService {
    @GET("api/HORARIO_ACTIVIDADES")
    Call<ArrayList<ClaseHorarioActividad>> getHorarioActividad();


    @GET("api/HORARIO_ACTIVIDADES/{id_dia}/{hora_inicio}/{id_actividades}")
    Call <ClaseHorarioActividad>getHorarioActividadID(@Path("id_dia")int id_dia, @Path("hora_inicio")Time hora_inicio, @Path("id_actividades")int id_actividades);



    @POST("api/HORARIO_ACTIVIDADES")
    Call <ClaseHorarioActividad> InsertarHorarioActividad(@Body ClaseHorarioActividad HorarioActividad);


    @DELETE("api/HORARIO_ACTIVIDADES")
    Call<ResponseBody> deleteHorarioActividad(@Path("id") int id);
}
