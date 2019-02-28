package com.example.cep.proj2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ESTA ES LA RAMA DE ARANTXA
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();


			inflater.inflate(R.menu.menu, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override

	// Creamos otro boolean con las opciones del menu.
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean devolver;


			switch (item.getItemId()) {
				case R.id.LoginToolbar:
					Intent menu=new Intent(MainActivity.this,Login.class);
					startActivityForResult(menu,0);
					devolver=true;
					break;

				default:
					devolver=super.onOptionsItemSelected(item);
					break;

			}
			return devolver;
		}



}

