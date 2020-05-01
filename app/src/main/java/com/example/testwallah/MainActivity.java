package com.example.testwallah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}



public class MainActivity extends AppCompatActivity {

    public String url;
    Button button;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        url="null";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        refreshPic();



    }

    public void rechercher(View view)
    {
        startActivity(new Intent(this,Recherche.class));
    }
    private void refreshUrl() {
        affiche.url="https://dakaryon.pythonanywhere.com/Stagiaires/MIQ3/MIQ3-Gr2/semaine_0";
    }
    public void Miq(View view)
    {
        startActivity(new Intent(this,MIQ.class));
    }


    private void refreshPic(){
        if (this.url.contains("http")){

            new DownloadImageTask((ImageView) findViewById(R.id.imageView)).execute(url);
        }
        else{
            this.imageView.setImageResource(R.drawable.logo);
        }
    }
}
