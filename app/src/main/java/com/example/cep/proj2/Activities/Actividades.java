package com.example.cep.proj2.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.cep.proj2.API.Api;
import com.example.cep.proj2.API.ApiServices.ActividadDemandadaService;
import com.example.cep.proj2.API.ApiServices.ActividadService;
import com.example.cep.proj2.API.ApiServices.HorarioActividadesDemandadas;
import com.example.cep.proj2.Clases.ClaseActividad;
import com.example.cep.proj2.Clases.ClaseActividadDemandada;
import com.example.cep.proj2.Clases.ClaseEspacio;
import com.example.cep.proj2.MensajeError;
import com.example.cep.proj2.R;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Actividades extends AppCompatActivity  {

   // private List<ClaseActividadDemandada> actividadDemandada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nueva_actividades);

        final EditText nombre = (EditText) findViewById(R.id.nombre);
        final RadioButton entrenamiento = (RadioButton) findViewById(R.id.RBentrenament);
        final RadioButton partido = (RadioButton) findViewById(R.id.RBpartido);
        final Spinner espacios = (Spinner) findViewById(R.id.espacios);
        final Spinner equipos = (Spinner) findViewById(R.id.equipos);
        final EditText duracion = (EditText) findViewById(R.id.duracionAct);
        final EditText cantidadDias = (EditText) findViewById(R.id.CantidadDias);
        final TimePicker horaEmpieza = (TimePicker) findViewById(R.id.horaEmpieza);
        final TimePicker horaFinal = (TimePicker) findViewById(R.id.horaTermina);
        final RadioButton lunes = (RadioButton) findViewById(R.id.RBlunes);
        final RadioButton martes = (RadioButton) findViewById(R.id.RBmartes);
        final RadioButton miercoles = (RadioButton) findViewById(R.id.RBmiercoles);
        final RadioButton jueves = (RadioButton) findViewById(R.id.RBjueves);
        final RadioButton viernes = (RadioButton) findViewById(R.id.RBviernes);
        final RadioButton sabado = (RadioButton) findViewById(R.id.RBsabado);
        final RadioButton domingo = (RadioButton) findViewById(R.id.RBdomingo);
        final Spinner partes = (Spinner) findViewById(R.id.partes);
        Button enviarAct = (Button) findViewById(R.id.aceptarActividad);

        horaEmpieza.setIs24HourView(true);
        horaFinal.setIs24HourView(true);
        horaEmpieza.setOnTimeChangedListener ( new TimePicker.OnTimeChangedListener () {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

            }
        });
        enviarAct.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                ClaseActividadDemandada actividadDemandada = new ClaseActividadDemandada();

                if( !(  nombre.getText().toString().isEmpty() || entrenamiento.isSelected()|| entrenamiento.getText().toString().isEmpty() || partido.getText().toString().isEmpty()||
                         duracion.getText().toString().isEmpty()|| cantidadDias.getText().toString().isEmpty()|| lunes.isSelected()|| martes.isSelected()|| miercoles.isSelected()||
                         jueves.isSelected() || viernes.isSelected() || sabado.isSelected() || domingo.isSelected())) {

                     actividadDemandada.setNombre_actividades_demandadas(nombre.getText().toString());
                     actividadDemandada.setTipo_entrenamiento(entrenamiento.isChecked());
                     actividadDemandada.setId_espacio(espacios.getId());
                     actividadDemandada.setId_equipo(equipos.getId());
                     actividadDemandada.setDuracion(Float.parseFloat(duracion.getText().toString()));
                     actividadDemandada.setDias_semanales(Integer.parseInt(cantidadDias.getText().toString()));
                     //actividadDemandada.setIntervalo_horario(horaEmpieza.is24HourView());
                    //actividadDemandada.setDias_favorables();
                     actividadDemandada.setPartes_pista_demandada(partes.getId());
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "Introduce Todos Los Datos", Toast.LENGTH_SHORT).show();
                }

                ActividadDemandadaService actividadDemandadaService = Api.getApi().create(ActividadDemandadaService.class); // para coger los datos
                //para acceder a los datos
                Call<ClaseActividadDemandada> listaActividadesDemandadas  = actividadDemandadaService.InsertarActividadDemandada(actividadDemandada);
                listaActividadesDemandadas.enqueue(new Callback<ClaseActividadDemandada>() {
                    @Override
                    public void onResponse(Call<ClaseActividadDemandada> call, Response<ClaseActividadDemandada> response) {
                        //cuando va bien
                        switch (response.code()){

                            case 201:
                                Toast toast1 =  Toast.makeText(getApplicationContext(),"creada", Toast.LENGTH_SHORT);
                                toast1.show();
                                Intent i=new Intent();
                                i.setClass(Actividades.this,MenuDesplegableActivity.class);
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
                    public void onFailure(Call<ClaseActividadDemandada> call, Throwable t) {
                        //cuando va mal
                        Toast.makeText(getApplicationContext(),t.getCause() + " - " + t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
