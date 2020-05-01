package com.example.testwallah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MIQ  extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.miq);

    }

    public void MIQ2(View view) {
        startActivity(new Intent(this, MIQ2.class));
    }

    public void MIQ3(View view) {
        startActivity(new Intent(this, MIQ3.class));
    }

    public void MIQ4(View view) {
        startActivity(new Intent(this, MIQ4.class));
    }
}
