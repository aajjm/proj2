package com.example.cep.proj2.API.ApiServices;

import com.example.cep.proj2.Clases.ClaseEntidad;
import com.example.cep.proj2.Clases.ClaseTelefono;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TelefonoService {

    @GET("api/TELEFONOes")
    Call<List<ClaseTelefono>> getTelefono();


    @GET("api/TELEFONOes/{id}")
    Call <ClaseTelefono>getTelefonoId(@Path("id")int id);


    @GET("api/TELEFONOes/telefono/{telefono}")
    Call <ClaseTelefono>getTelefonXtelefono(@Path("telefono")int telefono);


    @POST("api/TELEFONOes")
    Call <ClaseTelefono> Insertartelefono(@Body ClaseTelefono telefono);


    @DELETE("api/TELEFONOes")
    Call<ResponseBody> deleteTelefono(@Path("id") int id);
}
