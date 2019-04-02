package com.example.cep.proj2.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.proj2.Clases.ClaseEntidad;
import com.example.cep.proj2.R;

public class Login extends AppCompatActivity {
    private  Button boton;
   // private EditText usuario;
   // private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        boton = (Button) findViewById(R.id.boton);
        TextView registroLink=(TextView) findViewById(R.id.registroBoton);
       final String  usuario=((EditText)findViewById(R.id.UsuarioLogin)).getText().toString();
        final String password=((EditText)findViewById(R.id.PasswordLogin)).getText().toString();
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClaseEntidad entidad= new ClaseEntidad();



               Intent i = new Intent(Login.this, MenuDesplegableActivity.class);
              startActivity(i);
             /*  if(usuario==entidad.getCorreo().toString()&& password==entidad.getContraseña().toString()){

                    Intent i = new Intent(Login.this, MenuDesplegableActivity.class);
                    startActivity(i);


                }
              else {
                    Toast.makeText(getApplicationContext(),
                            "Usuario Incorrect", Toast.LENGTH_SHORT).show();
                }*/
            }
        });




    }



    public void Registro(View v)
    {
        Intent i=new Intent();
        i.setClass(this,Registro.class);
        startActivity(i);
    }
}
