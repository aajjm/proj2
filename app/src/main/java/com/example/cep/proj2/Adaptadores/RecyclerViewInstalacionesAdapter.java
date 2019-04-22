package com.example.cep.proj2.Adaptadores;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.cep.proj2.Clases.ClaseInstalacion;
import com.example.cep.proj2.R;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewInstalacionesAdapter extends RecyclerView.Adapter<RecyclerViewInstalacionesAdapter.MyViewHolder>
        implements View.OnClickListener
{
    List<ClaseInstalacion> listaInstalaciones;
    private View.OnClickListener listener;

    public RecyclerViewInstalacionesAdapter(ArrayList<ClaseInstalacion> listaInstalaciones)
    {
        this.listaInstalaciones = listaInstalaciones;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.iteminstalaciones,parent,false);

        v.setOnClickListener(this);

        return new MyViewHolder(v);
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.nombreInstalacion.setText(listaInstalaciones.get(position).getNombre_instalaciones());
    }

    @Override
    public int getItemCount()
    {
        return listaInstalaciones.size();
    }

    @Override
    public void onClick(View v) {
        if(listener!=null)
        {
            listener.onClick(v);
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView nombreInstalacion;

        public MyViewHolder(View itemView)
        {
            super(itemView);

            nombreInstalacion = (TextView) itemView.findViewById(R.id.nombreInstalacion);
        }
    }
}
