package com.example.project_reser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
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

public class Medical_center extends AppCompatActivity implements View.OnClickListener {

    private String API_KEY = "S3JAidrdNoyZufh0wx8wwiDbDXY8IjFr7i5FX6QwdOkGTbZij89rBh1zG35HW9qhlWnmP6NahnOQ11zwEqycZA==";
    Button Map_View;
    Button Complete;
    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;
    String Lat;
    String Lng;
    String CenterPhone;


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
        Complete = findViewById(R.id.finish);
        Complete.setOnClickListener(this);
        spinnerSido = findViewById(R.id.spinnersido);
        spinnerSigungu = findViewById(R.id.spinnersigungu);
        spinnerCentername = findViewById(R.id.center_name);


        retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = RetrofitClient.getRetrofitInterface();

        retrofitInterface.getExample(1, 15, API_KEY).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example center_result = response.body();
                oriData = center_result;

                for (int i = 0; i < center_result.getData().size(); i++) {
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


        if (v == Complete) {
            spinnerSido.getSelectedItem().toString();
            //Toast.makeText(getApplicationContext(),spinnerSido.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();*/
            Intent aa = new Intent(this, EditInfo.class);
            startActivity(aa);
            SharedPreferences sharedPref = getSharedPreferences("personal_info_pref", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("centername", spinnerCentername.getSelectedItem().toString());
            editor.putString("sido", spinnerSido.getSelectedItem().toString());
            editor.putString("sigungu", spinnerSigungu.getSelectedItem().toString());
            editor.putString("centerphone", CenterPhone);
            editor.commit();
        }
        if (v == Map_View) {
            String sido = spinnerSido.getSelectedItem().toString();
            String sigungu = spinnerSigungu.getSelectedItem().toString();
            String Address = sido + "" + sigungu;
            Intent mv = new Intent(this, Map.class);
            mv.putExtra("lat", Lat);
            mv.putExtra("lng", Lng);
            mv.putExtra("name", spinnerCentername.getSelectedItem().toString());
            mv.putExtra("address", Address);
            mv.putExtra("phone", CenterPhone);
            startActivity(mv);
        }


    }

    public void spinnerSido(List<Datum> list) {


        //String[] strings_sigungu_copy;
        //String[] strings_org = new String[list.size()];



        String[] strings_sido_1 = new String[list.size()];

        ArrayList<String> temp = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                temp.add(list.get(i).getSido());
            } else {

                boolean check = true;

                for (int j = 0; j < i; j++) {
                    if (temp.get(j).equals(list.get(i).getSido())) {
                        check = false;
                    }
                }
                if (check) temp.add(list.get(i).getSido());

            }
        }

        //중복 제거 작업
        String[] strings_sido = new String[temp.size()];

        for (int k=0;k<temp.size();k++){
            strings_sido[k] = temp.get(k);
        }




//        for (int i = 0; i < list.size(); i++) {
//
//            strings_sido_1[i] = list.get(i).getSido();
//        }
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.size(); i++) {
//                // 1-서울 2-경기 3-부산 4-부산
//                if (strings_sido_1[i].equals(strings_sido_1[j])) {
//
//                } else {
//                    strings_sido[i] = list.get(i).getSido();
//                }
//            }
//
//        }


        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, strings_sido);
        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerSido.setAdapter(aa);
        spinnerSido.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //    Toast.makeText(getApplicationContext() , ""+spinnerSido.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                // for

                ArrayList<String> arrayList = new ArrayList<>();

                for (int i = 0; i < strings_sido.length; i++) {
                    if (spinnerSido.getSelectedItem().toString().equals(strings_sido[i])) {
                        arrayList.add(list.get(i).getSigungu());
                    }
                }
                String[] strings_sigungu = new String[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    strings_sigungu[i] = arrayList.get(i);
                }

                ArrayAdapter<String> bb = new ArrayAdapter<String>(Medical_center.this,
                        android.R.layout.simple_dropdown_item_1line, strings_sigungu);
                bb.setDropDownViewResource(
                        android.R.layout.simple_spinner_dropdown_item);
                spinnerSigungu.setAdapter(bb);
                spinnerSigungu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        ArrayList<String> arrayList2 = new ArrayList<>();

//                        for (int i = 0; i < strings_sigungu.length; i++) {
//                            if (spinnerSigungu.getSelectedItem().toString().equals(strings_sigungu[i])) {
//                                arrayList2.add(list.get(i).getCenterName());
//                            }
//                        }

                        for (int i = 0; i < list.size(); i++) {
                            if (spinnerSigungu.getSelectedItem().toString().equals(list.get(i).getSigungu())) {
                                arrayList2.add(list.get(i).getCenterName());
                            }
                        }

                        String[] strings_centername = new String[arrayList2.size()];
                        for (int i = 0; i < arrayList2.size(); i++) {
                            strings_centername[i] = arrayList2.get(i);
                        }


                        ArrayAdapter<String> cc = new ArrayAdapter<String>(Medical_center.this,
                                android.R.layout.simple_dropdown_item_1line, strings_centername);
                        cc.setDropDownViewResource(
                                android.R.layout.simple_spinner_dropdown_item);
                        spinnerCentername.setAdapter(cc);
                        spinnerCentername.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                ArrayList<String> arrayList3 = new ArrayList<>();

                                for (int i = 0; i < strings_centername.length; i++) {
                                    if (spinnerCentername.getSelectedItem().toString().equals(strings_centername[i])) {
                                        Lat = list.get(i).getLat();
                                        Lng = list.get(i).getLng();
                                        CenterPhone = list.get(i).getPhoneNumber();
                                    }
                                }
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

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}