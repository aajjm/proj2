package com.example.cep.proj2.API.ApiServices;



import com.example.cep.proj2.Clases.ClaseCatEdad;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CategoriaEdadService {
    @GET("api/CATEGORIA_EDAD")
    Call<ArrayList<ClaseCatEdad>> getCategoriaEdad();


    @GET("api/CATEGORIA_EDAD/{id}")
    Call <ClaseCatEdad>getCategoriaEdadId(@Path("id")int id);


    @GET("api/CATEGORIA_EDAD/categoria/{categoria}")
    Call <ClaseCatEdad>getCategoriaEdadCategoria(@Path("categoria")String categoria);


    @POST("api/CATEGORIA_EDAD")
    Call <ClaseCatEdad> InsertarCategoriaEdad(@Body ClaseCatEdad CategoriaEdad);


    @DELETE("api/CATEGORIA_EDAD")
    Call<ResponseBody> deleteCategoriaEdad(@Path("id") int id);
}
