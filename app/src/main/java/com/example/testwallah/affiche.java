package com.example.testwallah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoView;


public class affiche  extends AppCompatActivity {
    public static String url;
    public static int numérosemaine;

    ImageView imageView;
    protected void onCreate(Bundle savedInstanceState) {
        String urllocal = this.url.substring(0, this.url.length()-1);
        this.url=urllocal+this.numérosemaine;
        System.out.println(this.url);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affiche);
        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);

        new DownloadImageTask((PhotoView) findViewById(R.id.photo_view)).execute(this.url);
    }


    public void Semaineplus(View view) {
        numérosemaine=numérosemaine+1;
        if(this.numérosemaine>=2)
        {
            this.numérosemaine=2;
        }
        startActivity(new Intent(this, affiche.class));

    }

    public void Semainemoins(View view) {
        numérosemaine=numérosemaine-1;
        if(this.numérosemaine<=0)
        {
            this.numérosemaine=0;
        }
        startActivity(new Intent(this, affiche.class));
    }
}
