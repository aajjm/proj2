package com.example.cep.proj2.Adaptadores;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.cep.proj2.Clases.ClaseInstalacion;
import com.example.cep.proj2.R;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewInstalacionesAdapter extends RecyclerView.Adapter<RecyclerViewInstalacionesAdapter.MyViewHolder>

{
    private ArrayList<ClaseInstalacion> listaInstalaciones;
    private OnItemClickListener mlistener;

    public interface OnItemClickListener{
        void onMapClick(int position);

        void onTextClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mlistener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView nombreInstalacion;
        public ImageView imgMap;

        public MyViewHolder(View itemView, final OnItemClickListener listener)
        {
            super(itemView);
            nombreInstalacion = itemView.findViewById(R.id.nombreInstalacion);
            imgMap = itemView.findViewById(R.id.imgMap);

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

            imgMap.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            listener.onMapClick(pos);
                        }
                    }
                }
            });
        }
    }

    public RecyclerViewInstalacionesAdapter(ArrayList<ClaseInstalacion> listaInstalaciones)
    {
        this.listaInstalaciones = listaInstalaciones;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.iteminstalaciones,parent,false);
        MyViewHolder mvh = new MyViewHolder(v,mlistener);
        return mvh;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.nombreInstalacion.setText(listaInstalaciones.get(position).getNombre_instalaciones());
        holder.imgMap.setImageResource(R.drawable.map);
    }

    @Override
    public int getItemCount()
    {
        return listaInstalaciones.size();
    }
}
