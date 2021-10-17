package com.example.project_reser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Reser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Reser = findViewById(R.id.reservation);

        Reser.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent reser = new Intent(this, Personal_info.class);
        startActivity(reser);
    }
}


