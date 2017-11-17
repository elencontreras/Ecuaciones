package com.example.natalia.ecuaciones;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class ListadoConfiguracionCarga extends AppCompatActivity {

   private int [] imagenes = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6, R.drawable.img7};
    private ListView lstCarga;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_configuracion_carga);

        lstCarga=(ListView)findViewById(R.id.lstCargas);
        AdapterCarga adapter=new AdapterCarga(this, imagenes);
        lstCarga.setAdapter(adapter);

        lstCarga.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        i=new Intent(ListadoConfiguracionCarga.this,Carga1.class);
                        startActivity(i);
                        break;
                    case 1:
                        i=new Intent(ListadoConfiguracionCarga.this,Carga2.class);
                        startActivity(i);
                        break;
                    case 2:
                        i=new Intent(ListadoConfiguracionCarga.this,Carga3.class);
                        startActivity(i);
                        break;
                    case 3:
                        i=new Intent(ListadoConfiguracionCarga.this,Carga4.class);
                        startActivity(i);
                        break;
                    case 4:
                        i=new Intent(ListadoConfiguracionCarga.this,Carga5.class);
                        startActivity(i);
                        break;
                    case 5:
                        i=new Intent(ListadoConfiguracionCarga.this,Carga6.class);
                        startActivity(i);
                        break;
                    case 6:
                        i=new Intent(ListadoConfiguracionCarga.this,Carga7.class);
                        startActivity(i);
                        break;
                }

            }
        });

    }
    }



