package com.example.natalia.ecuaciones;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Principal extends AppCompatActivity {
    private ListView listaOpciones;
    private Resources res;
    private String[] opc;
    private Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


    }

    public void empezar(View v){
        i= new Intent(Principal.this, ListadoConfiguracionCarga.class);
        startActivity(i);
    }
}

