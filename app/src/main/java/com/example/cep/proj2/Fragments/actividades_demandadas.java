package com.example.cep.proj2.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cep.proj2.R;

public class actividades_demandadas extends Fragment {


    public actividades_demandadas() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_actividades_demandadas, container, false);

        //llenamos la listView
        String[] actividades = new String[]{"Partido Senior",
                                            "partido femenino",
                                            "partido juvenil",
                                            "Entreno benjamin",
                                            "Partido Cadete A",
                                            "Partido pre-benjamin",
                                            "Partido senior",
                                            "Partido pre-benjamin"};

        ListView listView = (ListView) view.findViewById(R.id.listView);
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
