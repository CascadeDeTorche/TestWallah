package com.example.testwallah;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.chrisbanes.photoview.PhotoView;


public class affiche extends AppCompatActivity {
    public static String url;
    public static int numérosemaine;
    private static final int MAX_SEMAINE = 2;
    private Context context = affiche.this;
    ImageView imageView;

    protected void onCreate(Bundle savedInstanceState) {
        String urllocal = this.url.substring(0, this.url.length() - 1);
        this.url = urllocal + this.numérosemaine;
        System.out.println(this.url);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affiche);
        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);

        new DownloadImageTask((PhotoView) findViewById(R.id.photo_view)).execute(this.url);
    }


    public void Semaineplus(View view) {
        numérosemaine = numérosemaine + 1;
        if (this.numérosemaine == MAX_SEMAINE+1) {
            numérosemaine=2;
            dialog("Semaine max atteinte","Vous ne pouvez pas naviguer plus loin dans l'edt");
            return;
        }
        else{
            startActivity(new Intent(this, affiche.class));

        }

    }

    public void Semainemoins(View view) {
        numérosemaine = numérosemaine - 1;
        if (this.numérosemaine < 0) {
            dialog("Semaine min atteinte","Vous ne pouvez pas naviguer plus loin dans l'edt");
            this.numérosemaine = 0;
        } else {
            startActivity(new Intent(this, affiche.class));
        }
    }

    public void dialog(String title, String text) {
        new AlertDialog.Builder(this.context)
                .setTitle(title)
                .setMessage(text)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).show();
    }

}
