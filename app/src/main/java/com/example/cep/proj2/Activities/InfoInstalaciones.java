package com.example.cep.proj2.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.cep.proj2.API.Api;
import com.example.cep.proj2.API.ApiServices.HorarioInstalaciones;
import com.example.cep.proj2.Clases.ClaseHorarioInstalacion;
import com.example.cep.proj2.Clases.ClaseInstalacion;
import com.example.cep.proj2.MensajeError;
import com.example.cep.proj2.R;
import com.example.cep.proj2.Fragments.fragmentInstalaciones;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoInstalaciones extends AppCompatActivity {

    List<String> list;
    Spinner comboDias;
    ArrayList<ClaseHorarioInstalacion> lista;
    ArrayList<ClaseHorarioInstalacion> listHorarioInstalaciones;
    ArrayList<ClaseHorarioInstalacion> finallista;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion_instalaciones);
        ClaseInstalacion c = new ClaseInstalacion();
                comboDias = (Spinner) findViewById(R.id.spinner);
        final TextView horarioInicio1       = (TextView)  findViewById(R.id.horarioInicio1);
        final TextView horarioTarde1        = (TextView)  findViewById(R.id.horarioTarde1);
        final TextView horarioInicio2       = (TextView)  findViewById(R.id.horarioInicio2);
        final TextView horarioTarde2        = (TextView)  findViewById(R.id.horarioTarde2);
        final TextView nombreInstalacion    = (TextView)  findViewById(R.id.nombreInstalacion);
        final TextView direccion            = (TextView)  findViewById(R.id.direccion);
        final CheckBox gestionPublica       = (CheckBox)  findViewById(R.id.gestionpublica);

        //Intent i = getIntent();
        if(Activity_Mapa.markerClicked){
            c= Activity_Mapa.unaInstalacion;
        }
        else{
            c = fragmentInstalaciones.pasarInsta;
        }

        nombreInstalacion.setText(c.getNombre_instalaciones());
        direccion.setText(c.getDireccion());

        gestionPublica.setEnabled(false);
        if(c.isGestion_publica() == true)
        {
            gestionPublica.setChecked(true);
        }
        else
        {
            gestionPublica.setChecked(false);
        }

        HorarioInstalaciones horarioInstalaciones = Api.getApi().create(HorarioInstalaciones.class);
        final Call<ArrayList<ClaseHorarioInstalacion>> listaHorarioInsta= horarioInstalaciones.getHorarioInstalaciones();
        lista = new ArrayList<>();

        listaHorarioInsta.enqueue(new Callback<ArrayList<ClaseHorarioInstalacion>>() {
            @Override
            public void onResponse(Call<ArrayList<ClaseHorarioInstalacion>> call, Response<ArrayList<ClaseHorarioInstalacion>> response) {
                switch (response.code()){
                    case 200:
                        lista = response.body();
                        Toast toast1 =  Toast.makeText(getApplicationContext(),
                                "PRUEBA", Toast.LENGTH_SHORT);

                        ArrayList<String> lista1 = new ArrayList<>();

                        for(int i = 0; i < lista.size(); i++)
                        {
                            listHorarioInstalaciones.add(lista.get(i));
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
            public void onFailure(Call<ArrayList<ClaseHorarioInstalacion>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getCause() + " - " + t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        if(!listHorarioInstalaciones.isEmpty())
        {
            for (int i = 0; i <listHorarioInstalaciones.size();i++)
            {
                if(listHorarioInstalaciones.get(i).getId_dia() == (c.getId()))
                {
                    finallista.add(listHorarioInstalaciones.get(i));
                }
            }
        }



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combo_dias, android.R.layout.simple_spinner_item );
        comboDias.setAdapter(adapter);

        final ArrayList<ClaseHorarioInstalacion> ArrayHorario = finallista;

        /*
        // Para rellenar los datos del Horario
        comboDias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getItemAtPosition(position).toString())
                {
                    case "Lunes":
                        if(ArrayHorario.size()>8)
                        {
                            horarioInicio1.setText(ArrayHorario.get(0).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(0).getHora_Final());
                            horarioInicio2.setText(ArrayHorario.get(7).getHora_inicio());
                            horarioTarde2.setText(ArrayHorario.get(7).getHora_Final());
                        }
                        else
                        {
                            horarioInicio1.setText(ArrayHorario.get(0).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(0).getHora_Final());
                            horarioInicio2.setText("--:--");
                            horarioTarde2.setText("--:--");
                        }
                        break;
                    case "Martes":
                        if(ArrayHorario.size()>8)
                        {
                            horarioInicio1.setText(ArrayHorario.get(1).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(1).getHora_Final());
                            horarioInicio2.setText(ArrayHorario.get(8).getHora_inicio());
                            horarioTarde2.setText(ArrayHorario.get(8).getHora_Final());
                        }
                        else
                        {
                            horarioInicio1.setText(ArrayHorario.get(1).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(1).getHora_Final());
                            horarioInicio2.setText("--:--");
                            horarioTarde2.setText("--:--");
                        }
                        break;
                    case "Miercoles":
                        if(ArrayHorario.size()>8)
                        {
                            horarioInicio1.setText(ArrayHorario.get(2).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(2).getHora_Final());
                            horarioInicio2.setText(ArrayHorario.get(9).getHora_inicio());
                            horarioTarde2.setText(ArrayHorario.get(9).getHora_Final());
                        }
                        else
                        {
                            horarioInicio1.setText(ArrayHorario.get(2).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(2).getHora_Final());
                            horarioInicio2.setText("--:--");
                            horarioTarde2.setText("--:--");
                        }
                        break;
                    case "Jueves":
                        if(ArrayHorario.size()>8)
                        {
                            horarioInicio1.setText(ArrayHorario.get(3).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(3).getHora_Final());
                            horarioInicio2.setText(ArrayHorario.get(10).getHora_inicio());
                            horarioTarde2.setText(ArrayHorario.get(10).getHora_Final());
                        }
                        else
                        {
                            horarioInicio1.setText(ArrayHorario.get(3).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(3).getHora_Final());
                            horarioInicio2.setText("--:--");
                            horarioTarde2.setText("--:--");
                        }
                        break;
                    case "Viernes":
                        if(ArrayHorario.size()>8)
                        {
                            horarioInicio1.setText(ArrayHorario.get(4).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(4).getHora_Final());
                            horarioInicio2.setText(ArrayHorario.get(11).getHora_inicio());
                            horarioTarde2.setText(ArrayHorario.get(11).getHora_Final());
                        }
                        else
                        {
                            horarioInicio1.setText(ArrayHorario.get(4).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(4).getHora_Final());
                            horarioInicio2.setText("--:--");
                            horarioTarde2.setText("--:--");
                        }
                        break;
                    case "Sabado":
                        if(ArrayHorario.size()>8)
                        {
                            horarioInicio1.setText(ArrayHorario.get(5).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(5).getHora_Final());
                            horarioInicio2.setText(ArrayHorario.get(12).getHora_inicio());
                            horarioTarde2.setText(ArrayHorario.get(12).getHora_Final());
                        }
                        else
                        {
                            horarioInicio1.setText(ArrayHorario.get(5).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(5).getHora_Final());
                            horarioInicio2.setText("--:--");
                            horarioTarde2.setText("--:--");
                        }
                        break;
                    case "Domingo":
                        if(ArrayHorario.size()>8)
                        {
                            horarioInicio1.setText(ArrayHorario.get(6).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(6).getHora_Final());
                            horarioInicio2.setText(ArrayHorario.get(13).getHora_inicio());
                            horarioTarde2.setText(ArrayHorario.get(13).getHora_Final());
                        }
                        else
                        {
                            horarioInicio1.setText(ArrayHorario.get(6).getHora_inicio());
                            horarioTarde1.setText(ArrayHorario.get(6).getHora_Final());
                            horarioInicio2.setText("--:--");
                            horarioTarde2.setText("--:--");
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });*/
    }
}

