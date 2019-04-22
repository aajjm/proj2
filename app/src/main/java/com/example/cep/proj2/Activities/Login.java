package com.example.cep.proj2.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.proj2.API.Api;
import com.example.cep.proj2.API.ApiServices.EntidadService;
import com.example.cep.proj2.Clases.ClaseEntidad;
import com.example.cep.proj2.Clases.utils;
import com.example.cep.proj2.MensajeError;
import com.example.cep.proj2.R;
import com.google.gson.Gson;

import java.net.InterfaceAddress;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private  Button boton;
    private ClaseEntidad entidad= new ClaseEntidad();
   private EditText usuarios;
    private EditText passwords;
    private String usuario;
    String password;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        boton = (Button) findViewById(R.id.boton);
        TextView registroLink=(TextView) findViewById(R.id.registroBoton);
        usuarios=(EditText)findViewById(R.id.UsuarioLogin);
        //  usuario=((EditText)findViewById(R.id.UsuarioLogin)).getText().toString();
         passwords=(EditText)findViewById(R.id.PasswordLogin);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario=usuarios.getText().toString();
                password= passwords.getText().toString();
         //   Intent i = new Intent(Login.this, MenuDesplegableActivity.class);
           //   startActivity(i);

                if(usuario.endsWith(".com")){
                   usuario = usuario.replaceFirst(".com","");
                }

               EntidadService entidadService = Api.getApi().create(EntidadService.class);
                Call<ArrayList<ClaseEntidad>> listcall= entidadService.getEntidadCorreo(usuario);

                listcall.enqueue(new Callback<ArrayList<ClaseEntidad>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ClaseEntidad>> call, Response<ArrayList<ClaseEntidad>> response) {
                        switch (response.code()){

                           case 200: entidad = response.body().get(0);
                                Toast toast1 =  Toast.makeText(getApplicationContext(),
                                        "PRUEBA", Toast.LENGTH_SHORT);

                                toast1.show();

                                usuario += ".com";
                                if(usuario.equals(entidad.getCorreo().toString())&& password.equals(entidad.getContraseña().toString())){
                                    Toast.makeText(getApplicationContext(),
                                            "Usuario CORRECTO", Toast.LENGTH_SHORT).show();
                                    utils.setEntidad_conectada(entidad);
                                    Intent i=new Intent();
                                    i.setClass(Login.this,MenuDesplegableActivity.class);
                                    startActivity(i);

                                }
                                else {
                                    Toast.makeText(getApplicationContext(),
                                            "Usuario Incorrect", Toast.LENGTH_SHORT).show();
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
                    public void onFailure(Call<ArrayList<ClaseEntidad>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.getCause()+"-"+t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });


            }
        });

    }

    public void Registro(View v)
    {
        Intent i=new Intent();
        i.setClass(this,Registro.class);
        startActivity(i);
    }
    public void CargarDatos(Class<ClaseEntidad> Cl)
    {

    }
}
