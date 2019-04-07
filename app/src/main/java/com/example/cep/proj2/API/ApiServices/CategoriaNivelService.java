package com.example.cep.proj2.API.ApiServices;



import com.example.cep.proj2.Clases.ClaseCatNivel;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CategoriaNivelService {
    @GET("api/CATEGORIA_NIVEL")
    Call<ArrayList<ClaseCatNivel>> getCategoriaNivel();


    @GET("api/CATEGORIA_NIVEL/{id}")
    Call <ClaseCatNivel>getCategoriaNivelId(@Path("id")int id);


    @GET("api/CATEGORIA_NIVEL/categoria/{categoria}")
    Call <ClaseCatNivel>getCategoriaNivelCategoria(@Path("categoria")String categoria);


    @POST("api/CATEGORIA_NIVEL")
    Call <ClaseCatNivel> InsertarCategoriaNivel(@Body ClaseCatNivel CategoriaNivel);


    @DELETE("api/CATEGORIA_NIVEL")
    Call<ResponseBody> deleteCategoriaEdad(@Path("id") int id);
}
