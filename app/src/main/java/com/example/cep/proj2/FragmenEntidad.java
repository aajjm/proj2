package com.example.cep.proj2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cep.proj2.Clases.ClaseEntidad;


public class FragmenEntidad extends Fragment {

private EditText Nombre;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_entidad, container, false);






        }
    @Override
    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);

    }
    }





