package com.example.project_reser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Reser_Result extends AppCompatActivity implements View.OnClickListener {

    TextView Name;
    TextView Phone;
    TextView Resident;
    TextView Center_name;
    TextView Center_address;
    TextView Vaccine;

    Button Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_result);
        Edit = findViewById(R.id.edit);
        Edit.setOnClickListener(this);
        Name = findViewById(R.id.name_result);
        Phone = findViewById(R.id.phone_result);
        Resident = findViewById(R.id.resident_number_result);
        Center_name = findViewById(R.id.center_name_result);
        Center_address = findViewById(R.id.center_address_result);
        Vaccine = findViewById(R.id.anti_virus_info_result);


        SharedPreferences sharedPreferences = getSharedPreferences("final", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sharedPreferences.edit();
        Name.setText(sharedPreferences.getString("name", ""));
        Phone.setText(sharedPreferences.getString("phone", ""));
        Resident.setText(sharedPreferences.getString("resident", ""));
        Center_name.setText(sharedPreferences.getString("centername", ""));
        Center_address.setText(sharedPreferences.getString("centeraddress", ""));
        Vaccine.setText(sharedPreferences.getString("vaccine", ""));

    }

    @Override
    public void onClick(View v) {
        Intent ed = new Intent(this, Finalpage.class);
        startActivity(ed);
    }
}