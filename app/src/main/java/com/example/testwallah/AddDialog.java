package com.example.testwallah;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class AddDialog extends AppCompatDialogFragment {
    private EditText editTextNom;
    private EditText editTextUrl;
    private ExampleDialogListener listener;
    private com.example.testwallah.Favoris favoris;
    private Context context;
    public AddDialog(com.example.testwallah.Favoris favoris, Context context){
        this.favoris=favoris;
        this.context=context;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Ajouter un favori")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String nom = editTextNom.getText().toString();
                        String url = editTextUrl.getText().toString();
                        favoris.addFavori(nom,url);
                        favoris.refreshDisplay();
                        favoris.save();
                        listener.applyTexts(nom, url);
                    }
                });

        editTextNom = view.findViewById(R.id.edit_nom);
        editTextUrl = view.findViewById(R.id.edit_url);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public ExampleDialogListener getListener(){
        return this.listener;
    }

    public interface ExampleDialogListener {
        void applyTexts(String nom, String url);
    }
}
