package com.example.cep.proj2.Adaptadores;

import com.example.cep.proj2.Clases.ClaseMenu;
import com.example.cep.proj2.R;

import java.util.ArrayList;

public class AdaptadorMenuPrincipal {
    public static ArrayList<ClaseMenu> getEnvironments()
    {
        ArrayList<ClaseMenu> lista=new ArrayList<>();
        lista.add(new ClaseMenu(R.drawable.ico_map,"Mapa Instalaciones"));
        lista.add(new ClaseMenu(R.drawable.ico_insta,"Instalaciones"));
        lista.add(new ClaseMenu(R.drawable.ico_trofeo2,"Nueva Actividad"));
        lista.add(new ClaseMenu(R.drawable.ico_consultar,"Consultar Actividades"));
        lista.add(new ClaseMenu(R.drawable.ico_man,"Perfil"));
        lista.add(new ClaseMenu(R.drawable.ico_sym,"Equipos"));

        return lista;

    }
}
