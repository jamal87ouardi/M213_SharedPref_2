package com.example.m213_tp_16_sharedpref;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Third extends AppCompatActivity {

    String[] themes = {"light","dark"};

    Spinner sp;

    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        int sel_theme = sh.getInt("sel_theme",0);

        cl = findViewById(R.id.cl);

        sp = findViewById(R.id.spinner2);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, themes);
        sp.setAdapter(spinnerArrayAdapter);
        sp.setSelection(sel_theme);

        if(sel_theme==0) cl.setBackgroundColor(getResources().getColor(R.color.white));
        else cl.setBackgroundColor(getResources().getColor(R.color.dark));

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                SharedPreferences.Editor myEdit = sh.edit();

                myEdit.putInt("sel_theme", position);

                myEdit.apply();

                switch(position) {
                    case 0:
                        cl.setBackgroundColor(getResources().getColor(R.color.white));
                        break;
                    case 1:
                        cl.setBackgroundColor(getResources().getColor(R.color.dark));
                        break;


                    default:
                        // code block
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });
    }
}