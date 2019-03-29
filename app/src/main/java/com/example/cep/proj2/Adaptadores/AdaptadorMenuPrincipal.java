package com.example.cep.proj2.Adaptadores;

import com.example.cep.proj2.Clases.ClaseMenu;
import com.example.cep.proj2.R;

import java.util.ArrayList;

public class AdaptadorMenuPrincipal {
    public static ArrayList<ClaseMenu> getEnvironments()
    {
        ArrayList<ClaseMenu> lista=new ArrayList<>();
        lista.add(new ClaseMenu(R.mipmap.contacto1_round,"Actividades"));
        lista.add(new ClaseMenu(R.mipmap.contacto1_round,"Entidades"));
        lista.add(new ClaseMenu(R.mipmap.contacto1_round,"Instalaciones"));
        lista.add(new ClaseMenu(R.mipmap.contacto1_round,"Nosotros"));

        return lista;

    }
}
