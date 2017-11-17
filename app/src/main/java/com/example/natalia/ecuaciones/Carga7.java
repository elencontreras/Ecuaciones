package com.example.natalia.ecuaciones;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Carga7 extends AppCompatActivity {
    private EditText txtBase, txtAltura, txtLongitud, txtMomento;
    private TextView txtResultado;
    private Spinner cmbMaterial;
    private Resources res;
    private String opc[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga7);
        res= this.getResources();
        txtBase=(EditText) findViewById(R.id.txtBase7);
        txtAltura=(EditText) findViewById(R.id.txtAltura7);
        txtLongitud=(EditText) findViewById(R.id.txtLongitud7);
        cmbMaterial=(Spinner)findViewById(R.id.cmbMaterial7);
        txtResultado=(TextView)findViewById(R.id.txtResultado7);
        txtMomento=(EditText)findViewById(R.id.txtMomento7);

        opc=res.getStringArray(R.array.opc_material);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opc);
        cmbMaterial.setAdapter(adapter);
    }

    public void calcularCarga7(View v) {
        Double base, altura, longitud, inercia, momento;
        int material, young = 0;

        if (validar()) {
            base = Double.parseDouble(txtBase.getText().toString());
            altura = Double.parseDouble(txtAltura.getText().toString());
            longitud = Double.parseDouble(txtLongitud.getText().toString());
            momento = Double.parseDouble(txtMomento.getText().toString());
            material = cmbMaterial.getSelectedItemPosition();

            if (material == 0) {
                young = 210000 * 1000;
            } else if (material == 1) {
                young = 14000 * 1000;
            } else if (material == 2) {
                young = 300000 * 100;
            }

            inercia = (1 / 12.0) * base * Math.pow(altura, 3);
            double num = momento * Math.pow(longitud, 2);
            double den = 9 * Math.sqrt(3) * young * inercia;
            double deflexion = (num / den);

            txtResultado.setText("" + String.format("%.3f", deflexion));
        }
    }

    private boolean validar() {

        if (txtBase.getText().toString().isEmpty()) {
            txtBase.setError(res.getString(R.string.error1));
            return false;

        }
        if (txtAltura.getText().toString().isEmpty()) {
            txtAltura.setError(res.getString(R.string.error1));
            return false;

        }
        if (txtLongitud.getText().toString().isEmpty()) {
            txtLongitud.setError(res.getString(R.string.error1));
            return false;

        }
        if (txtMomento.getText().toString().isEmpty()) {
            txtMomento.setError(res.getString(R.string.error1));
            return false;

        }
        return true;
    }
}
