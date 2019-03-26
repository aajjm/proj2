package com.example.cep.proj2.API.ApiServices;



import com.example.cep.proj2.Clases.ClaseActividadDemandada;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ActividadDemandadaService {
    @GET("api/ACTIVIDADES_DEMANDADAS")
    Call<ArrayList<ClaseActividadDemandada>> getActividadDemanda();


    @GET("api/ACTIVIDADES_DEMANDADAS/{id}")
    Call <ClaseActividadDemandada>getActividadDemandadaId(@Path("id")int id);


    @GET("api/ACTIVIDADES_DEMANDADAS/nombre_actividades_demandadas/{nombre_actividades_demandadas}")
    Call <ClaseActividadDemandada>getActividadDemandadaNombre(@Path("nombre_actividades_demandadas")String nombre_actividades_demandadas);


    @POST("api/ACTIVIDADES_DEMANDADAS")
    Call <ClaseActividadDemandada> InsertarActividadDemandada(@Body ClaseActividadDemandada ActividadDemandada);


    @DELETE("api/ACTIVIDADES_DEMANDADAS")
    Call<ResponseBody> deleteActividadDemandada(@Path("id") int id);
}
