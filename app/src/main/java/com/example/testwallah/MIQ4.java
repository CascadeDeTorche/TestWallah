package com.example.testwallah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MIQ4 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.miq4);

    }

    public void MIQ4GR1(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ4/MIQ4-Gr1/semaine_0";
        startActivity(new Intent(this, affiche.class));
    }

    public void MIQ4GR2(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ4/MIQ4-Gr2/semaine_0";
        startActivity(new Intent(this, affiche.class));
    }

    public void MIQ4P1(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ4/MIQ4-P1/semaine_0";
        startActivity(new Intent(this, affiche.class));
    }
    int v=4;
    public void MIQ4P2GR1(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ4/MIQ4-P2-TP-Gr1/semaine_0";
        startActivity(new Intent(this, affiche.class));
    }
}
