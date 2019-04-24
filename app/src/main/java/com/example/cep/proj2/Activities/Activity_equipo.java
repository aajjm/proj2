package com.example.cep.proj2.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.cep.proj2.API.Api;
import com.example.cep.proj2.API.ApiServices.EquipoService;
import com.example.cep.proj2.Adaptadores.RecyclerViewEquiposAdapater;
import com.example.cep.proj2.Adaptadores.RecyclerViewInstalacionesAdapter;
import com.example.cep.proj2.Clases.ClaseEquipo;
import com.example.cep.proj2.Fragments.fragmentInstalaciones;
import com.example.cep.proj2.MensajeError;
import com.example.cep.proj2.R;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_equipo extends AppCompatActivity {

    private RecyclerView recyclerEquipo;
    private ArrayList<ClaseEquipo> lista;
    private ArrayList<ClaseEquipo> listaDeEquipos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);

        recyclerEquipo = (RecyclerView) findViewById(R.id.RecyclerEquipo);
        recyclerEquipo.setLayoutManager(new LinearLayoutManager(this));


        EquipoService equipoService = Api.getApi().create(EquipoService.class);
        final Call<ArrayList<ClaseEquipo>> listEquipo= equipoService.getEquipo();
        lista = new ArrayList<>();

        listEquipo.enqueue(new Callback<ArrayList<ClaseEquipo>>() {
            @Override
            public void onResponse(Call<ArrayList<ClaseEquipo>> call, Response<ArrayList<ClaseEquipo>> response) {
                switch (response.code()){
                    case 200:
                        lista = response.body();
                        Toast toast1 =  Toast.makeText(getApplicationContext(),
                                "PRUEBA", Toast.LENGTH_SHORT);

                        for(int i = 0; i < lista.size();i++)
                        {
                            if(lista.get(i).getId_entidad() == Login.entidadPrinc.getId()){
                                listaDeEquipos.add(lista.get(i));
                            }
                        }

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
            public void onFailure(Call<ArrayList<ClaseEquipo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getCause() + " - " + t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        RecyclerViewEquiposAdapater readap = new RecyclerViewEquiposAdapater(listaDeEquipos);

        readap.setOnItemClickListener(new RecyclerViewEquiposAdapater.OnItemClickListener() {
            @Override
            public void onTextClick(int position) {
                //Intent  i = new Intent(fragmentInstalaciones.this, InfoInstalaciones.class);
                //pasarInsta = listaDeEquipos.get(position);
                //startActivity(i);
            }
        });


        recyclerEquipo.setAdapter(readap);
    }
}
