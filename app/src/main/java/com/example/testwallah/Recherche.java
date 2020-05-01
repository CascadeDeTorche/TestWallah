package com.example.testwallah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Recherche  extends AppCompatActivity {
    public static String urllocal="https://dakaryon.pythonanywhere.com/Stagiaires/";
    protected void onCreate(Bundle savedInstanceState) {

        final EditText tonEdit = (EditText)findViewById(R.id.editText);
        Button bouton=(Button)findViewById(R.id.button3);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche);




    }

    public void test(View view) {
        EditText tonEdit = (EditText)findViewById(R.id.editText);

        String tonTexte = tonEdit.getText().toString();
        affiche.url=this.urllocal+tonTexte+"/semaine_0";
        startActivity(new Intent(this, affiche.class));
    }
}
