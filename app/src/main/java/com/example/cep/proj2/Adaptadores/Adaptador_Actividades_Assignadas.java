package com.example.cep.proj2.Adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cep.proj2.Clases.ClaseActividad;
import com.example.cep.proj2.Fragments.actividades_assignadas;

public class Adaptador_Actividades_Assignadas extends BaseAdapter {

private final Context context;
private final ClaseActividad[] act;



    public Adaptador_Actividades_Assignadas(actividades_assignadas actividades_assignadas) {

        context = null;
        act = new ClaseActividad[0];
    }

    @Override
    public int getCount() {
        return act.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView actividades = new TextView(context);
        actividades.setText(String.valueOf(position));
        return actividades;
    }
}
