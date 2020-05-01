package com.example.testwallah;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class affiche  extends AppCompatActivity {
    public static String url;

    ImageView imageView;
    protected void onCreate(Bundle savedInstanceState) {
        imageView = findViewById(R.id.imageView2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affiche);
        new DownloadImageTask((ImageView) findViewById(R.id.imageView2)).execute(this.url);
    }

}
