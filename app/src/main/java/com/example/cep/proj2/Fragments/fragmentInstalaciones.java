package com.example.cep.proj2.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.proj2.API.Api;
import com.example.cep.proj2.API.ApiServices.InstalacionService;
import com.example.cep.proj2.Activities.InfoInstalaciones;
import com.example.cep.proj2.Adaptadores.RecyclerViewInstalacionesAdapter;
import com.example.cep.proj2.Clases.ClaseHorarioInstalacion;
import com.example.cep.proj2.Clases.ClaseInstalacion;
import com.example.cep.proj2.MensajeError;
import com.example.cep.proj2.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fragmentInstalaciones extends AppCompatActivity {

    private RecyclerView recyclerInstalaciones;
    List<ClaseInstalacion> listaInstalaciones;
    ArrayList<ClaseInstalacion> lista;
    ArrayList<ClaseInstalacion> listaInstalacionesMia = new ArrayList<>();
    public static ClaseInstalacion pasarInsta;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_instalaciones);

        recyclerInstalaciones = (RecyclerView) findViewById(R.id.RecyclerInstalaciones);
        recyclerInstalaciones.setLayoutManager(new LinearLayoutManager(this));


        InstalacionService instalacionService = Api.getApi().create(InstalacionService.class);
        final Call<ArrayList<ClaseInstalacion>> listInstalaciones= instalacionService.getInstalacion();
        lista = new ArrayList<>();

        listInstalaciones.enqueue(new Callback<ArrayList<ClaseInstalacion>>() {
            @Override
            public void onResponse(Call<ArrayList<ClaseInstalacion>> call, Response<ArrayList<ClaseInstalacion>> response) {
                switch (response.code()){
                    case 200:
                        lista = response.body();
                        Toast toast1 =  Toast.makeText(getApplicationContext(),
                                "PRUEBA", Toast.LENGTH_SHORT);

                        ArrayList<String> lista1 = new ArrayList<>();

                        for(int i = 0; i < lista.size();i++)
                        {
                            listaInstalacionesMia.add(lista.get(i));
                        }
/*
                        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(Actividades.this,android.R.layout.simple_spinner_item, lista1);
                        instalaciones.setAdapter(adapter);
*/

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
            public void onFailure(Call<ArrayList<ClaseInstalacion>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getCause() + " - " + t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        RecyclerViewInstalacionesAdapter readap = new RecyclerViewInstalacionesAdapter(listaInstalacionesMia);

        readap.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent  i = new Intent(fragmentInstalaciones.this, InfoInstalaciones.class);
                pasarInsta = listaInstalacionesMia.get(recyclerInstalaciones.getChildAdapterPosition(v));
                startActivity(i);
            }
        } );

        recyclerInstalaciones.setAdapter(readap);
    }
}
