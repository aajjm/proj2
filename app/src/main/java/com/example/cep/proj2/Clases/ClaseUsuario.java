package com.example.cep.proj2.Clases;

public class ClaseUsuario {



        private String nombre;
        private String direccion;
        private String NIF;

        private String correo;
        private int latitud;
        private int altitud;
        private String contraseña;

    public ClaseUsuario(String nombre, String direccion, String NIF, String correo, int latitud, int altitud, String contraseña) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.NIF = NIF;
        this.correo = correo;
        this.latitud = latitud;
        this.altitud = altitud;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNIF() {
        return NIF;
    }

    public String getCorreo() {
        return correo;
    }

    public int getLatitud() {
        return latitud;
    }

    public int getAltitud() {
        return altitud;
    }

    public String getContraseña() {
        return contraseña;
    }
}

