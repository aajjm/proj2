package com.example.cep.proj2.Activities;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.cep.proj2.API.Api;
import com.example.cep.proj2.API.ApiServices.ActividadDemandadaService;
import com.example.cep.proj2.API.ApiServices.ActividadService;
import com.example.cep.proj2.API.ApiServices.EquipoService;
import com.example.cep.proj2.API.ApiServices.EspacioService;
import com.example.cep.proj2.API.ApiServices.HorarioActividadesDemandadas;
import com.example.cep.proj2.API.ApiServices.InstalacionService;
import com.example.cep.proj2.API.ApiServices.PartesService;
import com.example.cep.proj2.Clases.ClaseActividad;
import com.example.cep.proj2.Clases.ClaseActividadDemandada;
import com.example.cep.proj2.Clases.ClaseEntidad;
import com.example.cep.proj2.Clases.ClaseEquipo;
import com.example.cep.proj2.Clases.ClaseEspacio;
import com.example.cep.proj2.Clases.ClaseInstalacion;
import com.example.cep.proj2.Clases.ClasePartes;
import com.example.cep.proj2.Clases.utils;
import com.example.cep.proj2.MensajeError;
import com.example.cep.proj2.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Actividades extends AppCompatActivity implements View.OnClickListener {

    private static final String CERO = "0";
    private static final String DOS_PUNTOS = ":";
    ArrayList<ClaseInstalacion> lista;
    ArrayList<ClaseEspacio> lista2;
    ArrayList<ClaseEquipo> lista3;
    ArrayList<ClasePartes> lista4;

    private List<ClaseActividadDemandada> actividadDemandada;
    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();

    //Variables para obtener la hora hora
    final int hora = c.get(Calendar.HOUR_OF_DAY);
    final int minuto = c.get(Calendar.MINUTE);

    //Widgets
    EditText etHora;
    ImageButton ibObtenerHora;
    EditText etHora2;
    ImageButton ibObtenerHora2;
    EditText nombre;
    RadioButton entrenamiento;
    Spinner instalaciones;
    Spinner espacios;
    Spinner equipos;
    EditText duracion;
    EditText cantidadDias;
    RadioButton lunes;
    RadioButton martes;
    RadioButton miercoles;
    RadioButton jueves;
    RadioButton viernes;
    RadioButton sabado;
    RadioButton domingo;
    private ClaseInstalacion insta = utils.getInstalaciones_conectada();
    private ClaseEspacio esp = utils.getespacio_conectadaa();
    private ClaseEquipo equi = utils.getequipo_conectada();

    ArrayList<String> lista1;
    ArrayList<String>listainstalaciones;
    ArrayList<String>listaequipos;
    ArrayList<String> listaEspacios;
    ArrayList<String> listaPartes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nueva_actividades);

        nombre = (EditText) findViewById(R.id.nombre);
        entrenamiento = (RadioButton) findViewById(R.id.RBentrenament);
        instalaciones = (Spinner) findViewById(R.id.instalacioneslist);
        espacios = (Spinner) findViewById(R.id.espacios);
        equipos = (Spinner) findViewById(R.id.equipos);
        duracion = (EditText) findViewById(R.id.duracionAct);
        cantidadDias = (EditText) findViewById(R.id.CantidadDias);
        etHora = (EditText) findViewById(R.id.et_mostrar_hora_picker);
        ibObtenerHora = (ImageButton) findViewById(R.id.ib_obtener_hora);
        etHora2 = (EditText) findViewById(R.id.et_mostrar_hora_picker);
        ibObtenerHora2 = (ImageButton) findViewById(R.id.ib_obtener_hora2);
        lunes = (RadioButton) findViewById(R.id.RBlunes);
        martes = (RadioButton) findViewById(R.id.RBmartes);
        miercoles = (RadioButton) findViewById(R.id.RBmiercoles);
        jueves = (RadioButton) findViewById(R.id.RBjueves);
        viernes = (RadioButton) findViewById(R.id.RBviernes);
        sabado = (RadioButton) findViewById(R.id.RBsabado);
        domingo = (RadioButton) findViewById(R.id.RBdomingo);
        final Spinner partes = (Spinner) findViewById(R.id.partes);
        Button enviarAct = (Button) findViewById(R.id.aceptarActividad);
        ibObtenerHora.setOnClickListener(this);
        ibObtenerHora2.setOnClickListener(this);


