package com.example.project_reser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Medical_center extends AppCompatActivity implements View.OnClickListener{

    private String API_KEY="S3JAidrdNoyZufh0wx8wwiDbDXY8IjFr7i5FX6QwdOkGTbZij89rBh1zG35HW9qhlWnmP6NahnOQ11zwEqycZA==";
    Button Map_View;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;
    public ArrayList<String> Address = new ArrayList<>();
    public ArrayList<String> PhoneNumber = new ArrayList<>();

    Spinner spinnerSido;
    Spinner spinnerSigungu;
    Spinner spinnerCentername;

    Example oriData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical_center);
        Map_View = findViewById(R.id.mapview);
        Map_View.setOnClickListener(this);
        spinnerSido=findViewById(R.id.spinnersido);
        spinnerSigungu=findViewById(R.id.spinnersigungu);
        spinnerCentername=findViewById(R.id.center_name);


        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        retrofitInterface.getExample(1,15,API_KEY).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example center_result = response.body();
                oriData = center_result;

                for (int i=0;i<center_result.getData().size();i++){
                    Log.d("shjang3", "Data ==" + center_result.getData().get(i).getAddress());
                }


                spinnerSido(center_result.getData());
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.d("retrofit", t.getMessage());
            }
        });


    }
    @Override
    public void onClick(View v) {
        Intent mv = new Intent(this,Map.class);
        startActivity(mv);

    }

    public void spinnerSido(List<Datum> list){

        String[] strings_sido = new String[list.size()];

        //String[] strings_sigungu_copy;
        //String[] strings_org = new String[list.size()];

        //중복 제거 작업
        for(int i=0;i<=strings_sido.length-1;i++)
        {
            for(int j=0;j<=strings_sido.length-1;j++)
            {

            }
            strings_sido[i]=list.get(i).getSido();
        }


        ArrayAdapter<String> aa= new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,strings_sido);
        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerSido.setAdapter(aa);
        spinnerSido.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //    Toast.makeText(getApplicationContext() , ""+spinnerSido.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            // for

                ArrayList<String> arrayList = new ArrayList<>();

                for(int i=0;i<=strings_sido.length-1;i++)
                {
                    if(spinnerSido.getSelectedItem().toString().equals(strings_sido[i]))
                    {
                        arrayList.add(list.get(i).getSigungu());
                    }
                }
                String[] strings_sigungu = new String[arrayList.size()];

                for(int i=0;i<arrayList.size();i++)
                {
                        strings_sigungu[i]=arrayList.get(i);
                }

                //Toast.makeText(getApplicationContext() , ""+strings_sigungu.length,Toast.LENGTH_SHORT).show();

                ArrayAdapter<String> bb= new ArrayAdapter<String>(Medical_center.this,
                        android.R.layout.simple_dropdown_item_1line,strings_sigungu);
                bb.setDropDownViewResource(
                        android.R.layout.simple_spinner_dropdown_item);
                spinnerSigungu.setAdapter(bb);

                spinnerSigungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        ArrayList<String> arrayList = new ArrayList<>();

                        for(int i=0;i<strings_sigungu.length;i++)
                        {
                            if(spinnerSigungu.getSelectedItem().toString().equals(strings_sigungu[i]))
                            {
                                arrayList.add(list.get(i).getCenterName());
                                Address.add(list.get(i).getAddress());
                                PhoneNumber.add(list.get(i).getAddress());
                            }
                        }
                        String[] strings_centername = new String[arrayList.size()];

                        for(int i=0;i<arrayList.size();i++)
                        {
                            strings_centername[i]=arrayList.get(i);
                        }
                        ArrayAdapter<String> cc= new ArrayAdapter<String>(Medical_center.this,
                                android.R.layout.simple_dropdown_item_1line,strings_centername);
                        cc.setDropDownViewResource(
                                android.R.layout.simple_spinner_dropdown_item);
                        spinnerCentername.setAdapter(cc);

                    }


                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}