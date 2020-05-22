package com.example.testwallah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testwallah.AddDialog;

public class FavorisActivity extends AppCompatActivity implements AddDialog.ExampleDialogListener {
    public static final String SHARED_PREFS = "sharedPrefs";
    Favoris favoris;
    SharedPreferences sharedPreferences ;
    Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);

        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);

        this.sharedPreferences=sharedPreferences;

        home=findViewById(R.id.home_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHome();
            }
        });

        final Button[] buttonsFav = {findViewById(R.id.fav0),findViewById(R.id.fav1),
                findViewById(R.id.fav2),findViewById(R.id.fav3),findViewById(R.id.fav4),
                findViewById(R.id.fav5),findViewById(R.id.fav6),findViewById(R.id.fav7),
                findViewById(R.id.fav8)};

        final Button[] buttonDel={findViewById(R.id.del0),findViewById(R.id.del1),
                findViewById(R.id.del2),findViewById(R.id.del3),findViewById(R.id.del4),
                findViewById(R.id.del5),findViewById(R.id.del6),findViewById(R.id.del7),
                findViewById(R.id.del8)};

        final Button butttonAdd = findViewById(R.id.addBut);

        final Favoris favoris = new Favoris(buttonsFav,buttonDel);
        this.favoris=favoris;
        favoris.setSharedPreferences(sharedPreferences);
        favoris.setContext(FavorisActivity.this);
        favoris.setFragmentManager(getSupportFragmentManager());
        //this.favoris.save(sharedPreferences);
        this.favoris.load();
        this.favoris.refreshDisplay();
        //region listens
        //DEL
        for (int i=0; i<favoris.getLen();i++){
            final int j = i;
            buttonDel[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    favoris.delPressed(j);
                    favoris.refreshDisplay();
                    favoris.save();
                }
            });
            //FAV
            buttonsFav[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        lanceAffiche(j);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });

            //ADD
            butttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    favoris.addPressed();

                }
            });

        }

        //endregion listeners
        //favoris.save(sharedPreferences);
        favoris.load();

    }

    public void gotoHome(){
        startActivity(new Intent(this,MainActivity.class));
    }


    @Override
    public void applyTexts(String nom, String url) {

    }

    public void lanceAffiche(int j){
        affiche.url=favoris.getURL(j);
        System.out.println(affiche.url);
        startActivity(new Intent(this,affiche.class));
        affiche.numérosemaine=0;
    }
}
