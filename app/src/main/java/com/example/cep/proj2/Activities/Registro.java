package com.example.cep.proj2.Activities;

import android.content.Intent;
import android.net.ParseException;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cep.proj2.API.Api;
import com.example.cep.proj2.API.ApiServices.EntidadService;
import com.example.cep.proj2.Clases.ClaseEntidad;
import com.example.cep.proj2.Clases.ClaseUsuario;
import com.example.cep.proj2.MensajeError;
import com.example.cep.proj2.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_entidad);

     final EditText  Nombre =(EditText) findViewById(R.id.nombre);
        final EditText direccion=(EditText) findViewById(R.id.direccion);
        final EditText NIF =(EditText) findViewById(R.id.NIF);
        final EditText Correo =(EditText) findViewById(R.id.Correo);
        final EditText Altitud =(EditText) findViewById(R.id.altitud);
        final EditText Latitud =(EditText) findViewById(R.id.latitud);
        final EditText Contraseña =(EditText)findViewById(R.id.contraseña);
        final EditText RepContraseña =(EditText) findViewById(R.id.repcontraseña);
        final Button botonaceptar=(Button) findViewById(R.id.registrar);



        botonaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClaseEntidad entidad= new ClaseEntidad();

                if( !(Nombre.getText().toString().isEmpty()
                        || direccion.getText().toString().isEmpty() || NIF.getText().toString().isEmpty() || Correo.getText().toString().isEmpty()
                        || Contraseña.getText().toString().isEmpty()|| Latitud.getText().toString().isEmpty()|| Altitud.getText().toString().isEmpty())){

                    entidad.setNombre(Nombre.getText().toString());
                    entidad.setDireccion(direccion.getText().toString());
                    entidad.setNIF(NIF.getText().toString());
                    entidad.setCorreo(Correo.getText().toString());
                    entidad.setAltitud(Altitud.getText().toString());
                    entidad.setLatitud(Latitud.getText().toString());
                    entidad.setTemporada("2018-2019");


                    if(Contraseña.getText().toString().equals(RepContraseña.getText().toString())){
                        entidad.setContraseña(Contraseña.getText().toString());
                    }
                    else {
                        Toast.makeText(getApplicationContext(),
                                "Contraseñas Diferentes", Toast.LENGTH_SHORT).show();

                    }


                }

                

                 else {
                    Toast.makeText(getApplicationContext(),
                            "Introduce Todos Los Datos", Toast.LENGTH_SHORT).show();

                }



                EntidadService entidadService = Api.getApi().create(EntidadService.class);
                Call<ClaseEntidad> listcall= entidadService.InsertarEntidad(entidad);
                listcall.enqueue(new Callback<ClaseEntidad>() {
                    @Override
                    public void onResponse(Call<ClaseEntidad> call, Response<ClaseEntidad> response) {
                      switch (response.code()){

                          case 201:
                              Toast toast1 =  Toast.makeText(getApplicationContext(),
                                      "PRUEBA", Toast.LENGTH_SHORT);

                              toast1.show();
                              Intent i=new Intent();
                              i.setClass(Registro.this,MenuDesplegableActivity.class);
                              startActivity(i);

                              break;
                          case 400:

                              Gson gson = new Gson();
                              MensajeError mensajeError=gson.fromJson(response.errorBody().charStream(),MensajeError.class);
                              Toast.makeText(getApplicationContext(),mensajeError.getMessage(),Toast.LENGTH_LONG).show();
                              break;
                      }
                    }

                    @Override
                    public void onFailure(Call<ClaseEntidad> call, Throwable t) {
    Toast.makeText(getApplicationContext(),t.getCause()+"-"+t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


}}
