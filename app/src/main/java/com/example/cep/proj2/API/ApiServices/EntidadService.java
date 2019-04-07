package com.example.cep.proj2.API.ApiServices;

import com.example.cep.proj2.Clases.ClaseEntidad;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EntidadService {
    @GET("api/ENTIDADs")
    Call<ArrayList<ClaseEntidad>> getEntidad();


    @GET("api/ENTIDADs/{id}")
    Call <ClaseEntidad>getEntidadId(@Path("id")int id);


    @GET("api/ENTIDADs/nombre/{nombre}")
    Call <ClaseEntidad>getEntidadNombre(@Path("nombre")String nombre);


    @POST("api/ENTIDADs")
    Call <ClaseEntidad> InsertarEntidad(@Body ClaseEntidad entidad);


    @DELETE("api/ENTIDADs")
    Call<ResponseBody> deleteEntidad(@Path("id") int id);
}
