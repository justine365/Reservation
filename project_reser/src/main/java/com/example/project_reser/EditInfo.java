package com.example.project_reser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditInfo extends AppCompatActivity implements View.OnClickListener {
    Button Tofin;
    EditText Name;
    EditText Phone;
    EditText Resident;
    EditText Center_name;
    EditText Center_address;
    EditText Vaccine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        Name=findViewById(R.id.name_f);
        Phone=findViewById(R.id.phone_f);
        Resident=findViewById(R.id.resident_number_f);
        Center_name=findViewById(R.id.medical_center_name_f);
        Center_address=findViewById(R.id.center_address_f);
        Vaccine=findViewById(R.id.vaccine_f);
        Tofin=findViewById(R.id.next_f);

        SharedPreferences sharedPref = getSharedPreferences("personal_info_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  sharedPref.edit();
        String getname = sharedPref.getString("phonedata","");
        String getphone = sharedPref.getString("phonedata","");

    }

    @Override
    public void onClick(View v) {
        Intent next = new Intent(this,Personal_info_classify.class);
        startActivity(next);
    }
}