package com.example.cep.proj2.Activities;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cep.proj2.API.Api;
import com.example.cep.proj2.API.ApiServices.EntidadService;
import com.example.cep.proj2.Clases.ClaseEntidad;
import com.example.cep.proj2.Clases.utils;
import com.example.cep.proj2.MensajeError;
import com.example.cep.proj2.ModificarEntidad;
import com.example.cep.proj2.R;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityEntidades extends AppCompatActivity {
    private ClaseEntidad entidad= utils.getEntidad_conectada();
    ArrayList<ClaseEntidad> emt =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entidades);


        final EditText Nombre =(EditText) findViewById(R.id.nombre);
        final EditText direccion=(EditText) findViewById(R.id.direccion);
        final EditText NIF =(EditText) findViewById(R.id.NIF);
        final EditText Correo =(EditText) findViewById(R.id.Correo);
        final EditText Altitud =(EditText) findViewById(R.id.altitud);
        final EditText Latitud =(EditText) findViewById(R.id.latitud);

        final EditText video=(EditText) findViewById(R.id.video);
        final Button boton=(Button) findViewById(R.id.modificar);

        Nombre.setText(entidad.getNombre());
        direccion.setText(entidad.getDireccion());
        NIF.setText(entidad.getNIF());
        Correo.setText(entidad.getCorreo());
        Altitud.setText(String.valueOf(entidad.getAltitud()));
        Latitud.setText(entidad.getLatitud()+"");
        video.setText(entidad.getVideo());


         boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(ActivityEntidades.this, ModificarEntidad.class);
                startActivity(i);
             }


        });
    }
}














