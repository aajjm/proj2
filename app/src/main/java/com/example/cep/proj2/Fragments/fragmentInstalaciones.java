package com.example.cep.proj2.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cep.proj2.API.Api;
import com.example.cep.proj2.API.ApiServices.InstalacionService;
import com.example.cep.proj2.Clases.ClaseInstalacion;
import com.example.cep.proj2.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fragmentInstalaciones extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_instalaciones, container, false);

        //InstalacionService instalacionService = Api.getApi().create (InstalacionService.class);

        //Call<ArrayList<ClaseInstalacion>> callInstalaciones = instalacionService.getInstalacion();
        //callInstalaciones.enqueue(new Callback<ArrayList<ClaseInstalacion>>() {
          /*  @Override
            public void onResponse(Call<ArrayList<ClaseInstalacion>> call, Response<ArrayList<ClaseInstalacion>> response) {

            }

            @Override
            public void onFailure(Call<ArrayList<ClaseInstalacion>> call, Throwable t) {

            }
        });*/
    }


}
