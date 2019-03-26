package com.example.cep.proj2.API.ApiServices;

import com.example.cep.proj2.Clases.ClaseAdministrador;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AdministradorService {
    @GET("api/ADMINISTRADOR")
    Call<ArrayList<ClaseAdministrador>> getAdministrador();


    @GET("api/ADMINISTRADOR/{id}")
    Call <ClaseAdministrador>getAdministradorId(@Path("id")int id);


    @GET("api/ADMINISTRADOR/DNI/{DNI}")
    Call <ClaseAdministrador>getAdministradorDNI(@Path("DNI")String DNI);


    @POST("api/ADMINISTRADOR")
    Call <ClaseAdministrador> InsertarAdministrador(@Body ClaseAdministrador Administrador);


    @DELETE("api/ADMINISTRADOR")
    Call<ResponseBody> deleteAdministrador(@Path("id") int id);
}
