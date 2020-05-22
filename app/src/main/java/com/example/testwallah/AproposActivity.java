package com.example.testwallah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AproposActivity extends AppCompatActivity {
    Button home;
    Button ext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apropos);
        home=findViewById(R.id.bouton_Home);
        ext=findViewById(R.id.buttonExt);
        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebURL("https://bit.ly/2W5kWdn");
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotohome();
            }
        });
    }
    void gotohome(){
        startActivity(new Intent(this,MainActivity.class));
    }

    public void openWebURL( String inURL ) {
        Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );

        startActivity( browse );
    }
}
