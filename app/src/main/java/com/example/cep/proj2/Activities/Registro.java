package com.example.cep.proj2.Activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.cep.proj2.API.Api;
import com.example.cep.proj2.API.ApiServices.EntidadService;
import com.example.cep.proj2.Clases.ClaseEntidad;
import com.example.cep.proj2.MensajeError;
import com.example.cep.proj2.R;
import com.google.gson.Gson;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registro extends AppCompatActivity {
    VideoView videoCOmpleto;
    EditText video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        final EditText  Nombre =(EditText) findViewById(R.id.nombre);
        final EditText direccion=(EditText) findViewById(R.id.direccion);
        final EditText NIF =(EditText) findViewById(R.id.NIF);
        final EditText Correo =(EditText) findViewById(R.id.Correo);
        final EditText Altitud =(EditText) findViewById(R.id.altitud);
        final EditText Latitud =(EditText) findViewById(R.id.latitud);
        final EditText Contraseña =(EditText)findViewById(R.id.contraseña);
        final EditText RepContraseña =(EditText) findViewById(R.id.repcontraseña);
        final Button botonaceptar=(Button) findViewById(R.id.registrar);
        video=(EditText) findViewById(R.id.video);
        videoCOmpleto=(VideoView) findViewById(R.id.videoprueba);
      //  String path ="android.resource://"+getPackageName()+"/"+R.raw.corazon;
        final Button but=(Button)findViewById(R.id.url);
        but.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                CargarVideo();
              //  videoCOmpleto.setVideoURI(Uri.parse(getExternalFilesDir(null)+"/"+archivos[arg2]));
               // videoCOmpleto.start();
            }
        });

        //videoCOmpleto.setMediaController(new MediaController(this));
       // String URLFile=video.getText().toString();
        //videoCOmpleto.setVideoPath(path);
        //videoCOmpleto.start();
        //videoCOmpleto.requestFocus();



       // Uri paths = Uri.parse("android.resource://com.example.reproducirvideo/"
       //         + R.raw.corazon);
       //videoCOmpleto.setVideoURI(Uri.parse(path));



        botonaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClaseEntidad entidad= new ClaseEntidad();

                if( !(Nombre.getText().toString().isEmpty()
                        || direccion.getText().toString().isEmpty() || NIF.getText().toString().isEmpty() || Correo.getText().toString().isEmpty()
                        || Contraseña.getText().toString().isEmpty()|| Latitud.getText().toString().isEmpty()|| Altitud.getText().toString().isEmpty())){
                    entidad.setVideo(video.getText().toString());
                    entidad.setNombre(Nombre.getText().toString());
                    entidad.setDireccion(direccion.getText().toString());
                    entidad.setNIF(NIF.getText().toString());

                    entidad.setAltitud(Altitud.getText().toString());
                    entidad.setLatitud(Latitud.getText().toString());
                    entidad.setTemporada("2018-2019");
                    if(validarEmail(Correo.getText().toString())){
                        entidad.setCorreo(Correo.getText().toString());
                    }else {
                        Toast.makeText(getApplicationContext(),
                                "Correo MAl", Toast.LENGTH_SHORT).show();
                    }
;

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


}

    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
    public void CargarVideo(){
        Intent intent=new Intent(Intent.ACTION_PICK,MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        intent.setType("video/");
        startActivityForResult(intent,1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == Activity.RESULT_OK)
        {
            try
            {
                String path = data.getData().toString();
                videoCOmpleto.setVideoPath(path);
                video.setText(path);
                videoCOmpleto.requestFocus();
                videoCOmpleto.start();

            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
