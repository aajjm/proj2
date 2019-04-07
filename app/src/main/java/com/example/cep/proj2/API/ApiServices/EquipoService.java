package com.example.cep.proj2.API.ApiServices;



import com.example.cep.proj2.Clases.ClaseEquipo;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EquipoService {
    @GET("api/EQUIPOes")
    Call<ArrayList<ClaseEquipo>> getEquipo();


    @GET("api/EQUIPOes/{id}")
    Call <ClaseEquipo>getEquipoID(@Path("id")int id);


    @GET("api/EQUIPOes/nombre_equipo/{nombre_equipo}")
    Call <ClaseEquipo>getEquipoNombre(@Path("nombre_equipo")String nombre_equipo);


    @POST("api/EQUIPOes")
    Call <ClaseEquipo> InsertarEquipo(@Body ClaseEquipo Equipo);


    @DELETE("api/DIAs")
    Call<ResponseBody> deleteEquipo(@Path("id") int id);
}
