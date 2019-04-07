package com.example.cep.proj2.API.ApiServices;

import com.example.cep.proj2.Clases.ClaseCompeticion;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CompeticionService {


    @GET("api/COMPETICIONs")
    Call<ArrayList<ClaseCompeticion>> getCompeticion();


    @GET("api/COMPETICIONs/{id}")
    Call <ClaseCompeticion>getCompeticionID(@Path("id")int id);


    @GET("api/COMPETICIONs/tipo_competicion/{tipo_competicion}")
    Call <ClaseCompeticion>getCompeticionTipo(@Path("tipo_competicion")String tipo_competicion);


    @POST("api/COMPETICIONs")
    Call <ClaseCompeticion> InsertarCompeticion(@Body ClaseCompeticion Competicion);


    @DELETE("api/COMPETICIONs")
    Call<ResponseBody> deleteCompeticion(@Path("id") int id);
}
