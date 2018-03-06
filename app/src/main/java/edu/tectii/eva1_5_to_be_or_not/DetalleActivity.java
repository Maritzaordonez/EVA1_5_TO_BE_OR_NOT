package edu.tectii.eva1_5_to_be_or_not;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {
    int iIndex;
    DetalleFragment dfFragDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Intent inDatos = getIntent();
        Bundle  bDato = inDatos.getExtras();
        iIndex =bDato.getInt("INDEX", 0);
        dfFragDetalle.onMsgFromMain(iIndex);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
       dfFragDetalle = (DetalleFragment)fragment;
        //dfFragDetalle.onMsgFromMAin(iIndex);
    }
}

