package com.example.testwallah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MIQ2 extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.miq2);

    }

    public void MIQ2GR1(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ2/MIQ2-Gr1/semaine_0";
        startActivity(new Intent(this, affiche.class));
        affiche.numérosemaine=0;
    }

    public void MIQ1GR2(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ2/MIQ2-Gr2/semaine_0";
        startActivity(new Intent(this, affiche.class));
        affiche.numérosemaine=0;
    }
}
