package com.example.cep.proj2.Fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
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



             TextView   texto2 = (TextView) item.findViewById(R.id.TextoTituloL2);


                texto2.setText(AdaptadorMenuPrincipal.getEnvironments().get(position).getNombre());
                imagen.setImageResource(AdaptadorMenuPrincipal.getEnvironments().get(position).getFoto());


                return (item);
            }
        }

    public static class actividades_demandadas extends Fragment {


        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";


        private String mParam1;
        private String mParam2;

        private OnFragmentInteractionListener mListener;

        public actividades_demandadas() {


        }

        public static actividades_demandadas newInstance(String param1, String param2) {
            actividades_demandadas fragment = new actividades_demandadas();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            return inflater.inflate(R.layout.fragment_actividades_demandadas, container, false);
        }


        public void onButtonPressed(Uri uri) {
            if (mListener != null) {
                mListener.onFragmentInteraction(uri);
            }
        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            if (context instanceof OnFragmentInteractionListener) {
                mListener = (OnFragmentInteractionListener) context;
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement OnFragmentInteractionListener");
            }
        }

        @Override
        public void onDetach() {
            super.onDetach();
            mListener = null;
        }

        public interface OnFragmentInteractionListener {

            void onFragmentInteraction(Uri uri);
        }
    }
}
