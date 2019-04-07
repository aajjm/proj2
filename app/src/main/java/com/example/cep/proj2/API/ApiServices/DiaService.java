package com.example.cep.proj2.API.ApiServices;



import com.example.cep.proj2.Clases.ClaseDia;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DiaService {
    @GET("api/DIAs")
    Call<ArrayList<ClaseDia>> getDia();


    @GET("api/DIAs/{id}")
    Call <ClaseDia>getDiaID(@Path("id")int id);


    @GET("api/DIAs/dia/{dia}")
    Call <ClaseDia>getDiaDia(@Path("dia")String dia);


    @POST("api/DIAs")
    Call <ClaseDia> InsertarDia(@Body ClaseDia Dia);


    @DELETE("api/DIAs")
    Call<ResponseBody> deleteDia(@Path("id") int id);
}
