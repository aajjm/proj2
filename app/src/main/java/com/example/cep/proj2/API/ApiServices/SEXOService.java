package com.example.cep.proj2.API.ApiServices;



import com.example.cep.proj2.Clases.ClaseSexo;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SEXOService {
    @GET("api/SEXOes")
    Call<ArrayList<ClaseSexo>> getTipo();


    @GET("api/SEXOes/{id}")
    Call <ClaseSexo>getTipoID(@Path("id")int id);


    @GET("api/SEXOes/tipo/{tipo}")
    Call <ClaseSexo>getTipotipo(@Path("tipo")String tipo);


    @POST("api/SEXOes")
    Call <ClaseSexo> InsertarTipo(@Body ClaseSexo Tipo);


    @DELETE("api/SEXO")
    Call<ResponseBody> deleteTipo(@Path("id") int id);
}
