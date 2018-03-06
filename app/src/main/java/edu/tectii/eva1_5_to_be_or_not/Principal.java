package edu.tectii.eva1_5_to_be_or_not;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Principal extends AppCompatActivity {
    Boolean bDual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        View vDetail = findViewById(R.id.frameDetail);

        /*  verificamos en onCreate si la vista está en modo landscape,
            y si lo está añadimos el fragmento evitando que esté sea nulo
        */
        bDual = vDetail != null && vDetail.getVisibility() == View.VISIBLE;
        if(bDual){//Landscape
            DetalleFragment DetalleFragment = (DetalleFragment)getSupportFragmentManager().findFragmentById(R.id.frameDetail);
            if(DetalleFragment == null) {
                DetalleFragment = new DetalleFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frameDetail,DetalleFragment);
                transaction.commit();
            }

        }

    }

    public void onMsgFromFragToMain(String sender, int Msg){
        if(sender.equals("TITLE")){//Fragment List
            View vDetail = findViewById(R.id.frameDetail);
            bDual = vDetail != null && vDetail.getVisibility() == View.VISIBLE;
            if(bDual){//Landscape
                DetalleFragment fragmentDetail = (DetalleFragment)getSupportFragmentManager().findFragmentById(R.id.frameDetail);
                if(fragmentDetail == null) {
                    fragmentDetail= new DetalleFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.add(R.id.frameDetail,fragmentDetail);
                    transaction.commit();
                }
                fragmentDetail.onMsgFromMain(Msg);

            }else{//Portrait
                Intent intent = new Intent(this, DetalleActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("INDEX", Msg);
                intent.putExtras(bundle);
                startActivity(intent);

            }

        }else{//Fragment With Detail

        }
    }
}
