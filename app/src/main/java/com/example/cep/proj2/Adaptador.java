package com.example.cep.proj2;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cep.proj2.Clases.ClaseNoticias;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<ClaseNoticias>

    {
        private ArrayList<ClaseNoticias> noticias;
        private Context context;
        private TextView texto;
        private TextView texto2;
        private ImageView imagen;


    public Adaptador(Context context, ArrayList < ClaseNoticias > noticias) {
        super(context, R.layout.fragmento_noticias, noticias);
        this.noticias = noticias;
        this.context = context;

    }
        public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.fragmento_noticias, null);

        imagen=(ImageView) item.findViewById(R.id.Foto);
      //  texto = (TextView) item.findViewById(R.id.TextoTituloL1);
        texto2 = (TextView) item.findViewById(R.id.TextoTituloL2);

       // texto.setText(this.libro.get(position).getUbicacion());
        texto2.setText(this.noticias.get(position).getNombre());
        imagen.setImageResource(this.noticias.get(position).getFoto());

        return (item);
    }
    }