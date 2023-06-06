package com.example.m213_tp_16_sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    TextView txt_nom, txt_prenom;

    Spinner sp;

    String villes[] = {"Casa","Fes","Bejaad","Tanger","Merrakech"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String n = sh.getString("nom", "");
        String p = sh.getString("prenom", "");
        int selected = sh.getInt("sel_ville",0);

        txt_nom = findViewById(R.id.textView);
        txt_prenom = findViewById(R.id.textView2);

        sp= findViewById(R.id.spinner);

        txt_nom.setText(n);
        txt_prenom.setText(p);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, villes);
        sp.setAdapter(spinnerArrayAdapter);

        sp.setSelection(selected);



        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                SharedPreferences.Editor myEdit = sh.edit();

                myEdit.putInt("sel_ville", position);

                myEdit.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),Third.class));
            }
        });

    }
}