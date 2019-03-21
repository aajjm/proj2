package com.example.cep.proj2.Activities;

import android.net.ParseException;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cep.proj2.Clases.ClaseUsuario;
import com.example.cep.proj2.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Registro extends AppCompatActivity {
   /* private EditText nombre, direccion, NIF, correo,altitud,latitud, contraseña, repetir_contraseña;
    private Button btn_registro;
    private ProgressBar cargando;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        /*nombre = findViewById(R.id.nombre);
        direccion = findViewById(R.id.direccion);
        NIF = findViewById(R.id.NIF);
        correo = findViewById(R.id.Correo);
        altitud = findViewById(R.id.altitud);
        latitud = findViewById(R.id.latitud);
        contraseña = findViewById(R.id.contraseña);
        repetir_contraseña = findViewById(R.id.repcontraseña);

        cargando = findViewById(R.id.registroCargando);

        btn_registro = findViewById(R.id.registrar);
        final ArrayList<ClaseUsuario> usuarios = new ArrayList<ClaseUsuario>();
        /**
         * Evento que se inicia al hacer clic en el botón 'Registrarse'
         */
     /*   btn_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Hacemos visible la barra de carga circular y escondemos el botón.
                 */
              /*  cargando.setVisibility(View.VISIBLE);
                btn_registro.setVisibility(View.GONE);

                /**
                 * Si la contraseña y repetir contraseña y además todos los EditText
                 * no están vacíos pasamos a la siguiente condición.
                 */
               /* if (contraseña.getText().toString().equals(repetir_contraseña.getText().toString()) && !(nombre.getText().toString().isEmpty()
                        || direccion.getText().toString().isEmpty() || NIF.getText().toString().isEmpty()   || altitud.getText().toString().isEmpty()  || latitud.getText().toString().isEmpty()|| correo.getText().toString().isEmpty()
                        || contraseña.getText().toString().isEmpty()))
                {
                    /**
                     * Le pasamos el ArrayList de usuarios y el correo introducido por el usuario.
                     * Si no existe ese correo, creamos el usuario y lo introducimos en el archivo JSON.
                     */
                /*    if (!readJSON2(correo.getText().toString(), usuarios)) {
                        ArrayList<ClaseActivitats> activitats = new ArrayList<ClaseActivitats>();

                        ClaseUsuarioActividades usu3 = new ClaseUsuarioActividades(nombre.getText().toString(), Integer.parseInt(edad.getText().toString()),
                                Integer.parseInt(codigo_postal.getText().toString()), correo.getText().toString(), contraseña.getText().toString(), activitats, 0);
                        usuarios.add(usu3);

                        JSONArray jsonArray = new JSONArray();
                        JSONObject obj;

                        Iterator<ClaseUsuarioActividades> iteratorusuarios = usuarios.iterator();
                        while (iteratorusuarios.hasNext()) {
                            obj = new JSONObject();
                            ClaseUsuarioActividades user = iteratorusuarios.next();
                            obj.put("nombre", user.getNombre());
                            obj.put("edad", user.getEdad());
                            obj.put("codigopostal", user.getCodigopostal());
                            obj.put("correo", user.getCorreo());
                            obj.put("contraseña", user.getContraseña());
                            obj.put("actividades", user.getActividades());
                            obj.put("puntuacion", user.getPuntuacion());
                            jsonArray.add(obj);
                        }
                        try {
                            FileWriter file = new FileWriter(Environment.getExternalStorageDirectory() + "/JSON_files/usuarios.json");
                            file.write(jsonArray.toJSONString());
                            file.flush();

                        } catch (IOException e) {
                            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                        }
                        Intent myintent = new Intent(RegistrarUsuario.this, olorAlibroRegistrado.class);
                        myintent.putExtra("usuario",(usuarios.size()-1));
                        startActivityForResult(myintent, 0);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Ya hay una cuenta con este correo.", Toast.LENGTH_LONG).show();
                        cargando.setVisibility(View.GONE);
                        btn_registro.setVisibility(View.VISIBLE);
                        correo.setText("");
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Datos incorrectos.", Toast.LENGTH_LONG).show();
                    cargando.setVisibility(View.GONE);
                    btn_registro.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public boolean readJSON2(String correo_registrar,ArrayList<ClaseUsuario> usuarios2)
    {
        boolean encontrado = false;

        JSONParser parser = new JSONParser();

        try
        {

            Object obj = parser.parse(new FileReader(Environment.getExternalStorageDirectory() + "/JSON_files/usuarios.json"));

            JSONArray jsonArray = (JSONArray) obj;

            for (int i=0; i<jsonArray.size(); i++){

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                String nombre = (String) jsonObject.get("nombre");
                String direccion = (String) jsonObject.get("direccion");
                String NIF = (String) jsonObject.get("NIF");
                String correo = (String) jsonObject.get("correo");
                int latitud = (int) (long) jsonObject.get("latitud");
                int altitud = (int) (long) jsonObject.get("altitud");

                String contraseña = (String) jsonObject.get("contraseña");

                JSONArray jsonArrayA = (JSONArray)jsonObject.get("actividades");
                Iterator<String> iterator = jsonArrayA.iterator();


                ClaseUsuario usuario = new ClaseUsuario(nombre, direccion, NIF, correo,altitud,latitud, contraseña);
                usuarios2.add(usuario);
            }


        } catch (ParseException e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        } catch (IOException e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
        Iterator<ClaseUsuario> iteratorusuarios = usuarios2.iterator();
        while (iteratorusuarios.hasNext() && encontrado == false)
        {
            ClaseUsuario user = iteratorusuarios.next();

            if (user.getCorreo().equals(correo_registrar)) {
                encontrado = true;
            }

        }
        return encontrado;
    }

*/
}}
