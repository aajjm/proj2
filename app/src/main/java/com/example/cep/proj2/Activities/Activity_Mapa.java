package com.example.cep.proj2.Activities;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.TotalCaptureResult;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.cep.proj2.API.Api;
import com.example.cep.proj2.API.ApiServices.EntidadService;
import com.example.cep.proj2.API.ApiServices.InstalacionService;
import com.example.cep.proj2.Clases.ClaseEntidad;
import com.example.cep.proj2.Clases.ClaseInstalacion;
import com.example.cep.proj2.Clases.utils;
import com.example.cep.proj2.Fragments.fragmentInstalaciones;
import com.example.cep.proj2.MensajeError;
import com.example.cep.proj2.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Mapa extends FragmentActivity implements OnMapReadyCallback {


    public Address direccionEntidadad;
    public ArrayList<ClaseInstalacion> instalaciones;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "onMapReady: map is ready");
        mMap = googleMap;
        geoLocate();
        getDeviceLoacation();
        getInstalaciones();
        if (ActivityCompat.checkSelfPermission(this
                , Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mMap.setMyLocationEnabled(true);

    }

    private static final String TAG = "Activity_Map";
    private static final int ERROR_DIALOG_REQUEST = 9001;



    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 12f;

    //vars
    private Boolean mLocationPermissionsGranted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__mapa);

        if(isServiceOk()){
            getLocationPermission();
        }

    }

    private void initMap(){
        Log.d(TAG, "initMap: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(Activity_Mapa.this);
    }

    public boolean isServiceOk(){
        boolean ok = false;
        Log.d(TAG, "isServiceOk: checking google version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Activity_Mapa.this);
        if(available == ConnectionResult.SUCCESS){
            Log.d(TAG, "isServiceOk: Google play service is working");
            ok = true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Log.d(TAG, "isServiceOk: error solucionable");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(Activity_Mapa.this, available,   ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this, "no se puede hacer el mapa", Toast.LENGTH_SHORT).show();
        }

        return ok;
    }

    private void getLocationPermission(){
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionsGranted = true;
                initMap();

            }else{
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else{
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: called.");
        mLocationPermissionsGranted = false;

        switch(requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0){
                    for(int i = 0; i < grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            mLocationPermissionsGranted = false;
                            Log.d(TAG, "onRequestPermissionsResult: permission failed");
                            return;
                        }
                    }
                    Log.d(TAG, "onRequestPermissionsResult: permission granted");
                    mLocationPermissionsGranted = true;
                    //initialize our map
                    initMap();
                }
            }
        }
    }

    private void getDeviceLoacation(){
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        try{
            if(mLocationPermissionsGranted){
                final Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful()){

                            ClaseInstalacion instalacionPorVer = fragmentInstalaciones.pasarInsta;
                            if(instalacionPorVer !=null){
                                Address direccionInsta = geoLocateInsta(instalacionPorVer.getDireccion());
                                MoverCamara(new LatLng(direccionInsta.getLatitude(), direccionInsta.getLongitude()), 16f);
                            }else {
                                MoverCamara(new LatLng(direccionEntidadad.getLatitude(), direccionEntidadad.getLongitude()), DEFAULT_ZOOM);
                            }
                        }else{
                            Toast.makeText(Activity_Mapa.this, "no se encuentra la ubicacion actual", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        }catch(SecurityException ex){
                Log.e(TAG, "security exception" + ex.toString());
        }
    }

    private void MoverCamara(LatLng latlng, float zoom){
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, zoom));
    }

    private void geoLocate(){
        Geocoder geocoder = new Geocoder(Activity_Mapa.this);
        List<Address> list = new ArrayList<>();
        try{
            list = geocoder.getFromLocationName(Login.entidadPrinc.getDireccion(), 1);
        }catch (IOException e){
            Log.e(TAG, "geoLocate: IOException: " + e.getMessage() );
        }

        if(list.size() > 0){
             direccionEntidadad = list.get(0);
        }
    }

    private Address geoLocateInsta(String direccion){
        Geocoder geocoder = new Geocoder(Activity_Mapa.this);
        List<Address> list = new ArrayList<>();
        try{
            list = geocoder.getFromLocationName(direccion, 1);
        }catch (IOException e){
            Log.e(TAG, "geoLocate: IOException: " + e.getMessage() );
        }

        if(list.size() > 0){
         return list.get(0);
        }
        else{
            return null;
        }
    }

    private void getInstalaciones(){
        instalaciones = new ArrayList<ClaseInstalacion>();

        InstalacionService instalacionService = Api.getApi().create(InstalacionService.class);
        Call<ArrayList<ClaseInstalacion>> listcall= instalacionService.getInstalacion();
        listcall.enqueue(new Callback<ArrayList<ClaseInstalacion>>() {
            @Override
            public void onResponse(Call<ArrayList<ClaseInstalacion>> call, Response<ArrayList<ClaseInstalacion>> response) {
                switch (response.code()){

                    case 200:
                        instalaciones = response.body();
                        getMarkerByInstalaciones();
                        break;
                    case 400:

                        Gson gson = new Gson();
                        Toast.makeText(getApplicationContext(),
                                "error de conexion", Toast.LENGTH_SHORT).show();
                        MensajeError mensajeError=gson.fromJson(response.errorBody().charStream(),MensajeError.class);
                        Toast.makeText(getApplicationContext(),mensajeError.getMessage(),Toast.LENGTH_LONG).show();
                        break;
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ClaseInstalacion>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getCause()+"-"+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getMarkerByInstalaciones(){
        if(instalaciones.size()>0){
            Address direccion ;
            for(int i = 0; i<instalaciones.size(); i++){
                direccion = null;
                Geocoder geocoder = new Geocoder(Activity_Mapa.this);
                List<Address> list = new ArrayList<>();
                try{
                    list = geocoder.getFromLocationName(instalaciones.get(i).getDireccion(), 1);
                }catch (IOException e){
                    Log.e(TAG, "geoLocate: IOException: " + e.getMessage() );
                }

                if(list.size() > 0){
                    direccion = list.get(0);
                }

                MarkerOptions ubicacionInsta = new MarkerOptions().position(new LatLng(direccion.getLatitude(), direccion.getLongitude())).title("nombre instalacion : "+instalaciones.get(i).getNombre_instalaciones()).snippet("direccion : " +instalaciones.get(i).getDireccion());
                mMap.addMarker(ubicacionInsta);
            }
            MarkerOptions ubicacionEntidad = new MarkerOptions().position(new LatLng(direccionEntidadad.getLatitude(), direccionEntidadad.getLongitude())).title("entidad : "+ Login.entidadPrinc.getNombre()).snippet("direccion : " + Login.entidadPrinc.getDireccion());
            ubicacionEntidad.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            mMap.addMarker(ubicacionEntidad);
        }
    }
}
