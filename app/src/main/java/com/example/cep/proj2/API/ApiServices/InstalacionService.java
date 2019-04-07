package com.example.cep.proj2.API.ApiServices;


import com.example.cep.proj2.Clases.ClaseInstalacion;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface InstalacionService {
    @GET("api/INSTALACIONES")
    Call<ArrayList<ClaseInstalacion>> getInstalacion();


    @GET("api/INSTALACIONES/{id}")
    Call <ClaseInstalacion>getInstalacionID(@Path("id")int id);


    @GET("api/INSTALACIONES/nombre_instalaciones/{nombre_instalaciones}")
    Call <ClaseInstalacion>getInstalacionNombre(@Path("nombre_instalaciones")String nombre_instalaciones);


    @POST("api/INSTALACIONES")
    Call <ClaseInstalacion> InsertarInstalacion(@Body ClaseInstalacion Instalacion);


    @DELETE("api/INSTALACIONES")
    Call<ResponseBody> deleteInstalacion(@Path("id") int id);
}
