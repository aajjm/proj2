package com.example.cep.proj2.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cep.proj2.Clases.ClaseActividad;
import com.example.cep.proj2.Clases.ClaseEntidad;
import com.example.cep.proj2.Clases.utils;
import com.example.cep.proj2.R;

import java.util.ArrayList;


public class actividades_assignadas extends Fragment {

    public actividades_assignadas() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_actividades_assignadas, container, false);

        //llenamos la listView
        String[] actividades = new String[]{"Entreno Lunes Cadete A",
                                            "Entreno Viernes infantil",
                                            "Entreno Miercoles Senior",
                                            "Partido Sabado benjamin",
                                            "Entreno Martes Cadete B",
                                            "Entreno Lunes pre-benjamin",
                                            "Entreno Miercoles juvenil",
                                            "Partido Jueves pre-benjamin"};

        ListView listView = (ListView) view.findViewById(R.id.list1);
        // Inflate the layout for this fragment
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                actividades
        );

        listView.setAdapter(adapter);

        return view;
    }
}
