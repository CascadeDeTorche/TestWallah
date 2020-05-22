package com.example.testwallah;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import java.util.Arrays;

public class Favoris {
    public static final String FAVORI = "favori";
    public static final String FAVORI_URL = "favoriURL";
    private static final int len = 9;
    private SharedPreferences sharedPreferences;
    private Context context;
    private FragmentManager fragmentManager;
    private String[] favorisNom = new String[len];
    private String[] favorisURL = new String[len];
    private Button[] buttonsFav = new Button[len];
    private  Button[] buttonDel =new Button[len];

    public Favoris(Button[] buttonsFav,Button[] buttonsDel) {
        Arrays.fill(favorisNom, "");
        Arrays.fill(favorisURL,"");
        this.buttonDel=buttonsDel;
        this.buttonsFav=buttonsFav;
    }

    public void refreshDisplay(){
        for(int i = 0;i<len;i++){
            if(favorisNom[i].equals("")){
                buttonsFav[i].setVisibility(View.INVISIBLE);
                buttonsFav[i].setClickable(false);
                buttonDel[i].setVisibility(View.INVISIBLE);
                buttonDel[i].setClickable(false);
            }
            else{
                buttonsFav[i].setVisibility(View.VISIBLE);
                buttonsFav[i].setText(favorisNom[i]);
                buttonsFav[i].setClickable(true);
                buttonDel[i].setVisibility(View.VISIBLE);
                buttonDel[i].setClickable(true);
            }
        }
    }



    public void load() {
        for (int i = 0; i < len; i++) {
            String keyNom = FAVORI+ i;
            String keyUrl= FAVORI_URL+ i;
            this.favorisNom[i]=sharedPreferences.getString(keyNom,"");
            this.favorisURL[i]= sharedPreferences.getString(keyUrl,"");
        }
        this.refreshDisplay();
    }

    public void save() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i < len; i++) {
            String keyNom = FAVORI+Integer.toString(i);
            String keyUrl= FAVORI_URL+Integer.toString(i);
            editor.putString(keyNom, favorisNom[i]);
            editor.putString(keyUrl, favorisURL[i]);
        }
        editor.apply();
    }

    public int count(){
        int i= 0;
        while (!favorisNom[i].equals("")){
            i=i+1;
            if (i==len){
                return len;
            }
        }
        return i;
    }
    public void addFavori(String nom,String url){
        int i = this.count();
        System.out.println("on a tant de favoris :"+i);
        if (!(i==len)){
            favorisNom[i]=nom;
            favorisURL[i]=url;
        }
        else {
            maxAtteintDialog();
        }

    }

    public void setFavori(int pos,String nom,String url){
        favorisNom[pos]=nom;
        favorisURL[pos]=url;
    }

    public void delFavori(int i){
        System.out.println("Favoris supprime :" +i);
        for (int k = i ; k<this.len-1;k++){
            if (k==7)
                System.out.println(favorisNom[k]+","+favorisNom[k+1]);
            favorisNom[k]=new String(favorisNom[k+1]);
            favorisURL[k]=new String(favorisURL[k+1]);
        }
        favorisNom[len-1]="";
        favorisURL[len-1]="";
        this.refreshDisplay();
        this.save();
    }

    public String getURL(int i){
      return favorisURL[i];
    }

    public void delPressed(int i){
        final int j =i;
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        delFavori(j);
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Voulez vous vraiment supprimer "+ this.favorisNom[j]+" ?").setPositiveButton("Oui", dialogClickListener)
                .setNegativeButton("Non", dialogClickListener).show();
    }

    public void maxAtteintDialog(){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Nombre maximal de favoris atteint").setPositiveButton("Ok", dialogClickListener).show();
    }

    public void addPressed(){

            //System.out.println("Nouveau");
            AddDialog addDialog = new AddDialog(Favoris.this,context);
            addDialog.show(fragmentManager,"testDialog");

    }


    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public int getLen(){
        return len;
    }
}


