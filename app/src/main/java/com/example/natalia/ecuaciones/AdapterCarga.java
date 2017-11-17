package com.example.natalia.ecuaciones;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ACER-PC on 10/11/2017.
 */

public class AdapterCarga extends BaseAdapter {

    private Context contexto;
    private int[] imagenes;


    public AdapterCarga(Context contexto, int[] imagenes) {
        this.contexto = contexto;
        this.imagenes = imagenes;

    }

    @Override
    public int getCount() {
       return imagenes.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        // Declare Variables

        ImageView imagen;
        LayoutInflater inflater;
        View itemView;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        itemView = inflater.inflate(R.layout.item_carga,null);

        // Locate the TextViews in listview_item.xml
        
        imagen = (ImageView) itemView.findViewById(R.id.imgFoto);

        // Capture position and set to the TextViews

        imagen.setImageResource(imagenes[position]);

        return itemView;
    }
}
