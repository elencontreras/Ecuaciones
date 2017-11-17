package com.example.natalia.ecuaciones;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Carga6 extends AppCompatActivity {
    private EditText txtBase, txtAltura, txtLongitud, txtCarga;
    private TextView txtResultado;
    private Spinner cmbMaterial;
    private Resources res;
    private String opc[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga6);
        res = this.getResources();
        txtBase = (EditText) findViewById(R.id.txtBase6);
        txtAltura = (EditText) findViewById(R.id.txtAltura6);
        txtLongitud = (EditText) findViewById(R.id.txtLongitud6);
        txtCarga = (EditText) findViewById(R.id.txtCarga6);
        cmbMaterial = (Spinner) findViewById(R.id.cmbMaterial6);
        txtResultado = (TextView) findViewById(R.id.txtResultado6);

        opc = res.getStringArray(R.array.opc_material);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opc);
        cmbMaterial.setAdapter(adapter);
    }

    public void calcularCarga6(View v) {
        Double base, altura, longitud, carga, inercia;
        int material, young = 0;

        if (validar()){
        base = Double.parseDouble(txtBase.getText().toString());
        altura = Double.parseDouble(txtAltura.getText().toString());
        longitud = Double.parseDouble(txtLongitud.getText().toString());
        carga = Double.parseDouble(txtCarga.getText().toString());
        material = cmbMaterial.getSelectedItemPosition();

        if (material == 0) {
            young = 210000 * 1000;
        } else if (material == 1) {
            young = 14000 * 1000;
        } else if (material == 2) {
            young = 300000 * 100;
        }

        inercia = (1 / 12.0) * base * Math.pow(altura, 3);
        double num = 5 * carga * Math.pow(longitud, 4);
        double den = 384 * young * inercia;
        double deflexion = -(num / den);

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
        if (txtCarga.getText().toString().isEmpty()) {
            txtCarga.setError(res.getString(R.string.error1));
            return false;

        }
        return true;
    }
}
