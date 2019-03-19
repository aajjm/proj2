package com.example.cep.proj2.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cep.proj2.Clases.ClaseNoticias;
import com.example.cep.proj2.R;

import java.util.ArrayList;


public class fragmentoNoticias extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragmento_noticias, container, false);
    }
    private ArrayList<ClaseNoticias> LlenarMenu(){

        ArrayList<ClaseNoticias> lista=new ArrayList<>();
        lista.add(new ClaseNoticias(R.drawable.futbol,"Librerías"));
        //lista.add(new ClaseNoticias(R.mipmap.jigsaw,"Actividades"));
        //lista.add(new ClaseNoticias(R.mipmap.equipo,"Datos de Red"));
        //lista.add(new ClaseNoticias(R.mipmap.servicio,"Atención al Cliente"));

        return lista;
    }
}
