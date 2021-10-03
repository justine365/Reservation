package com.example.project_reser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Personal_info extends AppCompatActivity implements View.OnClickListener{

    Button Next_1;
    EditText Name;
    EditText Phone;
    EditText Resident_Number;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_information_1);

        Next_1 = findViewById(R.id.next_1);
        Name=findViewById(R.id.name);
        Phone=findViewById(R.id.phone);
        Resident_Number=findViewById(R.id.resident_number);

        Next_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String phone = Phone.getText().toString();
        String name = Name.getText().toString();
        String residentnumber = Resident_Number.getText().toString();

        SharedPreferences sharedPref = getSharedPreferences("personal_info_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  sharedPref.edit();
        editor.putString("namedata",name);
        editor.putString("phonedata",phone);
        editor.putString("residentdata",residentnumber);
        editor.commit();



        Intent next = new Intent(this,Personal_info_classify.class);
        startActivity(next);
    }


}