package com.example.project_reser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Map extends AppCompatActivity implements View.OnClickListener{

    Button Finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Finish = findViewById(R.id.finish);
        Finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent f_ = new Intent(this,Reser_Result.class);
        startActivity(f_);
    }
}