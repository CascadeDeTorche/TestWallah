package com.example.testwallah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button boutonFav;
    Button boutonParcourir;
    Button boutonHome;
    Button boutonAPropos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutonFav=findViewById(R.id.bouton_favoris);
        boutonParcourir =findViewById(R.id.bouton_parcourir_edt);
        boutonHome=findViewById(R.id.bouton_Home);
        boutonAPropos=findViewById(R.id.button_a_propos);

        boutonFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lancerFavoris();
            }
        });

        boutonParcourir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parcourir();

            }
        });

        boutonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });

        boutonAPropos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lancerAPropos();
            }
        });

    }

    void lancerFavoris(){
        startActivity(new Intent(this, com.example.testwallah.FavorisActivity.class));
    }

    void lancerAPropos(){
        startActivity(new Intent(this, com.example.testwallah.AproposActivity.class));
    }

    void home(){
        startActivity(new Intent(this,MainActivity.class));
    }

    void parcourir(){
        startActivity(new Intent(this,parcourir.class));

    }
}
