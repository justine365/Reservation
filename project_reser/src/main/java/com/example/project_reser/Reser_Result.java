package com.example.project_reser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reser_Result extends AppCompatActivity implements View.OnClickListener{

    Button Edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_result);
        Edit = findViewById(R.id.edit);
        Edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent ed = new Intent(this,EditInfo.class);
        startActivity(ed);
    }
}