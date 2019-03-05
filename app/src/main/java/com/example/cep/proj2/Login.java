package com.example.cep.proj2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button boton = (Button) findViewById(R.id.boton);
        TextView registroLink=(TextView) findViewById(R.id.registroBoton);



        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, MenuDesplegableActivity.class);
               startActivity(i);
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
