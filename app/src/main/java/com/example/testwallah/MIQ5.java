package com.example.testwallah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MIQ5 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.miq5);

    }

    public void MIQ5P1GR1(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ5/MIQ5-P1-Gr1/semaine_0";
        startActivity(new Intent(this, affiche.class));
        affiche.numérosemaine=0;
    }

    public void MIQ5P1GR2(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ5/MIQ5-P1-Gr2/semaine_0";
        startActivity(new Intent(this, affiche.class));
        affiche.numérosemaine=0;
    }

    public void MIQ5P2GR1(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ5/MIQ5-P2-Gr1/semaine_0";
        startActivity(new Intent(this, affiche.class));
        affiche.numérosemaine=0;
    }

    public void MIQ5P2GR2(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ5/MIQ5-P2-Gr2/semaine_0";
        startActivity(new Intent(this, affiche.class));
        affiche.numérosemaine=0;
    }

    public void MIQ5P3GR1(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ5/MIQ5-P3-Gr1/semaine_0";
        startActivity(new Intent(this, affiche.class));
        affiche.numérosemaine=0;
    }

    public void MIQ5P3GR2(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ5/MIQ5-P3-Gr2/semaine_0";
        startActivity(new Intent(this, affiche.class));
        affiche.numérosemaine=0;
    }

    public void MIQ5P4GR1(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ5/MIQ5-P4-Gr1/semaine_0";
        startActivity(new Intent(this, affiche.class));
        affiche.numérosemaine=0;
    }

    public void MIQ5P4GR2(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ5/MIQ5-P4-Gr2/semaine_0";
        startActivity(new Intent(this, affiche.class));
        affiche.numérosemaine=0;
    }
}
