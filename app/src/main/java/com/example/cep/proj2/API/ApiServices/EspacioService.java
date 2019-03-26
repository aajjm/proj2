package com.example.cep.proj2.API.ApiServices;

import com.example.cep.proj2.Clases.ClaseEntidad;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EspacioService {
    @GET("api/ESPACIOS")
    Call<ArrayList<ClaseEntidad>> getEntidad();


    @GET("api/ESPACIOS/{id}")
    Call <ClaseEntidad>getEntidadID(@Path("id")int id);


    @GET("api/ESPACIOS/nombre_espacios/{nombre_espacios}")
    Call <ClaseEntidad>getEntidadNombre(@Path("nombre_espacios")String nombre_espacios);


    @POST("api/ESPACIOS")
    Call <ClaseEntidad> InsertarEntidad(@Body ClaseEntidad Entidad);


    @DELETE("api/ESPACIOS")
    Call<ResponseBody> deleteEntidad(@Path("id") int id);
}
