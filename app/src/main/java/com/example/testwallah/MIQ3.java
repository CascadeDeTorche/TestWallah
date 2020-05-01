package com.example.testwallah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MIQ3 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.miq3);

    }

    public void MIQ3GR1(View view) {

        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ3/MIQ3-Gr1/semaine_0";
        startActivity(new Intent(this, affiche.class));
    }

    public void MIQ3GR2(View view) {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ3/MIQ3-Gr1/semaine_0";
        startActivity(new Intent(this, affiche.class));
    }
}
