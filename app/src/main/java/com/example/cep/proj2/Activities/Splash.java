package com.example.cep.proj2.Activities;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cep.proj2.API.Api;
import com.example.cep.proj2.API.ApiServices.ActividadDemandadaService;
import com.example.cep.proj2.API.ApiServices.ActividadService;
import com.example.cep.proj2.API.ApiServices.EntidadService;
import com.example.cep.proj2.Clases.ClaseActividad;
import com.example.cep.proj2.Clases.ClaseActividadDemandada;
import com.example.cep.proj2.Clases.ClaseEntidad;
import com.example.cep.proj2.Clases.utils;
import com.example.cep.proj2.MensajeError;
import com.example.cep.proj2.R;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends Activity {
    private final int DURACION_SPLASH = 4000; // 4 segundos
    private ProgressBar miprogress;
    private ClaseEntidad entidad= utils.getEntidad_conectada();
    private ObjectAnimator anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

              //  miprogress = (ProgressBar) findViewById(R.id.circularProgress);



                //instanciamos el animador
                //Construye y devuelve un ObjectAnimator que anima.
                anim = ObjectAnimator.ofInt(miprogress, "progress", 0, 100);
                mostrarProgress();
                new Handler().postDelayed(new Runnable(){
                    public void run(){
                        // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
                        Intent intent = new Intent(Splash.this, Login.class);
                        startActivity(intent);
                        finish();
                    };
                }, DURACION_SPLASH);
        ActividadDemandadaService actividadDemandadaService = Api.getApi().create(ActividadDemandadaService.class);
        Call<ArrayList<ClaseActividadDemandada>> listcall= actividadDemandadaService.getActividadDemanda();
        listcall.enqueue(new Callback<ArrayList<ClaseActividadDemandada>>() {
            @Override
            public void onResponse(Call<ArrayList<ClaseActividadDemandada>> call, Response<ArrayList<ClaseActividadDemandada>> response) {
                switch (response.code()){

                    case 200:
                        Toast toast1 =  Toast.makeText(getApplicationContext(),
                                "CONEXION CORRECTA", Toast.LENGTH_SHORT);

                        toast1.show();

                        break;
                    case 400:

                        Gson gson = new Gson();
                        Toast.makeText(getApplicationContext(),
                                "Conexion mal ", Toast.LENGTH_SHORT).show();
                        MensajeError mensajeError=gson.fromJson(response.errorBody().charStream(),MensajeError.class);
                        Toast.makeText(getApplicationContext(),mensajeError.getMessage(),Toast.LENGTH_LONG).show();
                        break;
                }
            }



                @Override
                public void onFailure(Call<ArrayList<ClaseActividadDemandada>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),t.getCause()+"-"+t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });

            ActividadService actividadService = Api.getApi().create(ActividadService.class);
            Call<ArrayList<ClaseActividad>> listcalls= actividadService.getACTIVIDAD();
        listcalls.enqueue(new Callback<ArrayList<ClaseActividad>>() {
                @Override
                public void onResponse(Call<ArrayList<ClaseActividad >> call, Response<ArrayList<ClaseActividad>> response) {
                    switch (response.code()){

                        case 200:
                            Toast toast1 =  Toast.makeText(getApplicationContext(),
                                    "CONEXION CORRECTA", Toast.LENGTH_SHORT);

                            toast1.show();

                            break;
                        case 400:

                            Gson gson = new Gson();
                            Toast.makeText(getApplicationContext(),
                                    "Conexion mal ", Toast.LENGTH_SHORT).show();
                            MensajeError mensajeError=gson.fromJson(response.errorBody().charStream(),MensajeError.class);
                            Toast.makeText(getApplicationContext(),mensajeError.getMessage(),Toast.LENGTH_LONG).show();
                            break;
                    }
                }




                @Override
                public void onFailure(Call<ArrayList<ClaseActividad>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),t.getCause()+"-"+t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });












        }
            private void mostrarProgress(){
                //agregamos el tiempo de la animacion a mostrar
                anim.setDuration(15000);
                anim.setInterpolator(new DecelerateInterpolator());
                //iniciamos el progressbar
                anim.start();
            }








    }

