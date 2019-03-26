package com.example.cep.proj2.API.ApiServices;


import com.example.cep.proj2.Clases.ClaseDeporte;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DeporteService {
    @GET("api/DEPORTEs")
    Call<ArrayList<ClaseDeporte>> getDeporte();


    @GET("api/DEPORTEs/{id}")
    Call <ClaseDeporte>getDeporteID(@Path("id")int id);


    @GET("api/DEPORTEs/tipo_deporte/{tipo_deporte}")
    Call <ClaseDeporte>getDeporteTipo(@Path("tipo_deporte")String tipo_deporte);


    @POST("api/DEPORTEs")
    Call <ClaseDeporte> InsertarDeporte(@Body ClaseDeporte Deporte);


    @DELETE("api/DEPORTEs")
    Call<ResponseBody> deleteCompeticion(@Path("id") int id);
}
