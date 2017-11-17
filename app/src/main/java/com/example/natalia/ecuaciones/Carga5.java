package com.example.natalia.ecuaciones;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.zip.DeflaterOutputStream;

public class Carga5 extends AppCompatActivity {
    private EditText txtBase, txtAltura, txtLongitud, txtCarga, txta, txtb;
    private TextView txtResultado;
    private Spinner cmbMaterial;
    private Resources res;
    private String opc[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga5);
        res = this.getResources();
        txtBase = (EditText) findViewById(R.id.txtBase5);
        txtAltura = (EditText) findViewById(R.id.txtAltura5);
        txtLongitud = (EditText) findViewById(R.id.txtLongitud5);
        txtCarga = (EditText) findViewById(R.id.txtCarga5);
        cmbMaterial = (Spinner) findViewById(R.id.cmbMaterial5);
        txtResultado = (TextView) findViewById(R.id.txtResultado5);
        txta = (EditText) findViewById(R.id.txta);
        txtb = (EditText) findViewById(R.id.txtb);

        opc = res.getStringArray(R.array.opc_material);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opc);
        cmbMaterial.setAdapter(adapter);
    }

    public void calcularCarga1(View v) {
        Double base, altura, longitud, carga, inercia, a, b, num, den, deflexion;
        int material, young=0;

        if (validar()) {
            base = Double.parseDouble(txtBase.getText().toString());
            altura = Double.parseDouble(txtAltura.getText().toString());
            longitud = Double.parseDouble(txtLongitud.getText().toString());
            carga = Double.parseDouble(txtCarga.getText().toString());
            material = cmbMaterial.getSelectedItemPosition();
            a = Double.parseDouble(txta.getText().toString());
            b = Double.parseDouble(txtb.getText().toString());

            if (material == 0) {
                young = 210000 * 1000;
            } else if (material == 1) {
                young = 14000 * 1000;
            } else if (material == 2) {
                young = 300000*100;
            }

            inercia = (1 / 12.0)*base*Math.pow(altura,3);

            if (a > b) {
                num = carga * b * Math.pow((Math.pow(longitud, 2) - Math.pow(b, 2)), 3 / 2);
                den = 9 * Math.sqrt(3) * young * inercia * longitud;
                deflexion = -(num / den);
            } else {
                num = Math.pow(longitud, 2) - Math.pow(b, 2);
                den = 3.0;
                deflexion = Math.sqrt(num / den);
            }

            txtResultado.setText("" + String.format("%.3f", deflexion));
        }
    }

    private boolean validar() {
        if (txta.getText().toString().isEmpty()) {
            txta.setError(res.getString(R.string.error1));
            return false;

        }
        if (txtb.getText().toString().isEmpty()) {
            txtb.setError(res.getString(R.string.error1));
            return false;
        }
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

