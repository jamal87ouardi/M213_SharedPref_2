package com.example.m213_tp_16_sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText nom, prenom;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.ed_nom);
        prenom = findViewById(R.id.ed_prenom);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sp.edit();

                myEdit.putString("nom", nom.getText().toString());
                myEdit.putString("prenom", prenom.getText().toString());
                myEdit.apply();

                startActivity(new Intent(getApplicationContext(),Second.class));


            }
        });
    }
}