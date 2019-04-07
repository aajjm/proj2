package com.example.cep.proj2.API.ApiServices;



import com.example.cep.proj2.Clases.ClaseActividad;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ActividadService {
    @GET("api/ACTIVIDAD")
    Call<ArrayList<ClaseActividad>> getACTIVIDAD();


    @GET("api/ACTIVIDAD/{id}")
    Call <ClaseActividad>getACTIVIDADId(@Path("id")int id);


    @GET("api/ACTIVIDAD/nombre_actividad/{nombre_actividad}")
    Call <ClaseActividad>getACTIVIDADNombre(@Path("nombre_actividad")String nombre_actividad);


    @POST("api/ACTIVIDAD")
    Call <ClaseActividad> InsertarACTIVIDAD(@Body ClaseActividad ACTIVIDAD);


    @DELETE("api/ACTIVIDAD")
    Call<ResponseBody> deleteACTIVIDAD(@Path("id") int id);
}
