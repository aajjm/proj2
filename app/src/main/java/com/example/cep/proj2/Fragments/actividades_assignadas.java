package com.example.cep.proj2.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.proj2.Adaptadores.Adaptador_Actividades_Assignadas;
import com.example.cep.proj2.Clases.ClaseActividad;
import com.example.cep.proj2.Clases.ClaseEntidad;
import com.example.cep.proj2.Clases.utils;
import com.example.cep.proj2.R;

import java.util.ArrayList;


public class actividades_assignadas extends Fragment {

    private ClaseActividad actividad = utils.getActividad_conectada();
    ArrayList<ClaseActividad> act =new ArrayList<>();

    public actividades_assignadas() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_actividades_assignadas, container, false);

        GridView gridView = (GridView) getView().findViewById(R.id.gridActividades);
        gridView.setAdapter(new Adaptador_Actividades_Assignadas(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(AccionFragment.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