//region INSTALACIONES SERVICE
        InstalacionService instalacionService = Api.getApi().create(InstalacionService.class);
        final Call<ArrayList<ClaseInstalacion>> listInstalaciones = instalacionService.getInstalacion();
        lista = new ArrayList<>();

        listInstalaciones.enqueue(new Callback<ArrayList<ClaseInstalacion>>() {
            @Override
            public void onResponse(Call<ArrayList<ClaseInstalacion>> call, Response<ArrayList<ClaseInstalacion>> response) {
                switch (response.code()) {
                    case 200:
                        lista = response.body();
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "PRUEBA", Toast.LENGTH_SHORT);

                        lista1 = new ArrayList<>();

                        for (int i = 0; i < lista.size(); i++) {
                            lista1.add(lista.get(i).getNombre_instalaciones());
                        }

                        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(Actividades.this, android.R.layout.simple_spinner_item, lista1);
                        instalaciones.setAdapter(adapter);

                        break;
                    case 400:

                        Gson gson = new Gson();
                        Toast.makeText(getApplicationContext(),
                                "Conexion mal ", Toast.LENGTH_SHORT).show();
                        MensajeError mensajeError = gson.fromJson(response.errorBody().charStream(), MensajeError.class);
                        Toast.makeText(getApplicationContext(), mensajeError.getMessage(), Toast.LENGTH_LONG).show();
                        break;
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ClaseInstalacion>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        //endregion

//region ESPACIOS SERVICE
        EspacioService espacioService = Api.getApi().create(EspacioService.class);
        final Call<ArrayList<ClaseEspacio>> listEspacios = espacioService.getEspacios();

        lista2 = new ArrayList<>();
        listEspacios.enqueue(new Callback<ArrayList<ClaseEspacio>>() {
            @Override
            public void onResponse(Call<ArrayList<ClaseEspacio>> call, Response<ArrayList<ClaseEspacio>> response) {
                switch (response.code()) {
                    case 200:
                        lista2 = response.body();

                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "PRUEBA", Toast.LENGTH_SHORT);

                        listainstalaciones = new ArrayList<>();

                        for (int j = 0; j < lista2.size(); j++) {
                            listainstalaciones.add(lista2.get(j).getNombre_espacios());
                        }
                        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(Actividades.this, android.R.layout.simple_spinner_item, listainstalaciones);
                        espacios.setAdapter(adapter);
                        break;
                    case 400:

                        Gson gson = new Gson();
                        Toast.makeText(getApplicationContext(),
                                "Conexion mal ", Toast.LENGTH_SHORT).show();
                        MensajeError mensajeError = gson.fromJson(response.errorBody().charStream(), MensajeError.class);
                        Toast.makeText(getApplicationContext(), mensajeError.getMessage(), Toast.LENGTH_LONG).show();
                        break;
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ClaseEspacio>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

//EQUIPOS
        EquipoService equipoService = Api.getApi().create(EquipoService.class);
        final Call<ArrayList<ClaseEquipo>> listCall = equipoService.getEquipo();

        lista3 = new ArrayList<>();
        listCall.enqueue(new Callback<ArrayList<ClaseEquipo>>() {
            @Override
            public void onResponse(Call<ArrayList<ClaseEquipo>> call, Response<ArrayList<ClaseEquipo>> response) {
                switch (response.code()) {
                    case 200:
                        lista3 = response.body();

                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "PRUEBA", Toast.LENGTH_SHORT);

                        listaequipos = new ArrayList<>();

                        for (int j = 0; j < lista3.size(); j++) {
                            listaequipos.add(lista3.get(j).getNombre_equipo().toString());
                        }
                        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(Actividades.this, android.R.layout.simple_spinner_item, listaequipos);
                        equipos.setAdapter(adapter);
                        break;
                    case 400:

                        Gson gson = new Gson();
                        Toast.makeText(getApplicationContext(),
                                "Conexion mal ", Toast.LENGTH_SHORT).show();
                        MensajeError mensajeError = gson.fromJson(response.errorBody().charStream(), MensajeError.class);
                        Toast.makeText(getApplicationContext(), mensajeError.getMessage(), Toast.LENGTH_LONG).show();
                        break;
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ClaseEquipo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        //PARTES
        PartesService partesService = Api.getApi().create(PartesService.class);
        final Call<ArrayList<ClasePartes>> listPa = partesService.getParte();

        lista4 = new ArrayList<>();
        listPa.enqueue(new Callback<ArrayList<ClasePartes>>() {
            @Override
            public void onResponse(Call<ArrayList<ClasePartes>> call, Response<ArrayList<ClasePartes>> response) {
                switch (response.code()) {
                    case 200:
                        lista4 = response.body();

                         listaPartes = new ArrayList<>();

                        for (int j = 0; j < lista4.size(); j++) {
                            listaPartes.add(lista4.get(j).getNombre());
                        }
                        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(Actividades.this, android.R.layout.simple_spinner_item, listaPartes);
                        partes.setAdapter(adapter);
                        break;
                    case 400:

                        Gson gson = new Gson();
                        Toast.makeText(getApplicationContext(),
                                "Conexion mal ", Toast.LENGTH_SHORT).show();
                        MensajeError mensajeError = gson.fromJson(response.errorBody().charStream(), MensajeError.class);
                        Toast.makeText(getApplicationContext(), mensajeError.getMessage(), Toast.LENGTH_LONG).show();
                        break;
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ClasePartes>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getCause() + " - " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    /*   instalaciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinnerInstalaciones = parent.getItemAtPosition(position).toString(); // posicion de

                for (int i = 0; i < lista2.size(); i++) {
                    listaEspacios = new ArrayList<>();

                    if (spinnerInstalaciones.equals(lista2.get(i))) {
                        listaequipos.add(lista2.get(i).getNombre_espacios().toString());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapter2 = new ArrayAdapter(Actividades.this, android.R.layout.simple_spinner_item, listaEspacios);
        espacios.setAdapter(adapter2);*/

    }
//endregion

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_obtener_hora:
                obtenerHora();
                break;
            case R.id.ib_obtener_hora2:
                obtenerHora();
                break;
            case R.id.aceptarActividad:
                ClaseActividadDemandada actividadDemandada = new ClaseActividadDemandada();

                if( !(  nombre.getText().toString().isEmpty() || entrenamiento.isSelected()|| entrenamiento.getText().toString().isEmpty()||
                        duracion.getText().toString().isEmpty()|| cantidadDias.getText().toString().isEmpty()|| lunes.isSelected()|| martes.isSelected()|| miercoles.isSelected()||
                        jueves.isSelected() || viernes.isSelected() || sabado.isSelected() || domingo.isSelected())) {

                    actividadDemandada.setNombre_actividades_demandadas(nombre.getText().toString());
                    actividadDemandada.setTipo_entrenamiento(entrenamiento.isChecked());
                    actividadDemandada.setId_espacio(espacios.getId());
                    actividadDemandada.setId_equipo(equipos.getId());
                    actividadDemandada.setDuracion(Float.parseFloat(duracion.getText().toString()));
                    actividadDemandada.setDias_semanales(Integer.parseInt(cantidadDias.getText().toString()));
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
                break;
        }
    }

    private void obtenerHora() {
        TimePickerDialog recogerHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Formateo el hora obtenido: antepone el 0 si son menores de 10
                String horaFormateada = (hourOfDay < 10) ? String.valueOf(CERO + hourOfDay) : String.valueOf(hourOfDay);
                //Formateo el minuto obtenido: antepone el 0 si son menores de 10
                String minutoFormateado = (minute < 10) ? String.valueOf(CERO + minute) : String.valueOf(minute);
                //Obtengo el valor a.m. o p.m., dependiendo de la selección del usuario
                String AM_PM;
                if (hourOfDay < 12) {
                    AM_PM = "a.m.";
                } else {
                    AM_PM = "p.m.";
                }
                //Muestro la hora con el formato deseado
                etHora.setText(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }
            //Estos valores deben ir en ese orden
            //Al colocar en false se muestra en formato 12 horas y true en formato 24 horas
            //Pero el sistema devuelve la hora en formato 24 horas
        }, hora, minuto, false);

        recogerHora.show();
    }
}