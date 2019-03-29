package com.example.cep.proj2.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cep.proj2.Adaptadores.AdaptadorMenuPrincipal;
import com.example.cep.proj2.Clases.ClaseMenu;
import com.example.cep.proj2.R;

public class fragmentMenuPrincipal extends Fragment {



        private GridView GridListado;
        private EnvioremntListener listener;
        @Override
        public View onCreateView(LayoutInflater inflater,
                ViewGroup container,
                Bundle savedInstanceState) {

            return inflater.inflate(R.layout.fragment_menu_principal, container, false);
        }

        @Override
        public void onActivityCreated(Bundle state) {
            super.onActivityCreated(state);

            GridListado = (GridView) getView().findViewById(R.id.gridview);

            GridListado.setAdapter(new AdaptadorEnvioremnt(this));
            GridListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(listener!=null){
                        listener.onEnviromentSeleccionado((ClaseMenu)GridListado.getAdapter().getItem(position));
                    }
                }
            });
        }
        public interface EnvioremntListener {
            void onEnviromentSeleccionado(ClaseMenu c);
        }

        public void setEnviromentListener(EnvioremntListener listener) {
            this.listener=listener;
        }

        class AdaptadorEnvioremnt extends ArrayAdapter<ClaseMenu> {

            Activity context;

            AdaptadorEnvioremnt(Fragment context) {
                super(context.getActivity(), R.layout.item_menu_principal, AdaptadorMenuPrincipal.getEnvironments());
                this.context = context.getActivity();
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = context.getLayoutInflater();
                View item = inflater.inflate(R.layout.item_menu_principal, null);

               ImageView imagen=(ImageView) item.findViewById(R.id.Foto);
                //  texto = (TextView) item.findViewById(R.id.TextoTituloL1);


             TextView   texto2 = (TextView) item.findViewById(R.id.TextoTituloL2);

                // texto.setText(this.libro.get(position).getUbicacion());
                texto2.setText(AdaptadorMenuPrincipal.getEnvironments().get(position).getNombre());
                imagen.setImageResource(AdaptadorMenuPrincipal.getEnvironments().get(position).getFoto());


                return (item);
            }
        }

    }
