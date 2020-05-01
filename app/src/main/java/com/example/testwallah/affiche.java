package com.example.testwallah;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoView;


public class affiche  extends AppCompatActivity {
    public static String url;

    ImageView imageView;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.affiche);
        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);

        new DownloadImageTask((PhotoView) findViewById(R.id.photo_view)).execute(this.url);
    }

}
