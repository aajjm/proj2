package com.example.cep.proj2.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cep.proj2.Clases.ClaseEquipo;
import com.example.cep.proj2.Clases.ClaseInstalacion;
import com.example.cep.proj2.R;

import java.util.ArrayList;

public class RecyclerViewEquiposAdapater extends RecyclerView.Adapter<RecyclerViewEquiposAdapater.MyViewHolder> {
    private ArrayList<ClaseEquipo> listaEquipo;
    private OnItemClickListener mlistener;

    public interface OnItemClickListener{
        void onTextClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mlistener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView nombreEquipo;
        public ImageView imgSport;

        public MyViewHolder(View itemView, final OnItemClickListener listener)
        {
            super(itemView);
            nombreEquipo = itemView.findViewById(R.id.nombreDeEquipos);
            imgSport = itemView.findViewById(R.id.imgSport);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            listener.onTextClick(pos);
                        }
                    }
                }
            });
        }
    }

    public RecyclerViewEquiposAdapater(ArrayList<ClaseEquipo> listaEquipo)
    {
        this.listaEquipo = listaEquipo;
    }

    @NonNull
    @Override
    public RecyclerViewEquiposAdapater.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_listequipos,parent,false);
        RecyclerViewEquiposAdapater.MyViewHolder mvh = new RecyclerViewEquiposAdapater.MyViewHolder(v,mlistener);
        return mvh;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewEquiposAdapater.MyViewHolder holder, int position)
    {
        holder.nombreEquipo.setText(listaEquipo.get(position).getNombre_equipo());
        holder.imgSport.setImageResource(R.drawable.deporte);
    }

    @Override
    public int getItemCount()
    {
        return listaEquipo.size();
    }
}
