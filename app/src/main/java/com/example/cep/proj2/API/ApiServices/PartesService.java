package com.example.cep.proj2.API.ApiServices;

import com.example.cep.proj2.Clases.ClaseEquipo;
import com.example.cep.proj2.Clases.ClasePartes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PartesService {

    @GET("api/PARTEs")
    Call<ArrayList<ClasePartes>> getParte();

    @GET("api/PARTEs/{id}")
    Call <ClasePartes>getTipoID(@Path("id")int id);

    @POST("api/PARTEs")
    Call <ClasePartes> InsertarParte(@Body ClasePartes parte);


    @DELETE("api/PARTE")
    Call<ResponseBody> deleteParte(@Path("id") int id);
}
