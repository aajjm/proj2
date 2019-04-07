package com.example.cep.proj2.API.ApiServices;



import com.example.cep.proj2.Clases.ClaseHorarioInstalacion;
import com.example.cep.proj2.Clases.ClaseInstalacion;

import java.sql.Time;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface HorarioInstalaciones {
    @GET("api/HORARIO_INSTALACIONES")
    Call<ArrayList<ClaseHorarioInstalacion>> getHorarioInstalaciones();


    @GET("api/HORARIO_INSTALACIONES/{id_dia}/{hora_inicio}/{id_instalaciones}")
    Call <ClaseHorarioInstalacion>getHorarioInstalacionesID(@Path("id_dia")int id_dia, @Path("hora_inicio")Time hora_inicio, @Path("id_instalaciones")int id_instalaciones);



    @POST("api/HORARIO_INSTALACIONES")
    Call <ClaseHorarioInstalacion> InsertarHorarioInstalaciones(@Body ClaseHorarioInstalacion HorarioInstalaciones);


    @DELETE("api/HORARIO_INSTALACIONES")
    Call<ResponseBody> deleteHorarioInstalaciones(@Path("id") int id);
}
