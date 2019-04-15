package com.example.cep.proj2.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cep.proj2.Clases.ClaseActividad;
import com.example.cep.proj2.Clases.ClaseMenu;
import com.example.cep.proj2.R;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorActividades extends RecyclerView.Adapter<AdaptadorActividades.ViewHolder> {

    private List<ClaseActividad> listaActividades;

    public AdaptadorActividades(List<ClaseActividad> listaActividades) {
        this.listaActividades = listaActividades;
    }

    //agafa els valors del layout
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_actividades_assignadas, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String act = listaActividades.get(position).getNombre_actividad();
        holder.act.setText(act);
        String espacio = listaActividades.get(position).getId_espacios().toString();
        holder.espacio.setText(espacio);
    }

    //devuelve la cantidad de items
    @Override
    public int getItemCount() {
        return listaActividades.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView act;
        private TextView espacio;

        public ViewHolder(View v) {
            super(v);
            act = (TextView) v.findViewById(R.id.nombreActividad);
            espacio = (TextView) v.findViewById(R.id.instalacion);
        }
    }

}
