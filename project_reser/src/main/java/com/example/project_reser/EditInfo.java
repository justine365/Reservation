package com.example.project_reser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditInfo extends AppCompatActivity implements View.OnClickListener {
    Button Tofin;
    EditText Name;
    EditText Phone;
    EditText Resident;
    EditText Center_name;
    EditText Center_address;
    EditText Vaccine;
    EditText CenterPhoneNumber;
    Button Call;
    String getcenterphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        Name = findViewById(R.id.name_f);
        Phone = findViewById(R.id.phone_f);
        Resident = findViewById(R.id.resident_number_f);
        Center_name = findViewById(R.id.medical_center_name_f);
        Center_address = findViewById(R.id.center_address_f);
        Vaccine = findViewById(R.id.vaccine_f);
        CenterPhoneNumber = findViewById(R.id.medical_center_phone_f);
        Call = findViewById(R.id.call_f);
        Call.setOnClickListener(this);
        Tofin = findViewById(R.id.next_f);
        Tofin.setOnClickListener(this);

        SharedPreferences sharedPref = getSharedPreferences("personal_info_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        String getresident = sharedPref.getString("residentdata", "");
        String getname = sharedPref.getString("namedata", "");
        String getphone = sharedPref.getString("phonedata", "");
        String getcentername = sharedPref.getString("centername", "");
        String getsido = sharedPref.getString("sido", "");
        String getsigungu = sharedPref.getString("sigungu", "");
        getcenterphone = sharedPref.getString("centerphone", "");

        SharedPreferences sharedPrefer = getSharedPreferences("anti_virus_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedPrefer.edit();

        String getvaccine = sharedPrefer.getString("data", "");
        String address = getsido + " " + getsigungu;

        Name.setText(getname);
        Phone.setText(getphone);
        Resident.setText(getresident);
        Center_name.setText(getcentername);
        Center_address.setText(address);
        Vaccine.setText(getvaccine);
        CenterPhoneNumber.setText(getcenterphone);
    }

    @Override
    public void onClick(View v) {
        if (v == Tofin) {
            Intent next = new Intent(this, Reser_Result.class);
            startActivity(next);
            SharedPreferences sharedPreferences = getSharedPreferences("final", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor3 = sharedPreferences.edit();
            editor3.putString("name", Name.getText().toString());
            editor3.putString("phone", Phone.getText().toString());
            editor3.putString("resident", Resident.getText().toString());
            editor3.putString("centername", Center_name.getText().toString());
            editor3.putString("centeraddress", Center_address.getText().toString());
            editor3.putString("vaccine", Vaccine.getText().toString());
            editor3.commit();
        }
        if (v == Call) {
            Log.d("dokkk", getcenterphone);
            Toast.makeText(getApplicationContext(), "전화(앱)에 연결합니다", Toast.LENGTH_SHORT).show();
            Intent ff = new Intent(Intent.ACTION_DIAL, Uri.parse(getcenterphone));
            startActivity(ff);
        }
    }
}