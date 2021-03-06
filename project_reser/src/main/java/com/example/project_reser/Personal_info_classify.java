package com.example.project_reser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Personal_info_classify extends AppCompatActivity implements View.OnClickListener {

    Button Next_2;
    RadioButton Pfizer;
    RadioButton Moderna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_information_2);
        Pfizer = findViewById(R.id.pfizer);
        Moderna = findViewById(R.id.moderna);
        Next_2 = findViewById(R.id.next_2);
        Next_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences sharedPrefer = getSharedPreferences("anti_virus_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedPrefer.edit();
        int flag1 = 0;


        if (Pfizer.isChecked()) {
            editor2.putString("data", "Prifizer");
            editor2.commit();
            flag1 = 1;

        } else if (Moderna.isChecked()) {
            editor2.putString("data", "Moderna");
            editor2.commit();
            flag1 = 1;
        } else {
            Toast.makeText(getApplicationContext(), "백신을 선택해주세요", Toast.LENGTH_SHORT).show();
        }

        if (flag1 == 1) {
            Intent next_ = new Intent(this, Medical_center.class);
            startActivity(next_);
        }

    }
}